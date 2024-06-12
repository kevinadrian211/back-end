package com.example.back.service

import com.example.back.entity.Scene
import com.example.back.repository.FilmRepository
import com.example.back.repository.SceneRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class SceneService {

    @Autowired
    private lateinit var filmRepository: FilmRepository

    @Autowired
    lateinit var sceneRepository: SceneRepository

    fun list(): List<Scene> {
        return sceneRepository.findAll()
    }

    fun save(scene: Scene): Scene {
        try {
            val film = filmRepository.findById(scene.film?.id!!).orElseThrow {
                Exception("Film not found")
            }
            val totalMinutes = sceneRepository.sumMinutesByFilmId(scene.film?.id!!) ?: 0
            if (totalMinutes + scene.duration > film.duration) {
                throw Exception("Exceeds film duration limit")
            }
            return sceneRepository.save(scene)
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.BAD_REQUEST, ex.message)
        }
    }

    fun update(scene: Scene): Scene {
        try {
            sceneRepository.findById(scene.id!!)
                ?: throw Exception("Scene not found")
            return sceneRepository.save(scene)
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }

    fun delete(id: Long) {
        try {
            val sceneOptional = sceneRepository.findById(id)
            if (sceneOptional.isPresent) {
                val scene = sceneOptional.get()
                sceneRepository.delete(scene)
            } else {
                throw ResponseStatusException(HttpStatus.NOT_FOUND, "No scene found with provided ID")
            }
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error deleting scene", ex)
        }
    }
}

package com.example.back.service

import com.example.back.entity.Film
import com.example.back.repository.FilmRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class FilmService {

    @Autowired
    lateinit var filmRepository: FilmRepository

    fun list(): List<Film> {
        return filmRepository.findAll()
    }

    fun save(film: Film): Film {
        return filmRepository.save(film)
    }

    fun update(film: Film): Film {
        try {
            filmRepository.findById(film.id)
                ?: throw Exception("Film not found")
            return filmRepository.save(film)
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }

    fun delete(id: Long) {
        try {
            val filmOptional = filmRepository.findById(id)
            if (filmOptional.isPresent) {
                val film = filmOptional.get()
                filmRepository.delete(film)
            } else {
                throw ResponseStatusException(HttpStatus.NOT_FOUND, "No film found with provided ID")
            }
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error deleting film", ex)
        }
    }

}

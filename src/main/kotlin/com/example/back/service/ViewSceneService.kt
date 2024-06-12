package com.example.back.service

import com.example.back.entity.ViewScene
import com.example.back.repository.ViewSceneRepository
import org.springframework.stereotype.Service

@Service
class ViewSceneService(private val viewSceneRepository: ViewSceneRepository) {

    fun listScenesWithFilm(): List<ViewScene> {
        return viewSceneRepository.findAll()
    }
}

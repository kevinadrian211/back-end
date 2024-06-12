package com.example.back.controller

import com.example.back.entity.ViewScene
import com.example.back.service.ViewSceneService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/scenes")
class ViewSceneController(private val viewSceneService: ViewSceneService) {

    @GetMapping("/with-film")
    fun listScenesWithFilm(): List<ViewScene> {
        return viewSceneService.listScenesWithFilm()
    }
}

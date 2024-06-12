package com.example.back.controller

import com.example.back.entity.ViewCharacter
import com.example.back.service.ViewCharacterService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/characters")
class ViewCharacterController(private val viewCharacterService: ViewCharacterService) {

    @GetMapping
    fun getAllCharacters(): List<ViewCharacter> {
        return viewCharacterService.getAllCharacters()
    }
}

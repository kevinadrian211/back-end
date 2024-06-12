package com.example.back.service

import com.example.back.entity.ViewCharacter
import com.example.back.repository.ViewCharacterRepository
import org.springframework.stereotype.Service

@Service
class ViewCharacterService(private val viewCharacterRepository: ViewCharacterRepository) {

    fun getAllCharacters(): List<ViewCharacter> {
        return viewCharacterRepository.findAll()
    }
}

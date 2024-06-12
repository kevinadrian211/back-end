package com.example.back.repository

import com.example.back.entity.ViewCharacter
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ViewCharacterRepository : JpaRepository<ViewCharacter, Long>

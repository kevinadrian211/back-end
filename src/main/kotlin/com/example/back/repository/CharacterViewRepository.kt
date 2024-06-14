package com.example.back.repository

import com.example.back.entity.CharacterView
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CharacterViewRepository : JpaRepository<CharacterView, Long>

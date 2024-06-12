package com.example.back.repository

import com.example.back.entity.Film
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface FilmRepository : JpaRepository<Film, Long> {
    fun findById(id: Long?): Film?
}

package com.example.back.repository

import com.example.back.entity.Scene
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface SceneRepository : JpaRepository<Scene, Long> {
    fun findById(id: Long?): Scene?

    @Query("SELECT SUM(s.duration) FROM Scene s WHERE s.film.id = :filmId")
    fun sumMinutesByFilmId(filmId: Long?): Long
}

package com.example.back.repository

import com.example.back.entity.MovieCharacter
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface MovieCharacterRepository : JpaRepository<MovieCharacter, Long> {
    fun findById(id: Long?): MovieCharacter?

    @Query("SELECT SUM(c.cost) FROM movie_character c WHERE c.film_id = :filmId", nativeQuery = true)
    fun sumTotalCostByFilmId(@Param("filmId") filmId: Long): Double?

    @Query("SELECT SUM(s.duration) FROM scene s WHERE s.film_id = :filmId", nativeQuery = true)
    fun sumMinutesByFilmId(@Param("filmId") filmId: Long): Long?
}

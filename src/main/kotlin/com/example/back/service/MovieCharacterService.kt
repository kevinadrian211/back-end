package com.example.back.service

import com.example.back.entity.MovieCharacter
import com.example.back.repository.MovieCharacterRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class MovieCharacterService {

    @Autowired
    private lateinit var movieCharacterRepository: MovieCharacterRepository

    fun list(): List<MovieCharacter> {
        return movieCharacterRepository.findAll()
    }

    fun save(movieCharacter: MovieCharacter): MovieCharacter {
        return movieCharacterRepository.save(movieCharacter)
    }

    fun update(movieCharacter: MovieCharacter): MovieCharacter {
        try {
            movieCharacterRepository.findById(movieCharacter.id)
                ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "Movie Character not found")
            return movieCharacterRepository.save(movieCharacter)
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error updating movie character", ex)
        }
    }

    fun delete(id: Long) {
        try {
            val movieCharacterOptional = movieCharacterRepository.findById(id)
            if (movieCharacterOptional.isPresent) {
                val movieCharacter = movieCharacterOptional.get()
                movieCharacterRepository.delete(movieCharacter)
            } else {
                throw ResponseStatusException(HttpStatus.NOT_FOUND, "No movie character found with provided ID")
            }
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error deleting movie character", ex)
        }
    }

    fun calculateTotalCostAndDuration(filmId: Long): Pair<Double, Long> {
        val totalCost = movieCharacterRepository.sumTotalCostByFilmId(filmId)
        val totalDuration = movieCharacterRepository.sumMinutesByFilmId(filmId)
        return Pair(totalCost ?: 0.0, totalDuration ?: 0L)
    }

    fun compareCostAndDuration(filmId: Long): Boolean {
        val (totalCost, totalDuration) = calculateTotalCostAndDuration(filmId)
        return totalCost >= totalDuration
    }
}
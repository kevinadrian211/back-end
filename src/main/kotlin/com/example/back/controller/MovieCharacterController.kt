package com.example.back.controller

import com.example.back.entity.MovieCharacter
import com.example.back.service.MovieCharacterService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/character")
class MovieCharacterController {

    @Autowired
    lateinit var movieCharacterService: MovieCharacterService

    @GetMapping
    fun list(): List<MovieCharacter> {
        return movieCharacterService.list()
    }

    @PostMapping
    fun save(@RequestBody character: MovieCharacter): MovieCharacter {
        return movieCharacterService.save(character)
    }

    @PutMapping
    fun update(@RequestBody character: MovieCharacter): ResponseEntity<MovieCharacter> {
        return ResponseEntity(movieCharacterService.update(character), HttpStatus.OK)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<String> {
        movieCharacterService.delete(id)
        return ResponseEntity.ok("Character deleted successfully")
    }

    @GetMapping("/compare-cost-duration/{filmId}")
    fun compareCostAndDuration(@PathVariable filmId: Long): ResponseEntity<String> {
        return try {
            val result = movieCharacterService.compareCostAndDuration(filmId)
            ResponseEntity.ok("Comparison result: $result")
        } catch (ex: Exception) {
            ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.message)
        }
    }
}

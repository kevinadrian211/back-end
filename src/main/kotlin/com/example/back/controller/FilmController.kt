package com.example.back.controller

import com.example.back.entity.Film
import com.example.back.service.FilmService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/films") // Cambiado a "/films" para reflejar mejor la entidad manejada
@CrossOrigin(methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.PUT, RequestMethod.DELETE])
class FilmController {

    @Autowired
    lateinit var filmService: FilmService

    @GetMapping
    fun list(): ResponseEntity<List<Film>> {
        val films = filmService.list()
        return ResponseEntity.ok(films)
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<Film> {
        val film = filmService.findAll(id)
        return ResponseEntity.ok(film)
    }

    @PostMapping
    fun save(@RequestBody film: Film): ResponseEntity<Film> {
        val savedFilm = filmService.save(film)
        return ResponseEntity.status(HttpStatus.CREATED).body(savedFilm)
    }

    @PutMapping
    fun update(@RequestBody film: Film): ResponseEntity<Film> {
        val updatedFilm = filmService.update(film)
        return ResponseEntity.ok(updatedFilm)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<String> {
        filmService.delete(id)
        return ResponseEntity.ok("Film deleted successfully")
    }
}

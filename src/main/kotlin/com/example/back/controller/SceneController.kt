package com.example.back.controller

import com.example.back.entity.Scene
import com.example.back.service.SceneService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/scene")
class SceneController {

    @Autowired
    lateinit var sceneService: SceneService

    @GetMapping
    fun list(): List<Scene> {
        return sceneService.list()
    }

    @PostMapping
    fun save(@RequestBody scene: Scene): Scene {
        return sceneService.save(scene)
    }

    @PutMapping
    fun update(@RequestBody scene: Scene): ResponseEntity<Scene> {
        return ResponseEntity(sceneService.update(scene), HttpStatus.OK)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<String> {
        sceneService.delete(id)
        return ResponseEntity.ok("Scene deleted successfully")
    }

    @PostMapping("/add")
    fun addScene(@RequestBody scene: Scene): ResponseEntity<Scene> {
        return try {
            val savedScene = sceneService.save(scene)
            ResponseEntity(savedScene, HttpStatus.CREATED)
        } catch (e: Exception) {
            ResponseEntity(HttpStatus.BAD_REQUEST)
        }
    }
}

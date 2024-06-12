package com.example.back.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "view_scene")
class ViewScene(
    @Id
    @Column(name = "scene_id", updatable = false)
    val id: Long,
    val description: String,
    val budget: Double,
    val duration: Int,
    @Column(name = "film_id")
    val filmId: Long,
    @Column(name = "film_title")
    val filmTitle: String
)

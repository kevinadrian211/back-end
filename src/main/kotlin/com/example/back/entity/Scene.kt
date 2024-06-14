package com.example.back.entity

import jakarta.persistence.*

@Entity
@Table(name = "scene")
data class Scene(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    var id: Long? = null,

    @Column(nullable = false)
    var description: String,

    @Column(nullable = false)
    var budget: Double,

    @Column(nullable = false)
    var duration: Int,

    var filmId: Long
)

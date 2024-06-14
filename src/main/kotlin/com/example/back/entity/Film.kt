package com.example.back.entity

import jakarta.persistence.*

@Entity
@Table(name = "film")
class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    var id: Long? = null

    @Column(nullable = false)
    var title: String = ""

    @Column(nullable = false)
    var director: String = ""

    @Column(nullable = false)
    var synopsis: String = ""

    @Column(nullable = false)
    var duration: Int = 0
}

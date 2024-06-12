package com.example.back.entity

import jakarta.persistence.*

@Entity
@Table(name = "movie_character")
class MovieCharacter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    var id: Long? = null

    @Column(nullable = false)
    var name: String = ""

    @Column(nullable = false)
    var actor: String = ""

    @Column(nullable = false)
    var cost: Double = 0.0

    @Column(nullable = false)
    var role: String = ""

    @Column(nullable = false)
    var stock: Int = 1

    @ManyToOne
    @JoinColumn(name = "film_id", nullable = false)
    var film: Film? = null
}

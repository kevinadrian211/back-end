package com.example.back.entity

import jakarta.persistence.*

@Entity
@Table(name = "view_character")
class ViewCharacter {
    @Id
    @Column(name = "character_id")
    var characterId: Long? = null

    @Column(name = "character_name")
    var characterName: String? = null

    // Agrega los otros campos de la vista aquí...

    @Column(name = "scene_description")
    var sceneDescription: String? = null
}

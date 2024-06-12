package com.example.back.repository

import com.example.back.entity.ViewScene
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ViewSceneRepository : JpaRepository<ViewScene, Long>

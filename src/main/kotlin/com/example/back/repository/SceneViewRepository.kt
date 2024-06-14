package com.example.back.repository

import com.example.back.entity.SceneView
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SceneViewRepository : JpaRepository<SceneView, Long>

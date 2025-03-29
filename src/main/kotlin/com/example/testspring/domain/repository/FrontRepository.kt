package com.example.testspring.domain.repository

import com.example.testspring.domain.entity.Front
import org.springframework.data.jpa.repository.JpaRepository

interface FrontRepository : JpaRepository<Front, Long> {
    fun findFrontById(id : Long) : Front?
}
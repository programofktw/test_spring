package com.example.testspring.domain.repository

import com.example.testspring.domain.entity.Db
import org.springframework.data.jpa.repository.JpaRepository

interface DbRepository : JpaRepository<Db, Long> {
    fun findDbById(id : Long) : Db?
}
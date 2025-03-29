package com.example.testspring.domain.repository

import com.example.testspring.domain.entity.Back
import org.springframework.data.jpa.repository.JpaRepository

interface BackRepository : JpaRepository<Back, Long>{
}
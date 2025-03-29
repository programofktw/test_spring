package com.example.testspring.domain.controller

import com.example.testspring.domain.service.BackService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

@RestController
class TestController(
    val backService: BackService
) {

    @GetMapping("/test")
    fun testAdd() {
        backService.testAdd()



    }

    @GetMapping("/compare")
    fun testCompare(): ResponseEntity<MutableMap<String, String>>{
        val result = backService.testCompare1()
        val result2 = backService.testCompare2()

        val map : MutableMap<String, String> = mutableMapOf()
        map.put("compare1", "$result")
        map.put("compare2", "$result2")
        map["compare3"] = backService.testCompare3().toString()
        map["compare4"] = backService.testCompare4().toString()
        return ResponseEntity.ok(map)
    }
}
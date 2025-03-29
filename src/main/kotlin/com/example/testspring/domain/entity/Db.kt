package com.example.testspring.domain.entity

import jakarta.persistence.*

@Entity
class Db(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id : Long? = null,

    @Column
    var dbPort: String? = "3306",

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "back_id")
    var back: Back? = null
)
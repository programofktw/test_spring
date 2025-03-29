package com.example.testspring.domain.entity

import jakarta.persistence.*

@Entity
class Back(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id : Long? = null,

    @Column
    var body: String? = "TEST",

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "back", cascade = [CascadeType.ALL], orphanRemoval = true)
    var dbList: MutableList<Db> = mutableListOf(),

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "back", cascade = [CascadeType.ALL], orphanRemoval = true)
    var frontList: MutableList<Front> = mutableListOf()
)

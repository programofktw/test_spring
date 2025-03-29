package com.example.testspring.domain.entity

import com.fasterxml.jackson.databind.ser.Serializers.Base
import jakarta.persistence.*

@Entity
class Front(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id : Long? = null,

    @Column
    var domain: String?,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "back_id")
    var back: Back? = null
)
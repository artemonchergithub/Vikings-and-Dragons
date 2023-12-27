package com.example.vikings.model

import jakarta.persistence.*
import org.springframework.format.annotation.DateTimeFormat
import java.util.Date

@Entity
class Dragon(

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Int = 0,

    @Column
    val name: String? = null,

    @Column(name = "discovery_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    val discoveryDate: Date? = null,

    @Column
    val length: Double? = null,

    @Column
    val width: Double? = null,

    @Column
    val wingspan: Double? = null,

    @Column(name = "life_expectancy")
    val lifeExpectancy: Int? = null
)
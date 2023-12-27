package com.example.vikings.model

import jakarta.persistence.*
import org.springframework.format.annotation.DateTimeFormat
import java.util.*

@Entity
class Viking (

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Int = 0,

    @Column
    val name: String? = null,

    @Column(name = "birth_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    val birthDate: Date? = null,

    @Column
    val height: Double? = null,

    @Column(name = "flight_time")
    val flightTime: Int? = null,

    @ManyToOne
    @JoinColumn(name = "dragon", referencedColumnName = "id", foreignKey = ForeignKey(name = "FK_DRAGON_VIKING", foreignKeyDefinition = "FOREIGN KEY (dragon) REFERENCES Dragon(id) ON DELETE SET NULL"))
    val dragon: Dragon? = null
)
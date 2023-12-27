package com.example.vikings.repository

import com.example.vikings.model.Viking
import org.springframework.data.jpa.repository.JpaRepository

interface VikingRepository: JpaRepository<Viking, Int> {

    fun findAllByOrderByName() : MutableList<Viking>

    fun findAllByOrderByBirthDate() : MutableList<Viking>

    fun findAllByOrderByHeight() : MutableList<Viking>

    fun findAllByOrderByFlightTime() : MutableList<Viking>

    fun findAllByOrderByNameDesc() : MutableList<Viking>

    fun findAllByOrderByBirthDateDesc() : MutableList<Viking>

    fun findAllByOrderByHeightDesc() : MutableList<Viking>

    fun findAllByOrderByFlightTimeDesc() : MutableList<Viking>

    fun findAllByOrderByNameAscBirthDateAscHeightAscFlightTimeAsc() : MutableList<Viking>

    fun findAllByOrderByNameDescBirthDateDescHeightDescFlightTimeDesc() : MutableList<Viking>

}
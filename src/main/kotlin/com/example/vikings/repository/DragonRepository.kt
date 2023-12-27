package com.example.vikings.repository

import com.example.vikings.model.Dragon
import com.example.vikings.model.Viking
import org.springframework.data.jpa.repository.JpaRepository

interface DragonRepository: JpaRepository<Dragon, Int> {

    fun findAllByOrderByName() : MutableList<Dragon>

    fun findAllByOrderByDiscoveryDate() : MutableList<Dragon>

    fun findAllByOrderByLength() : MutableList<Dragon>

    fun findAllByOrderByWidth() : MutableList<Dragon>

    fun findAllByOrderByWingspan() : MutableList<Dragon>

    fun findAllByOrderByLifeExpectancy() : MutableList<Dragon>

    fun findAllByOrderByNameDesc() : MutableList<Dragon>

    fun findAllByOrderByDiscoveryDateDesc() : MutableList<Dragon>

    fun findAllByOrderByLengthDesc() : MutableList<Dragon>

    fun findAllByOrderByWidthDesc() : MutableList<Dragon>

    fun findAllByOrderByWingspanDesc() : MutableList<Dragon>

    fun findAllByOrderByLifeExpectancyDesc() : MutableList<Dragon>

    fun findAllByOrderByNameAscDiscoveryDateAscLengthAscWidthAscWingspanAscLifeExpectancyAsc() : MutableList<Dragon>

    fun findAllByOrderByNameDescDiscoveryDateDescLengthDescWidthDescWingspanDescLifeExpectancyDesc() : MutableList<Dragon>

}
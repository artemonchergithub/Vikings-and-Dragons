package com.example.vikings.services

import com.example.vikings.model.Dragon
import com.example.vikings.repository.DragonRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class DragonService(@Autowired private val dragonRepository: DragonRepository) {

    fun getAllDragons(): List<Dragon> {
        return dragonRepository.findAllByOrderByName() // Получение всех драконов из репозитория
    }

    fun getDragonById(id: Int): Dragon? {
        return dragonRepository.findById(id).orElse(null)
    }

    fun saveDragon(dragon: Dragon): Dragon {
        return dragonRepository.save(dragon)
    }

    fun deleteDragon(id: Int) {
        dragonRepository.deleteById(id)
    }
    fun getAllDragonsSortedByName(order: String?): List<Dragon> {
        return if (order != null) {
            if (order == "desc")
                dragonRepository.findAllByOrderByNameDesc()
            else
                dragonRepository.findAllByOrderByName()
        } else {
            dragonRepository.findAllByOrderByNameDesc();
        }
    }

    fun getAllDragonsSortedByDiscoveryDate(order: String?): List<Dragon> {
        return if (order != null) {
            if (order == "desc")
                dragonRepository.findAllByOrderByDiscoveryDateDesc()
            else
                dragonRepository.findAllByOrderByDiscoveryDate()
        } else {
            dragonRepository.findAllByOrderByDiscoveryDateDesc();
        }
    }

    fun getAllDragonsSortedByLength(order: String?): List<Dragon> {
        return if (order != null) {
            if (order == "desc")
                dragonRepository.findAllByOrderByLengthDesc()
            else
                dragonRepository.findAllByOrderByLength()
        } else {
            dragonRepository.findAllByOrderByLengthDesc();
        }
    }

    fun getAllDragonsSortedByWidth(order: String?): List<Dragon> {
        return if (order != null) {
            if (order == "desc")
                dragonRepository.findAllByOrderByWidthDesc()
            else
                dragonRepository.findAllByOrderByWidth()
        } else {
            dragonRepository.findAllByOrderByWidthDesc();
        }
    }

    fun getAllDragonsSortedByWingspan(order: String?): List<Dragon> {
        return if (order != null) {
            if (order == "desc")
                dragonRepository.findAllByOrderByWingspanDesc()
            else
                dragonRepository.findAllByOrderByWingspan()
        } else {
            dragonRepository.findAllByOrderByWingspanDesc();
        }
    }

    fun getAllDragonsSortedByLifeExpectancy(order: String?): List<Dragon> {
        return if (order != null) {
            if (order == "desc")
                dragonRepository.findAllByOrderByLifeExpectancyDesc()
            else
                dragonRepository.findAllByOrderByLifeExpectancy()
        } else {
            dragonRepository.findAllByOrderByLifeExpectancyDesc()
        }
    }
}
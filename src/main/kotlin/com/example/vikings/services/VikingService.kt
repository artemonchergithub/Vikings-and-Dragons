package com.example.vikings.services

import com.example.vikings.model.Viking
import com.example.vikings.repository.VikingRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
class VikingService(
    @Autowired private val vikingRepository: VikingRepository,
    @Autowired private val dragonService: DragonService
)
{

    fun getAllVikings(): List<Viking> {
        return vikingRepository.findAllByOrderByName() // Получение всех викингов из репозитория
    }

    fun getVikingById(id: Int): Viking? {
        return vikingRepository.findById(id).orElse(null)
    }

    fun saveViking(viking: Viking): Viking {
//        dragonService.saveDragon(viking.dragon!!)
        return vikingRepository.save(viking)
    }

    fun deleteViking(id: Int) {
        vikingRepository.deleteById(id)
    }

    fun getAllVikingsSortedByName(order: String?): List<Viking> {
        return if (order != null) {
            if (order == "desc")
                vikingRepository.findAllByOrderByNameDesc()
            else
                vikingRepository.findAllByOrderByName()
        } else {
            vikingRepository.findAllByOrderByNameDesc()
        }
    }

    fun getAllVikingsSortedByBirthDate(order: String?): List<Viking> {
        return if (order != null) {
            if (order == "desc")
                vikingRepository.findAllByOrderByBirthDateDesc()
            else
                vikingRepository.findAllByOrderByBirthDate()
        } else {
            vikingRepository.findAllByOrderByBirthDateDesc()
        }
    }

    fun getAllVikingsSortedByHeight(order: String?): List<Viking> {
        return if (order != null) {
            if (order == "desc")
                vikingRepository.findAllByOrderByHeightDesc()
            else
                vikingRepository.findAllByOrderByHeight()
        } else {
            vikingRepository.findAllByOrderByHeightDesc()
        }
    }

    fun getAllVikingsSortedByFlightTime(order: String?): List<Viking> {
        return if (order != null) {
            if (order == "desc")
                vikingRepository.findAllByOrderByFlightTimeDesc()
            else
                vikingRepository.findAllByOrderByFlightTime()
        } else {
            vikingRepository.findAllByOrderByFlightTimeDesc()
        }
    }
}

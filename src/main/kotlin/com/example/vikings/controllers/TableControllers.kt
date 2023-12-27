package com.example.vikings.controllers

import com.example.vikings.model.Dragon
import com.example.vikings.model.Viking
import com.example.vikings.repository.DragonRepository
import com.example.vikings.repository.VikingRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.time.Instant
import java.util.*

@RestController
@RequestMapping("/started")
class DragonAndVikingsController(
    @Autowired private val dragonRepository: DragonRepository,
    @Autowired private val vikingRepository: VikingRepository
) {

    @GetMapping
    fun whatever() {
        var dragon = Dragon(1, "Nightfury", Date(2010,10,11), 22.0, 33.0, 5.0, 100)
        var dragon2 = Dragon(2, "Zubodav", Date(2016,2,11), 22123.0, 31233.0, 5123.0, 1090)
        var dragon3 = Dragon(2, "Zubodav", Date(2016,2,11), 22123.0, 31233.0, 5123.0, 1090)
        dragon = dragonRepository.save(dragon)
        dragon2 = dragonRepository.save(dragon2)
        vikingRepository.save(Viking(1, "Hiccup", Date(2010,10,14), 1.3, 41, dragon))
        vikingRepository.save(Viking(2, "Balgur", Date(2012,5,1), 1.9, 21, dragon2))
        vikingRepository.save(Viking(3, "Ulfrik", Date(2002,8,21), 2.0, 23, dragon))
        vikingRepository.save(Viking(3, "Ulfrik", Date(1998,4,14), 2.1, 88, dragon3))
    }
}

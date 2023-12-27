package com.example.vikings.controllers

import com.example.vikings.model.Viking
import com.example.vikings.services.DragonService
import com.example.vikings.services.VikingService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*
import java.sql.DriverManager.println
import java.time.Instant
import java.util.*

@Controller
@RequestMapping("/vikings")
class VikingController(private val vikingService: VikingService, private val dragonService: DragonService) {

    @GetMapping
    fun getSortedVikings(
        @RequestParam(required = false) sort: String?,
        @RequestParam(required = false, defaultValue = "asc") order: String?,
        model: Model
    ): String {
        val vikings = when (sort) {
            "name" -> vikingService.getAllVikingsSortedByName(order)
            "birthDate" -> vikingService.getAllVikingsSortedByBirthDate(order)
            "height" -> vikingService.getAllVikingsSortedByHeight(order)
            "flightTime" -> vikingService.getAllVikingsSortedByFlightTime(order)
            else -> vikingService.getAllVikingsSortedByName(order) // Если sort не указан, сортируем по умолчанию
        }
        model.addAttribute("vikings", vikings)
        return "vikings" // Имя вашего шаблона для списка викингов
    }

    // Отображение формы для создания нового дракона
    @GetMapping("/new")
    fun newVikingForm(model: Model): String {
        val dragons = dragonService.getAllDragons() // Получаем список всех драконов
        model.addAttribute("dragons", dragons)
        model.addAttribute("viking", Viking()) // Возможно, вам нужно передать пустого викинга для формы
        return "viking-new-form" // Имя вашего шаблона для формы викинга
    }

    // Обработка запроса на создание нового дракона
    @PostMapping("/new")
    fun createViking(@ModelAttribute("viking") viking: Viking): String {
        vikingService.saveViking(viking)
        return "redirect:/vikings"
    }


    @GetMapping("/{id}")
    fun showViking(@PathVariable id: Int, model: Model): String {
        val viking = vikingService.getVikingById(id)
        model.addAttribute("viking", viking)
        return "viking-details" // Название страницы для отображения деталей викинга
    }

    @GetMapping("/{id}/edit")
    fun editVikingForm(@PathVariable id: Int, model: Model): String {
        val viking = vikingService.getVikingById(id)
        val dragons = dragonService.getAllDragons() // Получаем список всех драконов
        model.addAttribute("viking", viking ?: Viking())
        model.addAttribute("dragons", dragons)

        println("edit check")

        return "viking-edit-form" // Название страницы для редактирования викинга
    }

    @PostMapping("/{id}/edit")
    fun editDragon(@ModelAttribute("viking") viking: Viking): String {
        vikingService.saveViking(viking)
        return "redirect:/vikings"
    }

    @GetMapping("/{id}/delete")
    fun deleteViking(@PathVariable id: Int): String {
        vikingService.deleteViking(id)
        return "redirect:/vikings"
    }

    // Другие методы для редактирования, удаления и просмотра отдельных драконов
    // ...
}
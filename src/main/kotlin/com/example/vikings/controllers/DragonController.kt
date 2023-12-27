package com.example.vikings.controllers

import com.example.vikings.model.Dragon
import com.example.vikings.services.DragonService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*
import java.util.*

@Controller
@RequestMapping("/dragons")
class DragonController(private val dragonService: DragonService) {

    // Получение списка всех драконов
    @GetMapping
    fun getSortedDragons(
        @RequestParam(required = false) sort: String?,
        @RequestParam(required = false, defaultValue = "asc") order: String?,
        model: Model
    ): String {
        val dragons = when (sort) {
            "name" -> dragonService.getAllDragonsSortedByName(order)
            "discoveryDate" -> dragonService.getAllDragonsSortedByDiscoveryDate(order)
            "length" -> dragonService.getAllDragonsSortedByLength(order)
            "width" -> dragonService.getAllDragonsSortedByWidth(order)
            "wingspan" -> dragonService.getAllDragonsSortedByWingspan(order)
            "lifeExpectancy" -> dragonService.getAllDragonsSortedByLifeExpectancy(order)
            else -> dragonService.getAllDragons() // Если sort не указан, получаем обычный список
        }
        model.addAttribute("dragons", dragons)
        return "dragons" // Имя вашего шаблона для списка драконов
    }
    // Отображение формы для создания нового дракона
    @GetMapping("/new")
    fun newDragonForm(model: Model): String {
        model.addAttribute("dragon", Dragon())
        return "dragon-new-form"
    }

    // Обработка запроса на создание нового дракона
    @PostMapping("/new")
    fun createDragon(@ModelAttribute("dragon") dragon: Dragon): String {
        dragonService.saveDragon(dragon)
        return "redirect:/dragons"
    }

    @GetMapping("/{id}")
    fun showDragon(@PathVariable id: Int, model: Model): String {
        val dragon = dragonService.getDragonById(id)
        model.addAttribute("dragon", dragon)
        return "dragon-details" // Название страницы для отображения деталей дракона
    }

    @GetMapping("/{id}/edit")
    fun editDragonForm(@PathVariable id: Int, model: Model): String {
        val dragon = dragonService.getDragonById(id)
        model.addAttribute("dragon", dragon)
        return "dragon-form" // Название страницы для редактирования дракона
    }

    @GetMapping("/{id}/delete")
    fun deleteDragon(@PathVariable id: Int): String {
        dragonService.deleteDragon(id)
        return "redirect:/dragons"
    }
}
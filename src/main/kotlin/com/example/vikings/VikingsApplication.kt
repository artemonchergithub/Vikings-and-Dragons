package com.example.vikings

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.ConfigurableApplicationContext
import java.awt.Desktop
import java.io.IOException
import java.net.URI

@SpringBootApplication
class VikingsApplication

private var ctx: ConfigurableApplicationContext? = null

fun main(args: Array<String>) {
    try {
        if (Desktop.isDesktopSupported()) {
            val desktop = Desktop.getDesktop()
            if (desktop.isSupported(Desktop.Action.BROWSE)) {
                desktop.browse(URI.create("http://localhost:8080/h2-console"))
                desktop.browse(URI.create("http://localhost:8080/vikings"))
            }
        }
    } catch (e: IOException) {
        e.printStackTrace()
    } catch (e: InternalError) {
        e.printStackTrace()
    }
    runApplication<VikingsApplication>(*args)
}



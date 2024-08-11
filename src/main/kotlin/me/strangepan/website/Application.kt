package me.strangepan.website

import io.ktor.server.application.Application
import io.ktor.server.netty.EngineMain
import me.strangepan.website.plugins.configureRouting

fun main(args: Array<String>): Unit = EngineMain.main(args)

fun Application.module() {
  configureRouting()
}

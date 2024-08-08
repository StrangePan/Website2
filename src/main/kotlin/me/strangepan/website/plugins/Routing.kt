package me.strangepan.website.plugins

import io.ktor.server.application.Application
import io.ktor.server.application.call
import io.ktor.server.application.install
import io.ktor.server.html.respondHtml
import io.ktor.server.http.content.staticResources
import io.ktor.server.resources.Resources
import io.ktor.server.routing.get
import io.ktor.server.routing.routing
import me.strangepan.website.home.HOME_PAGE

fun Application.configureRouting() {
  install(Resources)
  routing {
    get("/") {
      call.respondHtml(block = HOME_PAGE)
    }
    staticResources("/templates", "templates")
    staticResources("/images", "images")
    staticResources("/content", "content")
  }
}

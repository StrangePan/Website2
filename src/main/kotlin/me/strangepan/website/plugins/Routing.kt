package me.strangepan.website.plugins

import io.ktor.http.HttpStatusCode
import io.ktor.server.application.Application
import io.ktor.server.application.call
import io.ktor.server.application.install
import io.ktor.server.html.respondHtml
import io.ktor.server.http.content.staticResources
import io.ktor.server.plugins.statuspages.StatusPages
import io.ktor.server.resources.Resources
import io.ktor.server.routing.get
import io.ktor.server.routing.routing
import me.strangepan.website.errors.error403
import me.strangepan.website.errors.error404
import me.strangepan.website.errors.error500
import me.strangepan.website.home.HOME_PAGE

fun Application.configureRouting() {
  install(Resources)
  install(StatusPages) {
    status(HttpStatusCode.NotFound) { call, code ->
      call.respondHtml(code, error404())
    }
    status(HttpStatusCode.Forbidden) { call, code ->
      call.respondHtml(code, error403())
    }
    status(HttpStatusCode.InternalServerError) { call, code ->
      call.respondHtml(code, error500())
    }
  }
  routing {
    get("/") {
      call.respondHtml(HttpStatusCode.OK, HOME_PAGE)
    }
    staticResources("/templates", "templates")
    staticResources("/images", "images")
    staticResources("/content", "content")
  }
}

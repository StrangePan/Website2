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
import me.strangepan.website.pages.home.homePage
import me.strangepan.website.pages.projects.projectsPage
import me.strangepan.website.pages.resume.resumePage

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
      call.respondHtml(HttpStatusCode.OK, homePage())
    }
    get("/resume") {
      call.respondHtml(HttpStatusCode.OK, resumePage())
    }
    get("/projects") {
      call.respondHtml(HttpStatusCode.OK, projectsPage())
    }
    staticResources("/templates", "templates")
    staticResources("/images", "images")
    staticResources("/content", "content")
    staticResources("/files", "files")
    staticResources("/projects", "projects")
  }
}

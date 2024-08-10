package me.strangepan.website.pages.projects

import kotlinx.html.*
import me.strangepan.website.composure.composure
import me.strangepan.website.markdown.markdown

data class Project(
  val name: String,
  val description: String,
  val thumbnail: String,
  val directory: String,
) {
  val thumbnailUrl get() = "/images/$thumbnail"
  val pageUrl get() = "/projects/$directory/"
}

fun projectsPage(): HTML.() -> Unit = {
  val projects = arrayOf(
    Project(
      name = "Scuffle",
      description = "A PICO-8 game created for the Extra Credits Game Jam 5. Created by Dan Andrus and Alexander Biggs.",
      thumbnail = "project-scuffle-thumbnail.png",
      directory = "scuffle"),
    Project(
      name = "Parallax Scrolling",
      description = "A small experiment in parallax scrolling effects, written from scratch using jQuery.",
      thumbnail = "project-parallax-thumbnail.jpg",
      directory = "parallax"),
//    Project(
//      name = "Stacker!",
//      description = "A simple game based on the arcade game by the same name using pure HTML5.",
//      thumbnail = "project-stacker-thumbnail.png",
//      directory = "stacker"),
//    Project(
//      name = "YouTube Theater",
//      description = "An easy way to watch YouTube videos without distraction.",
//      thumbnail = "project-yttheater-thumbnail.jpg",
//      directory = "web-theater"),
  )

  composure("Projects") {
    article(classes = "front-and-center") {
      markdown("projects.md")
    }

    ul(classes = "project-list") {
      for (project in projects) {
        li {
          a(href = project.pageUrl) {
            img(classes = "thumbnail", src = project.thumbnailUrl)
            h2 { +project.name }
          }
        }
      }
    }
  }
}

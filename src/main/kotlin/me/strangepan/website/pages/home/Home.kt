package me.strangepan.website.pages.home

import kotlinx.html.*
import me.strangepan.website.composure.composure
import me.strangepan.website.markdown.markdown
import me.strangepan.website.pages.projects.Project

fun homePage(): HTML.() -> Unit = {
  composure(title = "Dan Andrus") {
    comment("Home page welcome")
    article(classes = "welcome front-and-center") {
      h1 {
        +"Welcome"
      }
      p {
        entity(Entities.hellip)
        +"to my hand-coded personal website."
      }
      p {
        +"Check out some of my personal and professional projects below."
      }
    }

    section {
      comment("About me information section")
      article(classes = "info columnar") {
        markdown("about_myself.md")
      }

      comment("About the site information section")
      article(classes = "info columnar") {
        markdown("about_this_site.md")
      }
    }

    hr()

    section {
      val projects = arrayOf(
        Project.externalProject(
          name = "Factorio: Space Age",
          description = "An epic expansion to one of the best factory games out there.",
          thumbnail = "project-factorio-thumbnail.jpg",
          url = "https://factorio.com"),
        Project.externalProject(
          name = "Popped to Scale",
          description = "A game made in a weekend for the GMTK Game Jam 2024. We just wanted to get our feet wet " +
            "with 3D after years of working in 3D. Posted to itch.io and to GitHub.",
          thumbnail = "project-poppedtoscale-thumbnail.jpg",
          url = "https://llemec.itch.io/popped-to-scale"),
        Project.externalProject(
          name = "Omnia",
          description = "A thin library of utilities, data structures, and algorithms written in Kotlin.",
          thumbnail = "project-omnia-thumbnail.jpg",
          url = "https://github.com/StrangePan/omnia"),
        Project.externalProject(
          name = "YouTube Android",
          description = "The official YouTube app for Android.",
          thumbnail = "project-youtube-thumbnail.jpg",
          url = "https://play.google.com/store/apps/details?id=com.google.android.youtube"),
        Project.localProject(
          name = "Scuffle",
          description = "A PICO-8 game created for the Extra Credits Game Jam 5. Created by Dan Andrus and Alexander Biggs.",
          thumbnail = "project-scuffle-thumbnail.png",
          directory = "scuffle"),
        Project.localProject(
          name = "Parallax Scrolling",
          description = "A small experiment in parallax scrolling effects, written from scratch using jQuery.",
          thumbnail = "project-parallax-thumbnail.jpg",
          directory = "parallax"),
        Project.localProject(
          name = "Stacker!",
          description = "A simple game based on the arcade game by the same name using pure HTML5.",
          thumbnail = "project-stacker-thumbnail.png",
          directory = "stacker"),
        Project.localProject(
          name = "YouTube Theater",
          description = "An easy way to watch YouTube videos without distraction.",
          thumbnail = "project-yttheater-thumbnail.jpg",
          directory = "web-theater"),
      )

      article(classes = "front-and-center") {
        markdown("projects.md")
      }

      ul(classes = "project-list") {
        for (project in projects) {
          li {
            attributes["title"] = "${project.name}: ${project.description}"
            a(href = project.pageUrl) {
              img(classes = "thumbnail", src = project.thumbnailUrl)
              h2 { +project.name }
            }
          }
        }
      }
    }
  }
}

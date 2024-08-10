package me.strangepan.website.errors

import kotlinx.html.*
import me.strangepan.website.composure.composure

fun error404(): HTML.() -> Unit = {
  composure("404") {
    article(classes = "404 error front-and-center") {
      header {
        h1 {
          +"404: Where are you going?"
        }
      }
      section {
        p {
          +("The page you're looking for simply isn't here. " +
              "Maybe it's been moved, maybe it's misplaced, or maybe it never existed. " +
              "Either way, you're at a dead end. " +
              "Sorry!")
        }
      }
    }
  }
}

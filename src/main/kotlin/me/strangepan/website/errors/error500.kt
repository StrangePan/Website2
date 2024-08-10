package me.strangepan.website.errors

import kotlinx.html.*
import me.strangepan.website.composure.composure

fun error500(): HTML.() -> Unit = {
  composure("500") {
    article(classes = "500 error front-and-center") {
      header {
        h1 {
          +"500: Oops"
        }
      }
      section {
        p {
          +"An internal server error occurred. Sorry about that!"
        }
      }
    }
  }
}

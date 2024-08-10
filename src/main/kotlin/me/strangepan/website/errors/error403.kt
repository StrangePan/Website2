package me.strangepan.website.errors

import kotlinx.html.*
import me.strangepan.website.composure.composure

fun error403(): HTML.() -> Unit = {
  composure("403") {
    article(classes = "403 error front-and-center") {
      header {
        h1 {
          +"403: You shouldn't be here..."
        }
      }
      section {
        p {
          +"Sorry, but this section of the site is off-limits."
        }
      }
    }
  }
}

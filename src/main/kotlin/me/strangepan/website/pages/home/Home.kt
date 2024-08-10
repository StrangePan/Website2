package me.strangepan.website.pages.home

import kotlinx.html.*
import me.strangepan.website.composure.composure
import me.strangepan.website.markdown.markdown

fun homePage(): HTML.() -> Unit = {
  composure(title = "Home") {
    comment("Home page welcome")
    article(classes = "welcome front-and-center") {
      header {
        h1 {
          +"Vido Gams and Code"
        }
      }
      section {
        p {
          +"a playground for projects and ideas"
        }
      }
    }

    hr()

    comment("About me information section")
    article(classes = "info columnar") {
      markdown("about_myself.md")
    }

    comment("About the site information section")
    article(classes = "info columnar") {
      markdown("about_this_site.md")
    }
  }
}

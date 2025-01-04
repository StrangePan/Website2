package me.strangepan.website.pages.resume

import kotlinx.html.*
import me.strangepan.website.composure.composure
import me.strangepan.website.markdown.markdown

fun resumePage(): HTML.() -> Unit = {
  composure("Resume") {
    comment("About me information section")
    article(classes = "document") {
      markdown("resume.md")
      footer {
        +"Last updated "
        span(classes = "timestamp") {
          +"January 4, 2025"
        }
      }
    }
  }
}

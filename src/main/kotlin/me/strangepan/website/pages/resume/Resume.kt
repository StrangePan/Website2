package me.strangepan.website.pages.resume

import kotlinx.html.*
import me.strangepan.website.composure.composure
import me.strangepan.website.markdown.markdown

private fun FlowContent.downloadButton() {
  div(classes = "button-row") {
    a(classes = "download independent", target = ATarget.blank, href = "/files/resume.pdf") {
      +"Download PDF"
    }
  }
}

fun resumePage(): HTML.() -> Unit = {
  composure("Resume") {
    downloadButton()

    comment("About me information section")
    article(classes = "document") {
      markdown("resume.md")
      footer {
        +"Last updated "
        span(classes = "timestamp") {
          +"October 29, 2021"
        }
      }
    }

    downloadButton()
  }
}

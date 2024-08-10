package me.strangepan.website.composure

import kotlinx.html.*
import me.strangepan.website.prefabs.mainNav
import me.strangepan.website.prefabs.socialNav

inline fun HTML.composure(title: String? = null, crossinline content: FlowContent.() -> Unit = {}) {
  head {
    comment("Meta information")
    meta(charset = "UTF-8")
    meta(name = "description", content = "Personal web site of Daniel 'StrangePan' Ernest Andrus II")
    meta(name = "keywords", content = "personal, sandbox, blog, code, custom, daniel, dan, deaboy, andrus, strangepan")
    meta(name = "author", content = "Daniel Andrus")
    meta(name = "viewport", content = "width=device-width, initial-scale=1, user-scalable=1")

    comment("Page title")
    title { +"${ title?.trim()?.plus(" - ")?:""}Dan Andrus" }

    comment("Remote CSS links")
    link(rel = "stylesheet", type = "text/css", href = "//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css")
    link(rel = "stylesheet", type = "text/css", href = "//fonts.googleapis.com/css?family=Tangerine:400,700|Open+Sans:300italic,700italic,300,700")

    comment("Local CSS links")
    link(rel = "stylesheet", type = "text/css", href = "/templates/composure/css/styles.css")
    link(rel = "stylesheet", type = "text/css", href = "/templates/composure/css/wide.css")
    link(rel = "stylesheet", type = "text/css", href = "/templates/composure/css/medium.css")
    link(rel = "stylesheet", type = "text/css", href = "/templates/composure/css/narrow.css")

    comment("Icons")
    link(rel = "icon", type = "image/png", href = "/images/favicon-16x16.png") { sizes = "16x16" }
    link(rel = "icon", type = "image/png", href = "/images/favicon-32x32.png") { sizes = "32x32" }
    link(rel = "icon", type = "image/png", href = "/images/favicon-96x96.png") { sizes = "96x96" }
    link(rel = "apple-touch-icon", href="/images/favicon-120x120.png")
    link(rel = "apple-touch-icon", href="/images/favicon-180x180.png") { sizes = "180x180" }
    link(rel = "apple-touch-icon", href="/images/favicon-152x152.png") { sizes = "152x152" }
    link(rel = "apple-touch-icon", href="/images/favicon-167x167.png") { sizes = "167x167" }
  }
  body {

    comment("Page wrapper")
    div {
      id = "page"

      comment("Page header")
      header {
        id = "header"
        role = "banner"
        div(classes = "title") {
          a(href = "/") {
            img(classes = "profile-picture logo", src = "/images/profile.jpg")
            +"Dan Andrus"
          }
        }

        mainNav()
      }

      main {
        id = "content"
        role = "main"

        content()
      }

      comment("Page footer")
      footer {
        id = "footer"
        role = "contentinfo"

        comment("Everybody loves social links. Right?")
        socialNav()

        comment("Copyright info")
        div(classes = "copyright") {
          +"© 2014-2024 Daniel Andrus"
        }
        div(classes = "copyright") {
          a(href = "http://fontawesome.io/") { +"Font Awesome" }
          +" by Dave Gandy"
        }
      }
    }
  }
}

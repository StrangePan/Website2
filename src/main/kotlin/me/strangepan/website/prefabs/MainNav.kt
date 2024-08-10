package me.strangepan.website.prefabs

import kotlinx.html.*

fun FlowContent.mainNav() {
  nav(classes = "main") {
    ul {
      li { a(href = "/") { +"Home" } }
      li { a(href = "/resume") { +"Resume" } }
      li { a(href = "/projects") { +"Projects" } }
    }
  }
}

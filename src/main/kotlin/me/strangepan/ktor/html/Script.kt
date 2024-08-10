package me.strangepan.ktor.html

import kotlinx.html.*

var SCRIPT.crossorigin: String?
  get() = this.attributes.get("crossorigin")
  set(newValue) {
    if (newValue != null) {
      this.attributes.set("crossorigin", newValue)
    } else {
      this.attributes.remove("crossorigin")
    }
  }

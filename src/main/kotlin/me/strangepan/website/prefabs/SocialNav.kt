package me.strangepan.website.prefabs

import kotlinx.html.*

fun FlowContent.socialNav() {
  nav(classes = "social") {
    ul {
      li {
        a(href = "https://cyberplace.social/@StrangePan") {
          title = "Mastodon"
          rel = "me"
          span(classes = "fa fa-brands fa-mastodon icon")
          +"Mastodon"
        }
      }
      li {
        a(href = "https://www.github.com/StrangePan") {
          title = "Github"
          span(classes = "fa fa-github icon")
          +"GitHub"
        }
      }
      li {
        a(href = "http://steamcommunity.com/id/strangepan") {
          title = "Steam"
          span(classes = "fa fa-steam icon")
          +"Steam"
        }
      }
    }
  }
}

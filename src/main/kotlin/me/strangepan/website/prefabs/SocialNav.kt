package me.strangepan.website.prefabs

import kotlinx.html.*

enum class SocialNavType {
  Full,
  Minimal,
}

fun FlowContent.socialNav(type: SocialNavType) {
  nav(classes = "social") {
    ul {
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
      li {
        a {
          title = "Discord"
          span(classes = "fa fa-brands fa-discord icon")
          +"StrangePan"
        }
      }
      if (type == SocialNavType.Full) {
        li {
          a(href = "https://cyberplace.social/@StrangePan") {
            title = "Mastodon"
            rel = "me"
            span(classes = "fa fa-brands fa-mastodon icon")
            +"Mastodon"
          }
        }
        li {
          a(href = "https://bsky.app/profile/strangepan.bsky.social") {
            title = "Bluesky"
            span(classes = "fa fa-brands fa-bluesky icon")
            +"Bluesky"
          }
        }
      }
    }
  }
}

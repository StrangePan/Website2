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
        a(href = "https://www.twitter.com/StrangePan") {
          title = "Twitter"
          span(classes = "fa fa-twitter icon")
          +"Twitter"
        }
      }
      li {
        a(href = "https://www.facebook.com/Deaboy100") {
          title = "Facebook"
          span(classes = "fa fa-facebook icon")
          +"Facebook"
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
        a(href = "https://www.linkedin.com/in/daniel-andrus-259a27a3") {
          title = "LinkedIn"
          span(classes = "fa fa-linkedin-square icon")
          +"LinkedIn"
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

package com.example

import com.example.plugins.configureRouting
import com.example.plugins.configureTemplating
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.server.testing.*
import kotlin.test.Test
import kotlin.test.assertContains
import kotlin.test.assertEquals

class ApplicationTest {
  @Test
  fun testRoot() = testApplication {
    application {
      configureRouting()
    }
    client.get("/").apply {
      assertEquals(HttpStatusCode.OK, status)
      assertEquals("Hello World!", bodyAsText())
    }
  }

  @Test
  fun testArticles() = testApplication {
    application {
      configureRouting()
    }
    client.get("/articles").apply {
      assertEquals(HttpStatusCode.OK, status)
      assertEquals("List of articles sorted starting from new", bodyAsText())
    }
  }

  @Test
  fun testArticlesSortByOld() = testApplication {
    application {
      configureRouting()
    }
    client.get("/articles?sort=old").apply {
      assertEquals(HttpStatusCode.OK, status)
      assertEquals("List of articles sorted starting from old", bodyAsText())
    }
  }

  @Test
  fun testHtmlDsl() = testApplication {
    application {
      configureTemplating()
    }
    client.get("/html-dsl").apply {
      assertEquals(HttpStatusCode.OK, status)
      assertEquals("html", contentType()?.contentSubtype)
      assertContains(bodyAsText(), "<h1>HTML</h1>")
      for (n in 1..10) {
        assertContains(bodyAsText(), "<li>$n</li>")
      }
    }
  }

  @Test
  fun testHtmlCssDsl() = testApplication {
    application {
      configureTemplating()
    }
    client.get("/html-css-dsl").apply {
      assertEquals(HttpStatusCode.OK, status)
      assertEquals("html", contentType()?.contentSubtype)
      assertContains(bodyAsText(), "<link href=\"/styles.css\" rel=\"stylesheet\" type=\"text/css\">")
    }
  }

  @Test
  fun testStylesCss() = testApplication {
    application {
      configureTemplating()
    }
    client.get("/styles.css").apply {
      assertEquals(HttpStatusCode.OK, status)
      assertEquals("css", contentType()?.contentSubtype)
      assertContains(bodyAsText(), "h1.page-title {")
      assertContains(bodyAsText(), "body {")
    }
  }
}

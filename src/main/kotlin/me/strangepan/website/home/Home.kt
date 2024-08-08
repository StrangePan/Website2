package me.strangepan.website.home

import java.io.File
import kotlinx.html.*
import me.strangepan.website.composure.composure
import org.intellij.markdown.flavours.commonmark.CommonMarkFlavourDescriptor
import org.intellij.markdown.html.HtmlGenerator
import org.intellij.markdown.parser.MarkdownParser

val HOME_PAGE: HTML.() -> Unit = {
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
      unsafe {
        val src = File(ClassLoader.getSystemResource("content/about_myself.md").file).readText()
        val flavour = CommonMarkFlavourDescriptor()
        val parsedTree = MarkdownParser(flavour).buildMarkdownTreeFromString(src)
        val html = HtmlGenerator(src, parsedTree, flavour).generateHtml()
        raw(html)
      }
    }

    comment("About the site information section")
    article(classes = "info columnar") {
      unsafe {
        val src = File(ClassLoader.getSystemResource("content/about_this_site.md").file).readText()
        val flavour = CommonMarkFlavourDescriptor()
        val parsedTree = MarkdownParser(flavour).buildMarkdownTreeFromString(src)
        val html = HtmlGenerator(src, parsedTree, flavour).generateHtml()
          .substringAfter("<body>")
          .substringBeforeLast("</body>")
        raw(html)
      }
    }
  }
}

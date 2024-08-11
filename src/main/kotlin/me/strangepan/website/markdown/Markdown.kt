package me.strangepan.website.markdown

import java.io.BufferedReader
import java.io.File
import java.io.FileNotFoundException
import java.io.InputStreamReader
import kotlinx.html.*
import org.intellij.markdown.MarkdownParsingException
import org.intellij.markdown.flavours.commonmark.CommonMarkFlavourDescriptor
import org.intellij.markdown.html.HtmlGenerator
import org.intellij.markdown.parser.MarkdownParser

fun HTMLTag.markdown(filename: String) {
  unsafe {
    val inputStream = this.javaClass.getResourceAsStream("/content/$filename")
    val markdown = BufferedReader(InputStreamReader(inputStream!!)).readText()
    val flavour = CommonMarkFlavourDescriptor()
    val parsedTree = MarkdownParser(flavour).buildMarkdownTreeFromString(markdown)
    val html = HtmlGenerator(markdown, parsedTree, flavour).generateHtml()
      .substringAfter("<body>")
      .substringBeforeLast("</body>")
    raw(html)
  }
}

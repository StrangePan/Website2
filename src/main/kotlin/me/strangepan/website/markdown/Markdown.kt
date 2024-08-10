package me.strangepan.website.markdown

import java.io.File
import java.io.FileNotFoundException
import kotlinx.html.*
import org.intellij.markdown.MarkdownParsingException
import org.intellij.markdown.flavours.commonmark.CommonMarkFlavourDescriptor
import org.intellij.markdown.html.HtmlGenerator
import org.intellij.markdown.parser.MarkdownParser

fun HTMLTag.markdown(filename: String) {
  unsafe {
    val src = File(ClassLoader.getSystemResource("content/$filename").file).readText()
    val flavour = CommonMarkFlavourDescriptor()
    val parsedTree = MarkdownParser(flavour).buildMarkdownTreeFromString(src)
    val html = HtmlGenerator(src, parsedTree, flavour).generateHtml()
      .substringAfter("<body>")
      .substringBeforeLast("</body>")
    raw(html)
  }
}

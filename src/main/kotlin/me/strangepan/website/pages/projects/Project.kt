package me.strangepan.website.pages.projects

data class Project(
  val name: String,
  val description: String,
  val thumbnail: String,
  val directory: String,
) {
  val thumbnailUrl get() = "/images/$thumbnail"
  val pageUrl get() = "/projects/$directory/"
}

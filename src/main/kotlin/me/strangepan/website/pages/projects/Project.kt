package me.strangepan.website.pages.projects

data class Project(
  val name: String,
  val description: String,
  val thumbnailUrl: String,
  val pageUrl: String,
) {

  companion object {
    fun localProject(name: String, description: String, thumbnail: String, directory: String) =
      Project(
        name = name,
        description = description,
        thumbnailUrl = "/images/$thumbnail",
        pageUrl = "/projects/$directory/"
      )

    fun externalProject(name: String, description: String, thumbnail: String, url: String) =
      Project(
        name = name,
        description = description,
        thumbnailUrl = "/images/$thumbnail",
        pageUrl = url
      )
  }
}

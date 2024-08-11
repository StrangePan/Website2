
val kotlin_version: String by project
val logback_version: String by project
val kotlinx_html_version: String by project
val jetbrains_markdown_version: String by project

plugins {
  kotlin("jvm") version "2.0.10"
  id("io.ktor.plugin") version "2.3.12"
  id("org.jetbrains.kotlin.plugin.serialization") version "2.0.10"
}

group = "me.strangepan.website"
version = "1.0.0"

application {
  mainClass.set("io.ktor.server.netty.EngineMain")

  val isDevelopment: Boolean = project.ext.has("development")
  applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}

repositories {
  mavenCentral()
  maven { url = uri("https://maven.pkg.jetbrains.space/kotlin/p/kotlin/kotlin-js-wrappers") }
}

dependencies {
  implementation("io.ktor:ktor-server-status-pages")
  implementation("io.ktor:ktor-server-core-jvm")
  implementation("io.ktor:ktor-server-resources-jvm")
  implementation("io.ktor:ktor-server-html-builder-jvm")
  implementation("org.jetbrains.kotlinx:kotlinx-html-jvm:$kotlinx_html_version")
  implementation("org.jetbrains:kotlin-css-jvm:1.0.0-pre.129-kotlin-1.4.20")
  implementation("org.jetbrains:markdown:$jetbrains_markdown_version")
  implementation("io.ktor:ktor-server-netty-jvm")
  implementation("ch.qos.logback:logback-classic:$logback_version")
  testImplementation("io.ktor:ktor-server-test-host-jvm")
  testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlin_version")
}

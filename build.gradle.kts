plugins {
  kotlin("jvm") version "2.2.21"
  id("io.ktor.plugin") version "3.3.3"
  id("org.jetbrains.kotlin.plugin.serialization") version "2.2.21"
  id("name.remal.generate-sources") version "2.0.4"
}

group = "me.strangepan.website"
version = "1.1.0"

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
  implementation(libs.ktorNetworkTlsCertificates)
  implementation(libs.ktorServerStatusPages)
  implementation(libs.ktorServerCoreJvm)
  implementation(libs.ktorServerResourcesJvm)
  implementation(libs.ktorServerHtmlBuilderJvm)
  implementation(libs.ktorServerNettyJvm)
  implementation(libs.kotlinxHtml)
  implementation(libs.kotlinCss)
  implementation(libs.markdown)
  implementation(libs.logback)
  testImplementation(libs.ktorServerTestHostJvm)
  testImplementation(libs.kotlinTestJunit)
}

generateSources.forMainSourceSet.java {
  classFile("me.strangepan.website", "Version") {
    block("public final class Version") {
      line("public static final String VERSION = \"${project.version}\";")
    }
  }
}

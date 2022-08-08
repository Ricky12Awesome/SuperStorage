import dev.architectury.plugin.ArchitecturyPlugin
import net.fabricmc.loom.api.LoomGradleExtensionAPI
import org.jetbrains.kotlin.gradle.plugin.KotlinPluginWrapper
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
  java
  id("architectury-plugin") version "3.4-SNAPSHOT"
  id("dev.architectury.loom") version "0.12.0-SNAPSHOT" apply false
  kotlin("jvm") version "1.7.10" apply false
}

architectury {
  minecraft = rootProject.property("minecraft_version").toString()
}

subprojects {
  apply(plugin = "dev.architectury.loom")

  val loom: LoomGradleExtensionAPI by project.extensions

  dependencies {
    "minecraft"("com.mojang:minecraft:${project.property("minecraft_version")}")
    // The following line declares the mojmap mappings, you may use other mappings as well
    "mappings"(loom.officialMojangMappings())
    // The following line declares the yarn mappings you may select this one as well.
    // "mappings"("net.fabricmc:yarn:1.18.2+build.3:v2")
  }
}

allprojects {
  apply<JavaPlugin>()
  apply<ArchitecturyPlugin>()
  apply<MavenPublishPlugin>()
  apply<KotlinPluginWrapper>()

  base.archivesName.set(rootProject.property("archives_base_name").toString())
  //base.archivesBaseName = rootProject.property("archives_base_name").toString()
  version = rootProject.property("mod_version").toString()
  group = rootProject.property("maven_group").toString()

  repositories {
    // Add repositories to retrieve artifacts from in here.
    // You should only use this when depending on other mods because
    // Loom adds the essential maven repositories to download Minecraft and libraries from automatically.
    // See https://docs.gradle.org/current/userguide/declaring_repositories.html
    // for more information about repositories.
  }

  dependencies {
    "compileClasspath"("org.jetbrains.kotlin:kotlin-gradle-plugin:${property("kotlin_version")}")
  }

  tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
    options.release.set(17)
  }

  java {
    withSourcesJar()
  }

  tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "17"
  }
}

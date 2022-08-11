plugins {
  id("com.github.johnrengelman.shadow") version "7.1.2"
}

architectury {
  platformSetupLoomIde()
  fabric()
}

loom {
  accessWidenerPath.set(project(":common").loom.accessWidenerPath)
}

/**
 * @see: https://docs.gradle.org/current/userguide/migrating_from_groovy_to_kotlin_dsl.html
 * */
val common: Configuration by configurations.creating
val shadowCommon: Configuration by configurations.creating // Don't use shadow from the shadow plugin because we don't want IDEA to index this.
val developmentFabric: Configuration = configurations.getByName("developmentFabric")

configurations {
  compileClasspath.get().extendsFrom(configurations["common"])
  runtimeClasspath.get().extendsFrom(configurations["common"])
  developmentFabric.extendsFrom(configurations["common"])
}

dependencies {
  modImplementation("net.fabricmc:fabric-loader:${rootProject.property("fabric_loader_version")}")
  modApi("net.fabricmc.fabric-api:fabric-api:${rootProject.property("fabric_api_version")}")
  // Remove the next line if you don't want to depend on the API
  modApi("dev.architectury:architectury-fabric:${rootProject.property("architectury_version")}")

  common(project(":common", configuration = "namedElements")) { isTransitive = false }
  shadowCommon(project(":common", configuration = "transformProductionFabric")) { isTransitive = false }
  modImplementation(group = "net.fabricmc", name = "fabric-language-kotlin", version = "1.8.2+kotlin.1.7.10")
}

val javaComponent = components.getByName<AdhocComponentWithVariants>("java")

javaComponent.withVariantsFromConfiguration(configurations["sourcesElements"]) {
  skip()
}

tasks {
  processResources {
    inputs.property("version", project.version)

    filesMatching("fabric.mod.json") {
      expand("version" to project.version)
    }
  }

  shadowJar {
    exclude("architectury.common.json")
    configurations = listOf(project.configurations["shadowCommon"])
    archiveClassifier.set("dev-shadow")
  }

  remapJar {
    injectAccessWidener.set(true)
    inputFile.set(shadowJar.flatMap { it.archiveFile })
    dependsOn(shadowJar)
    archiveClassifier.set("fabric")
  }

  jar {
    archiveClassifier.set("dev")
  }

  sourcesJar {
    val commonSources = project(":common").tasks.getByName<Jar>("sourcesJar")
    dependsOn(commonSources)
    from(commonSources.archiveFile.map { zipTree(it) })
  }

  publishing {
    publications {
      create<MavenPublication>("mavenFabric") {
        artifactId = "${rootProject.property("archives_base_name")}-${project.name}"
        from(javaComponent)
      }
    }

    // See https://docs.gradle.org/current/userguide/publishing_maven.html for information on how to set up publishing.
    repositories {
      // Add repositories to publish to here.
    }
  }
}


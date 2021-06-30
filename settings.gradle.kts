pluginManagement{
    val kotlinVersion: String by settings
    val shadowJarVersion: String by settings
    repositories{
        mavenCentral()
        maven{
            url = uri("https://plugins.gradle.org/m2/")
        }
        gradlePluginPortal()
    }

    plugins{
        kotlin("jvm") version kotlinVersion
        id("com.github.johnrengelman.shadow") version shadowJarVersion
    }
}

rootProject.name = "example-project"
include(":api", ":common")
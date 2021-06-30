plugins{
    java
    id("com.github.johnrengelman.shadow")
    kotlin("jvm") apply false
    idea
}

allprojects{
    group = "io.github.eddiediamondfire"
    version = "dev-SNAPSHOT"
}

subprojects{
    apply(plugin="java")

    repositories{
        mavenCentral()
        flatDir {
            dirs("libraries")
        }
    }

    val kotlinVersion = project.properties["kotlinVersion"]
    dependencies{
        implementation("org.jetbrains.kotlin:kotlin-stdlib:${kotlinVersion}")
    }
}

val projectName: String = rootProject.name
val projectVersion: String = project.version as String
tasks{
    named<com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar>("shadowJar"){
        archiveBaseName.set(projectName)
        archiveVersion.set(projectVersion)
    }
}


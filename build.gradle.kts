buildscript {
    val shadowJarVersion by rootProject.extra{
        "6.1.0"
    }

    val slf4jVersion by rootProject.extra{
        "1.7.30"
    }
    val kotlinVersion by rootProject.extra {
        "1.4.31"
    }

    repositories{
        mavenCentral()
        maven{
            url = uri("https://plugins.gradle.org/m2/")
        }
    }

    dependencies{
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${rootProject.extra.get("kotlinVersion")}")
        classpath("com.github.jengelman.gradle.plugins:shadow:${rootProject.extra.get("shadowJarVersion")}")
    }
}

allprojects{
    group = "io.github.eddiediamondfire"
    version = "dev-SNAPSHOT"
}

subprojects{
    repositories{
        mavenCentral()

        flatDir{
            dirs("libraries")
        }
    }

    apply(plugin = "java")
    apply(plugin = "org.jetbrains.kotlin.jvm")
    apply(plugin = "idea")
    apply(plugin = "kotlin-kapt")
    apply(plugin = "com.github.johnrengelman.shadow")

    val implementation by configurations
    dependencies{
        implementation("org.slf4j:slf4j-api:${rootProject.extra.get("slf4jVersion")}")
        implementation("org.slf4j:slf4j-log4j12:${rootProject.extra.get("slf4jVersion")}")
        implementation("org.jetbrains.kotlin:kotlin-stdlib:${rootProject.extra.get("kotlinVersion")}")
    }

    tasks.named<com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar>("shadowJar"){
        archiveBaseName.set("AdvancedPunishment")
        archiveVersion.set("dev-SNAPSHOT")
    }
}

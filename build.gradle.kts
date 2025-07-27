plugins {
    val kotlinVersion = "2.0.0"
    kotlin("jvm") version kotlinVersion // kotlin compiler
    kotlin("plugin.spring") version kotlinVersion // open classes for @Service, @Configuration annotations
    id("org.springframework.boot") version "3.4.4" // add Spring Boot Gradle Plugin (bootRun, bootJar tasks)
    id("io.spring.dependency-management") version "1.1.7"
}

allprojects {
    repositories {
        mavenCentral()
        maven { url = uri("https://repo.spring.io/milestone") }
        maven { url = uri("https://repo.spring.io/snapshot") }
        maven {
            name = "Central Portal Snapshots"
            url = uri("https://central.sonatype.com/repository/maven-snapshots/")
        }
    }
}
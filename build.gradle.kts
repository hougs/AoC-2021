import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.5.10"
    application
}
group = "me.jhougland"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}
sourceSets {
    main {
        java.srcDir("src")
    }
    test {
        java.srcDir("test")
    }
}


val kotestVersion = "4.6.3"

// and then the kotlin dependencies
dependencies {
    testImplementation("io.kotest:kotest-assertions-core-jvm:$kotestVersion") // optional, for kotest assertions
    testImplementation("io.kotest:kotest-runner-junit5-jvm:$kotestVersion") // required
}

tasks.withType<Test> { useJUnitPlatform() }

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "1.8"
}

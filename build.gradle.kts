import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.7.10"
    application
}

group = "ghasemdev"
version = "1.0.0"

repositories {
    mavenCentral()
}

dependencies {
    // Logging
    implementation("io.github.aakira:napier:2.6.1")

    // Assertion Test
    testImplementation("com.google.truth:truth:1.1.3")
    // Test Framework
    testImplementation("org.junit.jupiter:junit-jupiter:5.8.2")

    // Kotest
    testImplementation("io.kotest:kotest-assertions-core:5.3.1")
    testImplementation("io.kotest:kotest-property:5.3.1")
    testImplementation("io.kotest:kotest-runner-junit5:5.3.1")

    // Reflection
    testImplementation("org.jetbrains.kotlin:kotlin-reflect:1.7.10")
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions.jvmTarget = "1.8"
    kotlinOptions.freeCompilerArgs += "-opt-in=kotlin.RequiresOptIn"
}

application {
    mainClass.set("MainKt")
}

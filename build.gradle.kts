import org.gradle.api.tasks.testing.logging.TestExceptionFormat.FULL
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("com.adarshr.test-logger") version "1.7.0"
    id("com.github.ben-manes.versions") version "0.24.0"
    id("com.vanniktech.code.quality.tools") version "0.19.0"
    id("java")
    id("org.jetbrains.kotlin.jvm") version "1.3.50"
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

repositories {
    google()
    gradlePluginPortal()
    mavenCentral()
}

dependencies {
    testCompile("com.nhaarman.mockitokotlin2:mockito-kotlin:2.1.0")
    testImplementation("org.assertj:assertj-core:3.13.2")
    testImplementation("org.hamcrest:hamcrest-all:1.3")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    val junitVersion = "5.5.1"
    testImplementation("org.junit.jupiter:junit-jupiter-api:$junitVersion")
    testImplementation("org.junit.jupiter:junit-jupiter-params:$junitVersion")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:$junitVersion")
    testRuntimeOnly("org.junit.vintage:junit-vintage-engine:$junitVersion")

    testImplementation("org.mockito:mockito-junit-jupiter:3.0.0")

    // Additional test flavors
    /*
    testCompile("com.google.truth:truth:1.0")
    testCompile("junit:junit:4.12")

    testCompile("io.kotlintest:kotlintest-assertions:3.4.0")
    testCompile("io.kotlintest:kotlintest-core:3.4.0")
    testCompile("io.kotlintest:kotlintest-runner-junit5:3.4.0")

    testImplementation("io.mockk:mockk:1.9.3")
    testImplementation("io.strikt:strikt-core:0.21.1")

    testImplementation("org.amshove.kluent:kluent:1.453")

    testCompile("org.spekframework.spek2:spek-dsl-jvm:2.0.6")
    testRuntime("org.spekframework.spek2:spek-runner-junit5:2.0.6")
    */
}

tasks.clean {
    doFirst {
        delete("out")
    }
}

tasks.test {
    useJUnitPlatform()
    testLogging {
        exceptionFormat = FULL
        events("passed", "skipped", "failed", "standard_error", "standard_out")
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = JavaVersion.VERSION_1_8.toString()
}

apply(from = file("quality/quality.gradle"))
plugins {
    id("java")
    id("idea")
    id("org.jetbrains.kotlin.jvm") version "1.3.50"
}

sourceSets {
    test {
        java.srcDir(file("src/test/kotlin/"))
    }
}

repositories {
    google()
    gradlePluginPortal()
    mavenCentral()
}

dependencies {
    testImplementation("io.mockk:mockk:1.9.3")
    testImplementation("org.assertj:assertj-core:3.13.2")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    val junitVersion = "5.5.1"
    testImplementation("org.junit.jupiter:junit-jupiter-api:$junitVersion")
    testImplementation("org.junit.jupiter:junit-jupiter-params:$junitVersion")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:$junitVersion")
    testRuntimeOnly("org.junit.vintage:junit-vintage-engine:$junitVersion")

    // Additional test flavors
    /*
    testImplementation("com.google.truth:truth:1.0")
    testImplementation("com.nhaarman.mockitokotlin2:mockito-kotlin:2.1.0")
    testImplementation("com.willowtreeapps.assertk:assertk-jvm:0.19")
    testImplementation("junit:junit:4.12")

    val kotlinTestVersion = "3.4.0"
    testImplementation("io.kotlintest:kotlintest-assertions:$kotlinTestVersion")
    testImplementation("io.kotlintest:kotlintest-core:$kotlinTestVersion")
    testImplementation("io.kotlintest:kotlintest-runner-junit5:$kotlinTestVersion")

    testImplementation("io.strikt:strikt-core:0.21.1")
    testImplementation("org.amshove.kluent:kluent:1.453")
    testImplementation("org.hamcrest:hamcrest-all:1.3")
    testImplementation("org.mockito:mockito-junit-jupiter:3.0.0")

    val kotlinDotTestVersion = "1.3.50"
    testImplementation("org.jetbrains.kotlin:kotlin-test:$kotlinDotTestVersion")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlinDotTestVersion")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5:$kotlinDotTestVersion")

    val spekVersion = "2.0.6"
    testImplementation("org.spekframework.spek2:spek-dsl-jvm:$spekVersion")
    testRuntimeOnly("org.spekframework.spek2:spek-runner-junit5:$spekVersion")
    */
}

tasks.test {
    useJUnitPlatform()

    testLogging {
        events("passed", "skipped", "failed")
    }
}
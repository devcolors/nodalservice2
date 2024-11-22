plugins {
    kotlin("jvm") version "1.9.0"
    id("org.springframework.boot") version "2.7.10"
    id("io.spring.dependency-management") version "1.0.15.RELEASE"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-amqp")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(8)
}
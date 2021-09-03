import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.5.4"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    kotlin("jvm") version "1.5.21"
    kotlin("plugin.spring") version "1.5.21"
}

group = "com.gnavin"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jdbc")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("com.google.code.gson:gson")
    compileOnly("org.projectlombok:lombok")
    runtimeOnly("com.h2database:h2")
    annotationProcessor("org.projectlombok:lombok")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.mockito.kotlin:mockito-kotlin")
    testImplementation("io.mockk:mockk")
    testImplementation("org.mockito:mockito-core")
    // https://mvnrepository.com/artifact/org.jetbrains.spek/spek-api
    testImplementation("org.jetbrains.spek:spek-api:1.1.5")
    // https://mvnrepository.com/artifact/org.testng/testng
    testImplementation("org.testng:testng:7.4.0")
    // https://mvnrepository.com/artifact/org.powermock/powermock-module-testng
    testImplementation("org.powermock:powermock-module-testng:2.0.9")
    // https://mvnrepository.com/artifact/org.mockito/mockito-testng
    testImplementation("org.mockito:mockito-testng:0.4.13")
    // https://mvnrepository.com/artifact/io.cucumber/cucumber-testng
    implementation("io.cucumber:cucumber-testng:6.11.0")


}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "11"
    }
}

tasks.withType<Test> {
    useTestNG()
}

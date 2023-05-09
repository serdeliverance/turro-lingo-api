plugins {
    id("java")
    id("org.springframework.boot") version "3.0.2"
    id("io.spring.dependency-management") version "1.1.0"
    id("com.diffplug.spotless") version "6.16.0"
}

group = "io.github.sd3v"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.jooq:jooq:3.14.15")
    implementation("org.flywaydb:flyway-core:9.16.0")
    runtimeOnly("org.postgresql:postgresql:42.5.4")
    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<Test> {
    useJUnitPlatform()
}

spotless {
    java {
        target(fileTree(rootDir) {
            include("src/**/*.java")
            exclude("src/jooq")
        })
        removeUnusedImports()
        googleJavaFormat("1.15.0")
    }
}

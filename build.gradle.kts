import nu.studer.gradle.jooq.JooqEdition
import org.jooq.meta.jaxb.ForcedType
import org.jooq.meta.jaxb.Property

plugins {
    java
    id("org.springframework.boot") version "3.2.2"
    id("io.spring.dependency-management") version "1.1.4"
    id("com.diffplug.spotless") version "6.25.0"
    id("nu.studer.jooq") version "5.2.1"
    id("org.flywaydb.flyway") version "9.8.1"
}

group = "io.github.sd3v"
version = "0.0.1-SNAPSHOT"

configure<JavaPluginExtension> {
    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21
}

val jooqSourceDir = "src/jooq/java"
val jooqVersion = "3.18.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springframework.boot:spring-boot-starter-jooq")
    implementation("org.springframework:spring-jdbc")
    implementation("org.jooq:jooq:3.18.0")
    jooqGenerator("org.postgresql:postgresql:42.5.4")
    runtimeOnly("org.postgresql:postgresql:42.5.4")
    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<Test> {
    useJUnitPlatform()
}

sourceSets {
    main {
        java.srcDir("src/main/java")
        java.srcDir(jooqSourceDir)
    }
}

spotless {
    java {
        target(
            fileTree(rootDir) {
                include("src/**/*.java")
                exclude("src/jooq")
            },
        )
        removeUnusedImports()
        googleJavaFormat("1.17.0")
    }
}

// TODO fix flyway migrations doesn't run on startup
flyway {
    url = "jdbc:postgresql://localhost:45432/tldb"
    user = "root"
    password = "root"
    baselineVersion = "0"
    validateMigrationNaming = true
}

jooq {
    version.set(jooqVersion)
    edition.set(JooqEdition.OSS)

    configurations {
        create("main") {
            generateSchemaSourceOnCompilation.set(false)

            jooqConfiguration.apply {
                logging = org.jooq.meta.jaxb.Logging.WARN
                jdbc.apply {
                    driver = "org.postgresql.Driver"
                    url = "jdbc:postgresql://localhost:45432/tldb"
                    user = "root"
                    password = "root"
                    properties.add(Property().withKey("PAGE_SIZE").withValue("2048"))
                }
                generator.apply {
                    name = "org.jooq.codegen.DefaultGenerator"
                    database.apply {
                        name = "org.jooq.meta.postgres.PostgresDatabase"
                        inputSchema = "public"
                        forcedTypes.addAll(
                            arrayOf(
                                ForcedType()
                                    .withName("varchar")
                                    .withIncludeExpression(".*")
                                    .withIncludeTypes("JSONB?"),
                                ForcedType()
                                    .withName("varchar")
                                    .withIncludeExpression(".*")
                                    .withIncludeTypes("INET"),
                            ).toList(),
                        )
                        excludes = "QRTZ_.*"
                    }
                    generate.apply {
                        isDeprecated = false
                        isRecords = true
                        isImmutablePojos = true
                        isFluentSetters = true
                    }
                    target.apply {
                        packageName = "io.github.sd3v.mflashcardsbe.jooq"
                        directory = jooqSourceDir
                    }
                    strategy.name = "org.jooq.codegen.DefaultGeneratorStrategy"
                }
            }
        }
    }
}

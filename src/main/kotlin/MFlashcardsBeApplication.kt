package io.github.sd3v.mflashcardsbe

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories

@SpringBootApplication
@EnableMongoRepositories
class MFlashcardsBeApplication

fun main(args: Array<String>) {
    runApplication<MFlashcardsBeApplication>(*args)
}

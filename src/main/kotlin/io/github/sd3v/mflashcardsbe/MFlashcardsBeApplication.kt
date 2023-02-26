package io.github.sd3v.mflashcardsbe

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories

@SpringBootApplication
@EnableReactiveMongoRepositories
class MFlashcardsBeApplication : AbstractReactiveMongoConfiguration() {
	override fun getDatabaseName() = "mfcard"
}

fun main(args: Array<String>) {
	runApplication<MFlashcardsBeApplication>(*args)
}

package io.github.sd3v.mflashcardsbe.config

import com.mongodb.reactivestreams.client.MongoClient
import com.mongodb.reactivestreams.client.MongoClients
import org.springframework.boot.autoconfigure.web.reactive.WebFluxAutoConfiguration.WebFluxConfig
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.config.CorsRegistry
import org.springframework.web.reactive.config.WebFluxConfigurer

@Configuration
class AppConfig {

    @Bean
    fun mongoClient(): MongoClient = MongoClients.create()

    @Bean
    fun corsConfigurer(): WebFluxConfigurer =
        object : WebFluxConfigurer {
                override fun addCorsMappings(registry: CorsRegistry) {
                    registry.addMapping("/api/**").allowedOrigins("http://localhost:7700")
                }
        }
}

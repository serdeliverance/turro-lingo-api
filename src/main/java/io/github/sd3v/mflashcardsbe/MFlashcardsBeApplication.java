package io.github.sd3v.mflashcardsbe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@SpringBootApplication
@EnableReactiveMongoRepositories
public class MFlashcardsBeApplication {

  public static void main(String[] args) {
    SpringApplication.run(MFlashcardsBeApplication.class, args);
  }
}

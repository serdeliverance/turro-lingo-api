package io.github.sd3v.mflashcardsbe.config;

import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;

@Configuration
public class MongoConfig extends AbstractReactiveMongoConfiguration {

  @Value("${spring.data.mongodb.uri}")
  private String uri;

  @Override
  public MongoClient reactiveMongoClient() {
    return MongoClients.create(uri);
  }

  @Override
  protected String getDatabaseName() {
    return "mfcdb";
  }
}

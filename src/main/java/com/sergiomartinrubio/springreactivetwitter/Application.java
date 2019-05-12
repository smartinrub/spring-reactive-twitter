package com.sergiomartinrubio.springreactivetwitter;

import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
import org.springframework.social.twitter.api.Twitter;

import java.util.List;

@AllArgsConstructor
@SpringBootApplication(exclude = {MongoAutoConfiguration.class, MongoDataAutoConfiguration.class})
@EnableReactiveMongoRepositories
public class Application {

    private final Twitter twitter;
    private final TweetStreamListener listener;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public void initSaveTweets() {
        twitter.streamingOperations().filter("java", List.of(listener));
    }

}

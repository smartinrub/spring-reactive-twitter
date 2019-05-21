package com.sergiomartinrubio.springreactivetwitter.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
import twitter4j.conf.ConfigurationBuilder;

@Configuration
@RequiredArgsConstructor
public class TwitterConfig {

    private final TwitterParameters parameters;

    @Bean
    public TwitterStream twitter() {
        ConfigurationBuilder configurationBuilder =  new ConfigurationBuilder();
        configurationBuilder
                .setOAuthConsumerKey(parameters.getConsumerKey())
                .setOAuthConsumerSecret(parameters.getConsumerSecret())
                .setOAuthAccessToken(parameters.getAccessToken())
                .setOAuthAccessTokenSecret(parameters.getAccessTokenSecret());
        TwitterStreamFactory twitterStreamFactory = new TwitterStreamFactory(configurationBuilder.build());
        return twitterStreamFactory.getInstance();
    }
}

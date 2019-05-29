package com.sergiomartinrubio.springreactivetwitter.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
import twitter4j.conf.ConfigurationBuilder;

@Configuration
@EnableConfigurationProperties(TwitterProperties.class)
public class TwitterConfig {

    @Autowired
    private TwitterProperties parameters;

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

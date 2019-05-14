package com.sergiomartinrubio.springreactivetwitter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
import twitter4j.conf.ConfigurationBuilder;

@Configuration
public class TwitterConfig {

    @Value("${oauth.consumer-key}")
    private String consumerKey;

    @Value("${oauth.consumer-secret}")
    private String consumerSecret;

    @Value("${oauth.access-token}")
    private String accessToken;

    @Value("${oauth.access-token-secret}")
    private String accessTokenSecret;

    @Bean
    public TwitterStream twitter() {
        ConfigurationBuilder configurationBuilder =  new ConfigurationBuilder();
        configurationBuilder
                .setOAuthConsumerKey(consumerKey)
                .setOAuthConsumerSecret(consumerSecret)
                .setOAuthAccessToken(accessToken)
                .setOAuthAccessTokenSecret(accessTokenSecret);
        TwitterStreamFactory twitterStreamFactory = new TwitterStreamFactory(configurationBuilder.build());
        return twitterStreamFactory.getInstance();
    }
}

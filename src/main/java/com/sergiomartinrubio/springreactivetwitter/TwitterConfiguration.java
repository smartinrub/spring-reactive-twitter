package com.sergiomartinrubio.springreactivetwitter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.social.twitter.api.impl.TwitterTemplate;

@Configuration
public class TwitterConfiguration {

    @Value("${spring.social.twitter.consumer-key}")
    private String consumerKey;

    @Value("${spring.social.twitter.consumer-secret}")
    private String consumerSecret;

    @Value("${spring.social.twitter.access-token}")
    private String accessToken;

    @Value("${spring.social.twitter.access-token-secret}")
    private String accessTokenSecret;

    @Bean
    public TwitterTemplate twitterTemplate() {
        return new TwitterTemplate(consumerKey, consumerSecret, accessToken, accessTokenSecret);
    }
}

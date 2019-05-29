package com.sergiomartinrubio.springreactivetwitter.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties(prefix = "twitter.properties")
class TwitterProperties {

    private String consumerKey;
    private String consumerSecret;
    private String accessToken;
    private String accessTokenSecret;
}

package com.sergiomartinrubio.springreactivetwitter;

import lombok.AllArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import twitter4j.TwitterStream;

@Component
@AllArgsConstructor
public class DataInitializer implements ApplicationRunner {

    private final TwitterStream twitterStream;
    private final StreamListener listener;

    @Override
    public void run(ApplicationArguments args) {
        twitterStream.addListener(listener).filter(args.getNonOptionArgs().get(0));
    }
}

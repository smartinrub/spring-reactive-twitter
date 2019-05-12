package com.sergiomartinrubio.springreactivetwitter;

import lombok.AllArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class DataInitializer implements ApplicationRunner {

    private final Twitter twitter;
    private final TweetsStreamListener listener;

    @Override
    public void run(ApplicationArguments args) {
        twitter.streamingOperations().filter(args.getNonOptionArgs().get(0), List.of(listener));
    }
}

package com.sergiomartinrubio.springreactivetwitter.controller;

import com.sergiomartinrubio.springreactivetwitter.util.TweetsProducer;
import com.sergiomartinrubio.springreactivetwitter.model.Tweet;
import lombok.RequiredArgsConstructor;
import org.reactivestreams.Publisher;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TwitterController {

    private final TweetsProducer producer;

    @GetMapping(value = "/tweets", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Publisher<Tweet> tweets() {
        return producer.fetchTweets();
    }

}

package com.sergiomartinrubio.springreactivetwitter;

import lombok.RequiredArgsConstructor;
import org.reactivestreams.Publisher;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
class TwitterController {

    private final TweetsProducer producer;

    @GetMapping(value = "/tweets", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Publisher<TweetSummary> tweets() {
        return producer.fetchTweets();
    }

}

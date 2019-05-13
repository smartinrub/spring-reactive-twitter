package com.sergiomartinrubio.springreactivetwitter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Component
@RequiredArgsConstructor
class TweetsProducer {

    private final TweetsRepository repository;

    Flux<TweetSummary> fetchTweets() {
        return repository.findWithTailableCursorBy();
    }
 }

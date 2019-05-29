package com.sergiomartinrubio.springreactivetwitter.util;

import com.sergiomartinrubio.springreactivetwitter.model.Tweet;
import com.sergiomartinrubio.springreactivetwitter.repository.TweetsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Component
@RequiredArgsConstructor
public class TweetsProducer {

    private final TweetsRepository repository;

    public Flux<Tweet> fetchTweets() {
        return repository.findWithTailableCursorBy();
    }
 }

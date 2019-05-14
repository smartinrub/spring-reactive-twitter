package com.sergiomartinrubio.springreactivetwitter;

import org.springframework.data.mongodb.repository.Tailable;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
interface TweetsRepository extends ReactiveCrudRepository<Tweet, String> {

    @Tailable
    Flux<Tweet> findWithTailableCursorBy();
}

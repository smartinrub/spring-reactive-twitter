package com.sergiomartinrubio.springreactivetwitter.repository;

import com.sergiomartinrubio.springreactivetwitter.model.Tweet;
import org.springframework.data.mongodb.repository.Tailable;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface TweetsRepository extends ReactiveCrudRepository<Tweet, String> {

    @Tailable
    Flux<Tweet> findWithTailableCursorBy();
}

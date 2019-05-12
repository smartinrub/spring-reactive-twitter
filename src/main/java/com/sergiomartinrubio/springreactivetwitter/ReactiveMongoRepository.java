package com.sergiomartinrubio.springreactivetwitter;

import org.springframework.data.mongodb.repository.Tailable;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface ReactiveMongoRepository extends ReactiveCrudRepository<TweetSummary, String> {

    @Tailable
    Flux<TweetSummary> findWithTailableCursorBy();
}

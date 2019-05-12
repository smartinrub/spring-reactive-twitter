package com.sergiomartinrubio.springreactivetwitter;

import lombok.AllArgsConstructor;
import org.springframework.social.twitter.api.StreamDeleteEvent;
import org.springframework.social.twitter.api.StreamListener;
import org.springframework.social.twitter.api.StreamWarningEvent;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class TweetStreamListener implements StreamListener {

    private final ReactiveMongoRepository repository;

    @Override
    public void onTweet(Tweet tweet) {
        repository
                .save(new TweetSummary(String.valueOf(tweet.getId()), tweet.getCreatedAt().toString(), tweet.getText()))
                .subscribe(
                        System.out::println,
                        Throwable::printStackTrace,
                        () -> System.out.println("Successful!")
                );
    }

    @Override
    public void onDelete(StreamDeleteEvent deleteEvent) {

    }

    @Override
    public void onLimit(int numberOfLimitedTweets) {

    }

    @Override
    public void onWarning(StreamWarningEvent warningEvent) {

    }
}

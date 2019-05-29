package com.sergiomartinrubio.springreactivetwitter.util;

import com.sergiomartinrubio.springreactivetwitter.model.Tweet;
import com.sergiomartinrubio.springreactivetwitter.repository.TweetsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;

@Component
@AllArgsConstructor
public class StreamListener implements StatusListener {

    private final TweetsRepository repository;

    @Override
    public void onStatus(Status status) {
        repository
                .save(new Tweet(status.getId(), status.getCreatedAt(), status.getText()))
                .subscribe(
                        System.out::println,
                        Throwable::printStackTrace,
                        () -> System.out.println("OK!")
                );
    }

    @Override
    public void onDeletionNotice(StatusDeletionNotice statusDeletionNotice) {

    }

    @Override
    public void onTrackLimitationNotice(int i) {

    }

    @Override
    public void onScrubGeo(long l, long l1) {

    }

    @Override
    public void onStallWarning(StallWarning stallWarning) {

    }

    @Override
    public void onException(Exception e) {

    }
}

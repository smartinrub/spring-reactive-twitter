package com.sergiomartinrubio.springreactivetwitter;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("tweets")
@AllArgsConstructor
public class TweetSummary {

    @Id
    @JsonProperty("idStr")
    private String id;

    @JsonProperty("createdSt")
    private String createdAt;

    @JsonProperty("text")
    private String text;

}

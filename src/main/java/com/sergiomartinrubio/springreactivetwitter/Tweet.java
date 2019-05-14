package com.sergiomartinrubio.springreactivetwitter;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.Date;

@Data
@Document("tweets")
@NoArgsConstructor
@AllArgsConstructor
class Tweet {

    @MongoId
    @JsonProperty("idStr")
    private long id;

    @JsonProperty("createdSt")
    private Date createdAt;

    @JsonProperty("text")
    private String text;

}

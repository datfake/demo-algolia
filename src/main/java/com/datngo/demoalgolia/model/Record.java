package com.datngo.demoalgolia.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Record {
    private UUID objectID;
    private String title;
    private String content;
    private String url;
    private Instant dateAdded;
    private String createBy;
}

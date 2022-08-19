package com.datngo.demoalgolia.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RecordRequest {
    private String title;
    private String content;
    private String url;
}

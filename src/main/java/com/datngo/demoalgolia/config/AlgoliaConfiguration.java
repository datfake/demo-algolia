package com.datngo.demoalgolia.config;

import com.algolia.search.DefaultSearchClient;
import com.algolia.search.SearchClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AlgoliaConfiguration {
    @Value("${demo.algolia.api.key}")
    private String apiKey;

    @Value("${demo.algolia.application.id}")
    private String applicationId;

    @Bean
    public SearchClient configAlgolia() {
         return DefaultSearchClient.create(applicationId, apiKey);
    }

}

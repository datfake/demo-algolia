package com.datngo.demoalgolia.service;

import com.algolia.search.SearchClient;
import com.algolia.search.SearchIndex;
import com.algolia.search.models.indexing.Query;
import com.algolia.search.models.indexing.SearchResult;
import com.algolia.search.models.settings.IndexSettings;
import com.datngo.demoalgolia.dto.RecordRequest;
import com.datngo.demoalgolia.model.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
public class AlgoliaServiceImpl implements AlgoliaService{

    private static final String RECORD_INDEX = "KBDocsIndex";
    private static final String CREATE_BY = "Dat Ngo";

    @Autowired
    private SearchClient client;

    @Override
    public Record addRecord(RecordRequest recordRequest) {
        SearchIndex<Record> index = createIndex();
        Record record = Record.builder()
                .objectID(UUID.randomUUID())
                .title(recordRequest.getTitle())
                .content(recordRequest.getContent())
                .url(recordRequest.getUrl())
                .dateAdded(Instant.now())
                .createBy(CREATE_BY)
                .build();
        index.saveObject(record);
        return record;
    }

    @Override
    public List<Record> search(String keyword, String searchBy) {
        SearchIndex<Record> index = createIndex();
        SearchResult searchResult;
        if (!"all".equals(searchBy)) {
            index.setSettings(
                    new IndexSettings().setSearchableAttributes(Arrays.asList(
                            searchBy
                    )));
        }
        searchResult = index.search(new Query(keyword));
        return searchResult.getHits();
    }

    private SearchIndex<Record> createIndex() {
        return client.initIndex(RECORD_INDEX, Record.class);
    }
}

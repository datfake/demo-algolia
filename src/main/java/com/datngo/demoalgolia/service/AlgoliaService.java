package com.datngo.demoalgolia.service;

import com.datngo.demoalgolia.dto.RecordRequest;
import com.datngo.demoalgolia.model.Record;

import java.util.List;

public interface AlgoliaService {
    Record addRecord(RecordRequest recordRequest);
    List<Record> search(String keyword, String searchBy);
}

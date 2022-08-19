package com.datngo.demoalgolia.controller;

import com.datngo.demoalgolia.dto.RecordRequest;
import com.datngo.demoalgolia.model.Record;
import com.datngo.demoalgolia.service.AlgoliaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class AlgoliaController {

    private final AlgoliaService algoliaService;

    @PostMapping("/record")
    public ResponseEntity<Record> createObject(@RequestBody RecordRequest recordRequest) {
        try {
            return new ResponseEntity<>(algoliaService.addRecord(recordRequest), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/record")
    public ResponseEntity<List<Record>> search(@RequestParam String keyword,
                                               @RequestParam(defaultValue = "content") String searchBy) {
        try {
            return new ResponseEntity<>(algoliaService.search(keyword, searchBy), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

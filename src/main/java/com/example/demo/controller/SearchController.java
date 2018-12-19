package com.example.demo.controller;


import com.example.demo.model.Search;
import com.example.demo.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SuppressWarnings("all")
@RestController
@RequestMapping("/api")
public class SearchController {

    @Autowired
    private SearchService searchService;

    @PostMapping("search/trainSchedule")
    public ResponseEntity searchTrainScheduleNyCode(@RequestBody Search search){
        return new ResponseEntity<>(searchService.searchTrainScheduleByCode(search), HttpStatus.OK);
    }
}

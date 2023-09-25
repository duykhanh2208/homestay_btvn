package com.example.homestaymanagementgroup_four.controller;

import com.example.homestaymanagementgroup_four.model.Homestay;
import com.example.homestaymanagementgroup_four.service.implement.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/search")
public class SearchingController {
    @Autowired
    private SearchService searchService;

    @GetMapping("/{a}/{b}")
    public ResponseEntity<List<Homestay>> search(@PathVariable double a, @PathVariable double b) {
        List<Homestay> homestays = searchService.searchByPrice(a,b);
        return new ResponseEntity<>(homestays,HttpStatus.OK);
    }

    @GetMapping("/searchAmount/{a}/{b}")
    public ResponseEntity<List<Homestay>> searchAmount(@PathVariable double a, @PathVariable double b) {
        List<Homestay> homestays = searchService.searchByAmount(a,b);
        return new ResponseEntity<>(homestays,HttpStatus.OK);
    }
}

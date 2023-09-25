package com.example.homestaymanagementgroup_four.controller;

import com.example.homestaymanagementgroup_four.model.Homestay;
import com.example.homestaymanagementgroup_four.service.implement.HomeStayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/homestay")
public class HomestayController {
    @Autowired
    private HomeStayService homeStayService;

    @GetMapping ("")
    public ResponseEntity<Iterable<Homestay>> showList(){
        Iterable<Homestay> homestays = homeStayService.findAll();
        return new ResponseEntity<>(homestays, HttpStatus.OK);
    }

    @PostMapping("create")
    public ResponseEntity<Homestay> create(@RequestBody Homestay homestay){
        return new ResponseEntity<>(homeStayService.save(homestay),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Homestay> create(@RequestBody Homestay homestay, @PathVariable ("id") Long id){
       Optional<Homestay>  homestay1 = homeStayService.findById(id);
       if(!homestay1.isPresent()){
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       } else {
           homestay.setId(homestay1.get().getId());
           homeStayService.save(homestay);
       }
       return new ResponseEntity<>(homestay,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<Homestay> delete(@PathVariable Long id){
        Optional<Homestay> homestay = homeStayService.findById(id);
        if(!homestay.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } homeStayService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

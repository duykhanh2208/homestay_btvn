package com.example.homestaymanagementgroup_four.controller;

import com.example.homestaymanagementgroup_four.model.Service;
import com.example.homestaymanagementgroup_four.service.implement.IServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/services")
public class ServiceController {
    @Autowired
    private IServices services;

    @GetMapping("")
    public ResponseEntity<Iterable<Service>> listSmartphones() {
        return new ResponseEntity<>(services.findAll(), HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<Service> createService(@RequestBody Service service) {
        return new ResponseEntity<>(services.save(service), HttpStatus.CREATED);
    }

    @PutMapping ("/{id}")
    public ResponseEntity<Service> updateService(@RequestBody Service service, @PathVariable Long id) {
       Optional<Service> service1 = services.findById(id);
       //Do khai bao trong ham Iservice nen phai dung Optional khi goij ham findById

       service.setId(service1.get().getId());
       //Gan ID cua doi tuong moi = ID cua doi tuong can sua
       return new ResponseEntity<>(services.save(service),HttpStatus.OK);
       //Luu doi tuong moi vao database
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Service> delete(@PathVariable Long id) {
        Optional<Service> service = services.findById(id);
        services.remove(id);
        return new ResponseEntity<>(service.get(),HttpStatus.OK);
    }
}

package com.example.homestaymanagementgroup_four.controller;

import com.example.homestaymanagementgroup_four.model.Address;
import com.example.homestaymanagementgroup_four.model.Service;
import com.example.homestaymanagementgroup_four.service.implement.IAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/address")
public class AddressController {
    @Autowired
    private IAddressService addressService;

    @RequestMapping("")
    public ResponseEntity<Iterable<Address>> showList(){
        return new ResponseEntity<>(addressService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Address> create(@RequestBody Address address){
        return new ResponseEntity<>(addressService.save(address), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Address> create(@RequestBody Address address, @PathVariable Long id){
        Optional<Address> address1 = addressService.findById(id);
        if(address1.isPresent()){
            address.setId(address1.get().getId());
            return new ResponseEntity<>(addressService.save(address), HttpStatus.OK);
        }
       return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Address> create(@PathVariable ("id") Long id){
        Optional<Address> address = addressService.findById(id);
        if(!address.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } addressService.remove(id);
        return new ResponseEntity<>(address.get(),HttpStatus.OK);
    }

}

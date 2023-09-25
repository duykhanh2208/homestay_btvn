package com.example.homestaymanagementgroup_four.service.implement;

import com.example.homestaymanagementgroup_four.model.Address;
import com.example.homestaymanagementgroup_four.repository.IAddressRepository;
import com.example.homestaymanagementgroup_four.repository.IServiceRepository;
import com.example.homestaymanagementgroup_four.service.IGenerateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class IAddressService implements IGenerateService<Address> {
    @Autowired
    private IAddressRepository addressRepository;

    @Override
    public Iterable<Address> findAll() {
        return addressRepository.findAll();
    }

    @Override
    public Optional<Address> findById(Long id) {
        return addressRepository.findById(id);
    }

    @Override
    public Address save(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public void remove(Long id) {
        Optional<Address> address = addressRepository.findById(id);
        addressRepository.delete(address.get());
    }
}

package com.example.homestaymanagementgroup_four.service.implement;

import com.example.homestaymanagementgroup_four.model.Service;
import com.example.homestaymanagementgroup_four.repository.IServiceRepository;
import com.example.homestaymanagementgroup_four.service.IGenerateService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

@org.springframework.stereotype.Service
public class IServices implements IGenerateService<Service> {
    @Autowired
    private IServiceRepository serviceRepository;
    @Override
    public Iterable<Service> findAll() {
        Iterable<Service> listService = serviceRepository.findAll();
        return listService;
    }

    @Override
    public Optional<Service> findById(Long id) {
        Optional<Service> service = serviceRepository.findById(id);
        return service;
    }

    @Override
    public Service save(Service service) {
        serviceRepository.save(service);

        return service;
    }

    @Override
    public void remove(Long id) {
        Service service = serviceRepository.findById(id).get();
            serviceRepository.delete(service);
    }
}

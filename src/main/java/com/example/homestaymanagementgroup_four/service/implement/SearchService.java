package com.example.homestaymanagementgroup_four.service.implement;

import com.example.homestaymanagementgroup_four.model.Homestay;
import com.example.homestaymanagementgroup_four.repository.IHomestayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchService {
    @Autowired
    private IHomestayRepository homestayRepository;

    public List<Homestay> searchByPrice(double a, double b){
        List<Homestay> list = homestayRepository.searchByPrice(a,b);
        return list;
    }

    public List<Homestay> searchByAmount(double a, double b){
        List<Homestay> list = homestayRepository.searchAmount(a,b);
        return list;
    }
}

package com.example.homestaymanagementgroup_four.service.implement;

import com.example.homestaymanagementgroup_four.model.Homestay;
import com.example.homestaymanagementgroup_four.repository.IHomestayRepository;
import com.example.homestaymanagementgroup_four.service.IGenerateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HomeStayService implements IGenerateService<Homestay> {

    @Autowired
    private IHomestayRepository homestayRepository;

    @Override
    public Iterable<Homestay> findAll() {
        Iterable<Homestay> homestays = homestayRepository.findAll();
        return homestays;
    }

    @Override
    public Optional<Homestay> findById(Long id) {
        Optional<Homestay> homestay = homestayRepository.findById(id);
        return homestay;
    }

    @Override
    public Homestay save(Homestay homestay) {
        return homestayRepository.save(homestay);
    }

    @Override
    public void remove(Long id) {
        Optional<Homestay> homestay = homestayRepository.findById(id);
        homestayRepository.delete(homestay.get());
    }
}

package com.example.homestaymanagementgroup_four.repository;

import com.example.homestaymanagementgroup_four.model.Homestay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface IHomestayRepository extends JpaRepository<Homestay, Long> {
}

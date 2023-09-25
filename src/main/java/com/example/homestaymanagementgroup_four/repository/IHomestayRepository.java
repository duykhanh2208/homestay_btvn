package com.example.homestaymanagementgroup_four.repository;

import com.example.homestaymanagementgroup_four.model.Homestay;
import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface IHomestayRepository extends JpaRepository<Homestay, Long> {

    @Query(value = "SELECT * FROM homestay JOIN category c ON homestay.category_id = c.id WHERE price between ? and ? ", nativeQuery = true)
    List<Homestay> searchByPrice(double a, double b);
}

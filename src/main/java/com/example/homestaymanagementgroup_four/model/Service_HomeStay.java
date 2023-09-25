package com.example.homestaymanagementgroup_four.model;

import javax.persistence.*;

@Entity
@Table(name = "service_homestay")

public class Service_HomeStay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @ManyToOne
    @JoinColumn(name ="service_id")
    private Service service;
    @ManyToOne
    @JoinColumn(name ="homestay_id")
    public Homestay homestay;


}

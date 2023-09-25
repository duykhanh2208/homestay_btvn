package com.example.homestaymanagementgroup_four.model;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String province;

    @NotNull
    private String district;

    @NotNull
    private String wards;

    public Address() {
    }

    public Address(String province, String district, String wards) {
        this.province = province;
        this.district = district;
        this.wards = wards;
    }

    public Address(Long id, String province, String district, String wards) {
        this.id = id;
        this.province = province;
        this.district = district;
        this.wards = wards;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getWards() {
        return wards;
    }

    public void setWards(String wards) {
        this.wards = wards;
    }
}

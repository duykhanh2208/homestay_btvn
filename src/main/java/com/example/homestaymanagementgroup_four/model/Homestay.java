package com.example.homestaymanagementgroup_four.model;

import com.sun.istack.NotNull;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "homestay")
public class Homestay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String description;

    @NotNull
    private String locationDetail;

    @NotNull
    private Boolean isActive;

    @NotNull
    private  String  image;

    @Transient
    private MultipartFile file;

    @ManyToOne
    @JoinColumn(name ="address_id")
    private Address address;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public Homestay() {
    }

    public Homestay(String name, String description, String locationDetail, Boolean isActive, String image, Address address, Category category) {
        this.name = name;
        this.description = description;
        this.locationDetail = locationDetail;
        this.isActive = isActive;
        this.image = image;
        this.address = address;
        this.category = category;
    }

    public Homestay(Long id, String name, String description, String locationDetail, Boolean isActive, String image, Address address, Category category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.locationDetail = locationDetail;
        this.isActive = isActive;
        this.image = image;
        this.address = address;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocationDetail() {
        return locationDetail;
    }

    public void setLocationDetail(String locationDetail) {
        this.locationDetail = locationDetail;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}

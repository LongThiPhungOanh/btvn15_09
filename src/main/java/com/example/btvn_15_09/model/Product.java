package com.example.btvn_15_09.model;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;

@Entity
public class Product {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String name;
        private double price;
        private String description;
        private String path;
        @Transient
        private MultipartFile image;

        @ManyToOne
        @JoinColumn(name = "idCategory")
        private Category category;

    public Product(String name, double price, String path) {
        this.name = name;
        this.price = price;
        this.path = path;
    }

    public Product(String name, double price, String description, String path, Category category) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.path = path;
        this.category = category;
    }

    public Product(Long id, String name, double price, String description, String path, Category category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.path = path;
        this.category = category;
    }

    public Product() {
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }

}


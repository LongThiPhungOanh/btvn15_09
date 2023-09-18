package com.example.btvn_15_09.service;
import com.example.btvn_15_09.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductService extends IGenericService<Product> {
    void delete(Long id);
}

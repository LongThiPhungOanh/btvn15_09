package com.example.btvn_15_09.repository;
import com.example.btvn_15_09.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.awt.print.Pageable;
import java.util.List;

public interface IProductRepository extends PagingAndSortingRepository<Product, Long> {
   List<Product> findAll();
}

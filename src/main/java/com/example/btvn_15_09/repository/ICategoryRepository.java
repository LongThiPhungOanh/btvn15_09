package com.example.btvn_15_09.repository;
import com.example.btvn_15_09.model.Category;
import com.example.btvn_15_09.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ICategoryRepository extends PagingAndSortingRepository<Category, Long> {
}

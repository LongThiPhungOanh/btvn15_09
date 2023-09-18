package com.example.btvn_15_09.repository;
import com.example.btvn_15_09.model.Category;
import org.springframework.data.repository.CrudRepository;

public interface ICategoryRepository extends CrudRepository<Category, Long> {
}

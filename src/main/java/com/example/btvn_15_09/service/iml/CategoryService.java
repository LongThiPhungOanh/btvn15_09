package com.example.btvn_15_09.service.iml;
import com.example.btvn_15_09.model.Category;
import com.example.btvn_15_09.repository.iml.CategoryRepository;
import com.example.btvn_15_09.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {
@Autowired
    CategoryRepository categoryRep;
    @Override
    public List<Category> finAll() {
        return categoryRep.findAll();
    }

    @Override
    public Category finById(Long id) {
        return categoryRep.findById(id);
    }

    @Override
    public void create(Category category) {
        categoryRep.save(category);
    }

    @Override
    public void update(Category category) {
        categoryRep.save(category);
    }
}

package com.example.btvn_15_09.repository.iml;
import com.example.btvn_15_09.model.Category;
import com.example.btvn_15_09.model.Product;
import com.example.btvn_15_09.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
@Transactional
@Repository
public class CategoryRepository {
    @Autowired
    ICategoryRepository categoryRepository;
    public Page<Category> getProductPage(int pageNumber, int pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNumber - 1, pageSize);
        return categoryRepository.findAll(pageRequest);
    }
    public List<Category> findAll() {
        return (List<Category>) categoryRepository.findAll();
    }

    public Category findById(Long id) {
        Optional<Category> category = categoryRepository.findById(id);
        return category.orElse(null);
    }
    public void save(Category category) {
        categoryRepository.save(category);
    }
}

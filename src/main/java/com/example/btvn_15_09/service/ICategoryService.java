package com.example.btvn_15_09.service;

import com.example.btvn_15_09.model.Category;

import java.util.List;

public interface ICategoryService extends IGenericService<Category> {
    List<Category> finAll();
}

package com.example.btvn_15_09.service;

import java.util.List;

public interface IGenericService<E> {
    E finById(Long id);
    void create(E e);
    void update(E e);
}

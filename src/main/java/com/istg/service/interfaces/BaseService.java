package com.istg.service.interfaces;

import java.util.List;

public interface BaseService<T> {
    int save(T t);
    List<T> getAll();
    int update(T t);
    int delete(T t);
    T getById(Long id);
}

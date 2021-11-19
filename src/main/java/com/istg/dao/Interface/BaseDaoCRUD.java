package com.istg.dao.Interface;

import java.util.List;

public interface BaseDaoCRUD<T> {
    int save(T t);
    List<T> getAll();
    int update(T t);
    int delete(T t);
    T getById(Long id);
}

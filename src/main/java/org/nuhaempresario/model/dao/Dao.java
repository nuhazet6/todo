package org.nuhaempresario.model.dao;

import java.util.List;

public interface Dao<T, V> {
    T create(T entity);
    List<T> findAll();
    T findOneById(V id);
    T update(V id, T entity);
    void remove(V id);

}

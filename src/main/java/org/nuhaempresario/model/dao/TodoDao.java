package org.nuhaempresario.model.dao;

import jakarta.persistence.EntityManager;
import org.nuhaempresario.model.Todo;
import org.nuhaempresario.utils.EntityManagerHelper;

import java.util.List;

public class TodoDao implements Dao<Todo,Long>{
    EntityManager manager;

    public TodoDao() {
        manager = EntityManagerHelper.getInstance().getManager();
    }

    @Override
    public Todo create(Todo entity) {

        try {
           manager.getTransaction().begin();
           manager.persist(entity);
           manager.getTransaction().commit();
           return entity;
        }catch (Exception e){
            manager.getTransaction().rollback();
            return null;
        }
    }

    @Override
    public List<Todo> findAll() {
        return null;
    }

    @Override
    public Todo findOne(Long id) {
        return null;
    }

    @Override
    public Todo update(Long id, Todo entity) {
        return null;
    }

    @Override
    public void remove(Long id) {

    }
}

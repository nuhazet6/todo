package org.nuhaempresario.model.dao;

import jakarta.persistence.EntityManager;
import org.nuhaempresario.model.Todo;
import org.nuhaempresario.model.User;
import org.nuhaempresario.utils.EntityManagerHelper;

import java.sql.PreparedStatement;
import java.util.ArrayList;
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
        return manager.createQuery("select t from Todo t",Todo.class).getResultList();
    }

    @Override
    public Todo findOne(Long id) {
        return manager.createQuery("select t from Todo t where t.id = :id",Todo.class).setParameter("id",id).getSingleResult();
    }

    @Override
    public Todo update(Long id, Todo entity) {
        Todo updated = findOne(id);
        String title = entity.getTitle() != null ? entity.getTitle() : updated.getTitle();
        updated.setTitle(title);
        String content = entity.getContent() != null ? entity.getContent() : updated.getContent();
        updated.setContent(content);
        User user = entity.getUser() != null ? entity.getUser() : updated.getUser();
        updated.setUser(user);

        try {
            manager.getTransaction().begin();
            manager.persist(updated);
            manager.getTransaction().commit();
            return updated;
        }catch (Exception e){
            manager.getTransaction().rollback();
            return null;
        }
    }

    @Override
    public void remove(Long id) {

    }
}

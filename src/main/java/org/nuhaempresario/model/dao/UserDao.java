package org.nuhaempresario.model.dao;

import jakarta.persistence.EntityManager;
import org.nuhaempresario.model.Todo;
import org.nuhaempresario.model.User;
import org.nuhaempresario.utils.EntityManagerHelper;

import java.util.List;

public class UserDao implements Dao<User,Long> {

    EntityManager manager;

    public UserDao() {
        manager = EntityManagerHelper.getInstance().getManager();
    }
    @Override
    public User create(User entity) throws RuntimeException {
        try {
            manager.getTransaction().begin();
            manager.persist(entity);
            manager.getTransaction().commit();
            return entity;
        }catch (Exception e){
            manager.getTransaction().rollback();
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<User> findAll() {
        return manager.createQuery("select t from User t", User.class).getResultList();
    }

    @Override
    public User findOneById(Long id) {
        return manager.createQuery("select t from User t where t.id = :id",User.class).setParameter("id",id).getSingleResult();
    }

    @Override
    public User update(Long id, User entity) {
        User updated = findOneById(id);
        String password = entity.getPassword() != null ? entity.getPassword()  : updated.getPassword() ;
        updated.setPassword(password);
        String username = entity.getUsername() != null ? entity.getUsername() : updated.getUsername();
        updated.setUsername(username);

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
        User delete = findOneById(id);
        manager.remove(delete);
        manager.flush();
    }
}

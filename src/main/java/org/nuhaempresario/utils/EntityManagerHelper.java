package org.nuhaempresario.utils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerHelper {
    private static EntityManagerHelper helper;
    private final EntityManagerFactory factory;
    private EntityManager manager;
    private EntityManagerHelper(){
        factory = Persistence.createEntityManagerFactory("default");
    }
    public static EntityManagerHelper getInstance(){
        if(helper == null){
            helper = new EntityManagerHelper();
        }
        return helper;
    }

    public EntityManager getManager() {
        if(manager == null || (manager != null && !manager.isOpen())){
            manager = factory.createEntityManager();
        }
        return manager;
    }

    public void close(){
        factory.close();
        helper = null;
        manager = null;
    }
}

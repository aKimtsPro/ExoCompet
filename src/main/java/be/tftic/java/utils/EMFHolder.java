package be.tftic.java.utils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.HashMap;
import java.util.Map;

public class EMFHolder {
    private static EMFHolder instance;
    public static EMFHolder getInstance(){
        return instance == null ? instance = new EMFHolder() : instance;
    }

    private EntityManagerFactory emf;
//    private EntityManager entityManager;
    private final Map<String, String> propOverrides = new HashMap<>();

    public EMFHolder() {}


    public EntityManager getEntityManager(){
        return emf.createEntityManager();
    }

    public void open(){
        emf = Persistence.createEntityManagerFactory("compet_db", this.propOverrides);
    }

    public EMFHolder overrideProp(String key, String value){
        if( emf != null )
            throw new IllegalStateException("EMF is already opened");

        this.propOverrides.put(key, value);
        return this;
    }

    public void close(){
        emf.close();
    }
}

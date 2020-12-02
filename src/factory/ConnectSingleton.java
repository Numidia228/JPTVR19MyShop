package factory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnectSingleton {
    private EntityManagerFactory emf;
    private EntityManager em;
    private static ConnectSingleton instance;
    private ConnectSingleton(){
        emf = Persistence.createEntityManagerFactory("JPTVR19LibraryPU");
        em = emf.createEntityManager();
    }
    public static ConnectSingleton getInstance(){
        if(instance == null){
            instance = new ConnectSingleton();
        }
        return instance;
    }
    public EntityManager getEntityManager(){
        return em;
    }
    public EntityManagerFactory getEntityManagerFactory(){
        return emf;
    }
}

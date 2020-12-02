package entity.facade;

import entity.User;
import factory.ConnectSingleton;
import javax.persistence.EntityManager;

public class UserFacade extends AbstractFacade<User>{
    private EntityManager em;

    public UserFacade() {
        super(User.class);
        ConnectSingleton connect = ConnectSingleton.getInstance();
        em = connect.getEntityManager();
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
}

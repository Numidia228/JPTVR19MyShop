package entity.facade;

import entity.Customer;
import factory.ConnectSingleton;
import javax.persistence.EntityManager;

public class CustomerFacade extends AbstractFacade<Customer>{

    private EntityManager em;

    public CustomerFacade() {
        super(Customer.class);
        ConnectSingleton connect = ConnectSingleton.getInstance();
        em = connect.getEntityManager();
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
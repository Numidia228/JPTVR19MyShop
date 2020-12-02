package entity.facade;

import entity.Purchase;
import entity.Customer;
import factory.ConnectSingleton;
import javax.persistence.EntityManager;
import java.util.List;

public class PurchaseFacade extends AbstractFacade<Purchase>{

    private EntityManager em;

    public PurchaseFacade() {
        super(Purchase.class);
        ConnectSingleton connect = ConnectSingleton.getInstance();
        em = connect.getEntityManager();
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    public List<Purchase> findReadAll(Customer customer, Boolean read) {
        if(read == true){
            try {
                return em.createQuery("SELECT h FROM Purchase h WHERE h.customer = :customer")
                        .setParameter("customer", customer)
                        .getResultList();
            } catch (Exception e) {
                return null;
            }
        }else{
            try {
                return em.createQuery("SELECT h FROM Purchase h WHERE h.customer = :customer")
                        .setParameter("customer", customer)
                        .getResultList();
            } catch (Exception e) {
                return null;
            }
        }
    }
}
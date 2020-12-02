package entity.facade;

import entity.Product;
import factory.ConnectSingleton;
import javax.persistence.EntityManager;

public class ProductFacade extends AbstractFacade<Product>{

    private EntityManager em;

    public ProductFacade() {
        super(Product.class);
        ConnectSingleton connect = ConnectSingleton.getInstance();
        em = connect.getEntityManager();
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }


}
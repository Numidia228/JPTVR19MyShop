package factory;

import entity.facade.ProductFacade;
import entity.facade.PurchaseFacade;
import entity.facade.CustomerFacade;
import entity.facade.UserFacade;

public class FactoryFacade {

    public static ProductFacade getProductFacade() {
        return new ProductFacade();
    }

    public static CustomerFacade getCustomerFacade() {
        return new CustomerFacade();
    }

    public static UserFacade getUserFacade() {
        return new UserFacade();
    }

    public static PurchaseFacade getPurchaseFacade() {
        return new PurchaseFacade();
    }
}
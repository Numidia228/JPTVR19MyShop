package tools;

import entity.Product;
import entity.Purchase;
import entity.Customer;
import entity.User;
import entity.facade.ProductFacade;
import entity.facade.PurchaseFacade;
import entity.facade.CustomerFacade;
import factory.FactoryFacade;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;

import com.company.App;
import security.SecureManager;

public class PurchaseManager {
    private Scanner scanner = new Scanner(System.in);
    private CustomerManager customerManager = new CustomerManager();
    private ProductManager productManager = new ProductManager();
    private CustomerFacade customerFacade = FactoryFacade.getCustomerFacade();
    private ProductFacade productFacade = FactoryFacade.getProductFacade();
    private PurchaseFacade purchaseFacade = FactoryFacade.getPurchaseFacade();
    private Product product = new Product();
    private Purchase purchase = new Purchase();

    public Purchase makeDeal() {
        Customer customer = null;
        User loggedInUser = App.loginedUser;
        Calendar calendar = new GregorianCalendar();

        if ("MANAGER".equals(loggedInUser.getRole())) {
            System.out.println("--- Список читателей ---");
            customerManager.printListCustomers();
            System.out.print("Выберите номер читателя: ");
            Long customerNumber = scanner.nextLong();
            scanner.nextLine();
            customer = customerFacade.find(customerNumber);
        }

        double residual;
        residual = customer.getBalance() - product.getPrice();
        if (residual < 0) {
            System.out.println("Недостаточно средств для покупки");
            System.out.println("Баланс: " + customer.getBalance() + "€");
            return null;
        } else {
            customer.setBalance(residual);
            purchase = new Purchase(customer, product, calendar.getTime());
            purchaseFacade.create(purchase);
        }
        return purchase;
    }

    private void printPurchase(Purchase history) {
        System.out.printf("Книга \"%s\" выдана %s %s%n"
                , history.getProduct().getName()
                , history.getCustomer().getFirstName()
                , history.getCustomer().getLastName()
        );
    }

    public void printListBoughtProducts() {
        List<Purchase> listPurchases = purchaseFacade.findReadAll(App.loginedUser.getCustomer(), true);
        for (int i = 0; i < listPurchases.size(); i++) {
            if (listPurchases.get(i) != null)
                System.out.printf("%d. Клиент %s %s купил \"%s\"%n"
                        , i + 1
                        , listPurchases.get(i).getCustomer().getFirstName()
                        , listPurchases.get(i).getCustomer().getLastName()
                        , listPurchases.get(i).getProduct().getName()
                );
        }
    }
}
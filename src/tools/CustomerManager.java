package tools;

import entity.Customer;
import entity.facade.CustomerFacade;
import factory.FactoryFacade;

import java.util.List;
import java.util.Scanner;

public class CustomerManager {
    private CustomerFacade customerFacade = FactoryFacade.getCustomerFacade();
    private Scanner scanner = new Scanner(System.in);

    public Customer createCustomer() {
        Customer customer = new Customer();
        System.out.println("Введите имя: ");
        customer.setFirstName(scanner.nextLine());
        System.out.println("Введите фамилию: ");
        customer.setLastName(scanner.nextLine());
        System.out.println("Введите номер телефона: ");
        customer.setPhone(scanner.nextLine());
        double numBalance;
        do {
            System.out.println("Введите баланс счета: ");
            String strBalance = scanner.nextLine();
            try {
                numBalance = Double.parseDouble(strBalance);
                break;
            } catch (Exception e) {
                System.out.println("Можно использовать только цифры.");
            }
        } while (true);
        customer.setBalance(numBalance);
        return customer;
    }

    public void printCustomer(Customer customer) {
        System.out.println("Имя читателя: "
                + customer.getFirstName()
                + " "
                + customer.getLastName()
        );
    }

    public void printListCustomers() {
        List<Customer> listCustomers = customerFacade.findAll();
        for (int i = 0; i < listCustomers.size(); i++) {
            if (listCustomers.get(i) != null) {
                System.out.println(listCustomers.get(i).getId() + ". " + listCustomers.get(i).toString());
            }
        }
    }
}
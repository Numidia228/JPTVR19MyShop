package ui;

import entity.Product;
import entity.Purchase;
import entity.User;
import tools.CustomerManager;
import tools.ProductManager;
import tools.PurchaseManager;
import tools.UserManager;

import java.util.Scanner;

public class ManagerUI {

    private ProductManager productManager = new ProductManager();
    private UserManager userManager = new UserManager();
    private CustomerManager customerManager = new CustomerManager();
    private PurchaseManager purchaseManager = new PurchaseManager();

    public void getManagerUI() {
        boolean repeat = true;
        do {
            System.out.println("=============================================");
            System.out.println("Список операций: ");
            System.out.println("0. Покинуть магазин");
            System.out.println("1. Добавить товар");
            System.out.println("2. Просмотреть список товаров");
            System.out.println("3. Добавить покупателя");
            System.out.println("4. Просмотреть список покупателей");
            System.out.println("5. Купить товар");
            System.out.println("6. Просмотреть список покупок");
            System.out.println("=============================================");
            System.out.println("Выберите номер задачи: ");
            Scanner scanner = new Scanner(System.in);
            String task = scanner.nextLine();
            switch (task) {
                case "0":
                    System.out.println(" --- Выход из магазина --- ");

                    repeat = false;

                    break;
                case "1":
                    System.out.println(" --- Добавление товара --- ");

                    Product product = productManager.createProduct();

                    break;
                case "2":
                    System.out.println(" --- Список товаров --- ");

                    productManager.printListProducts();

                    break;
                case "3":
                    System.out.println(" --- Зарегистрировать пользователя --- ");

                    User user = userManager.createUser();

                    break;
                case "4":
                    System.out.println(" --- Список пользователей --- ");

                    customerManager.printListCustomers();

                    break;
                case "5":
                    System.out.println(" --- Сделать покупку --- ");

                    Purchase purchase = purchaseManager.makeDeal();

                    break;
                case "6":
                    System.out.println(" --- История покупок --- ");

                    purchaseManager.printListBoughtProducts();

                    break;
                default:
                    System.out.println("Нет такой задачи!");
            }
        } while (repeat);
    }
}

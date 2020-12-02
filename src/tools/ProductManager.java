package tools;

import entity.Product;
import entity.facade.ProductFacade;
import factory.FactoryFacade;
import java.util.List;
import java.util.Scanner;

public class ProductManager {
    private ProductFacade productFacade = FactoryFacade.getProductFacade();
    private Scanner scanner = new Scanner(System.in);

    public Product createProduct() {
        Product product = new Product();
        System.out.printf("Название товара: ");
        Scanner scan = new Scanner(System.in);
        product.setName(scan.nextLine());
        double numPrice;
        do {
            System.out.println("Стоимость товара: ");
            String strPrice = scan.nextLine();
            try {
                numPrice = Double.parseDouble(strPrice);
                break;
            } catch (Exception e) {
                System.out.println("Можно использовать только цифры.");
            }
        } while (true);
        product.setPrice(numPrice);
        return product;
    }

    public void printListProducts() {
        List<Product> listProducts = productFacade.findAll();
        for (int i = 0; i < listProducts.size(); i++) {
            if(listProducts.get(i) != null){
                System.out.println(listProducts.get(i).getId()+". " + listProducts.get(i).toString());
            }
        }
    }

}
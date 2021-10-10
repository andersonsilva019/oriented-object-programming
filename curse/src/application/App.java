import java.util.Locale;
import java.util.Scanner;

import entities.Product;

public class App {
    public static void main(String[] args) throws Exception {
        Locale.setDefault(Locale.US);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter product data: ");
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Price: ");
        double price = scanner.nextDouble();
        System.out.print("Quantity in Stock: ");
        int quantity = scanner.nextInt();

        Product product = new Product(name, price, quantity);

        System.out.println("Product data: " + product.toString());

        System.out.println();
        System.out.println("Enter the number of products to be added in stock: ");
        quantity = scanner.nextInt();
        product.addProduct(quantity);

        System.out.println("Updated data: " + product.toString());

        System.out.println();
        System.out.println("Enter the number of products to be removed in stock: ");
        quantity = scanner.nextInt();
        product.removeProduct(quantity);

        System.out.println("Updated data: " + product.toString());

        scanner.close();
    }
}

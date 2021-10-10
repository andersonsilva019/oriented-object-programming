import java.util.Locale;
import java.util.Scanner;

import entities.Rectangle;

public class AppRectangle {
  public static void main(String[] args) {
    Locale.setDefault(Locale.US);
    Scanner scanner = new Scanner(System.in);

    System.out.println("Enter rectangle width and height: ");
    Rectangle rectangle = new Rectangle();
    rectangle.setWidth(scanner.nextDouble());
    rectangle.setHeight(scanner.nextDouble());

    System.out.printf("%.2f", rectangle.calcArea());
    System.out.println(); // Remove o sinal de "%"

    scanner.close();
  }
}

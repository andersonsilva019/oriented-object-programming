import java.util.Locale;
import java.util.Scanner;

public class Problema3 {
  public static void main(String args[]) {

    Locale.setDefault(Locale.US);

    Scanner scanner = new Scanner(System.in);

    int N = scanner.nextInt();

    System.out.printf("%.6f%n", euler(N));

    scanner.close();
  }

  public static double euler(int num) {
    double result = 1;
    while (num >= 1) {
      result += 1 / fatorial(num);
      num--;
    }
    return result;
  }

  public static double fatorial(int num) {
    double result = 1;
    while (num >= 1) {
      result += result * (num - 1);
      num--;
    }
    return result;
  }
}
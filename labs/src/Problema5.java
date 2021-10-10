import java.util.Locale;
import java.util.Scanner;

public class Problema5 {
  public static void main(String args[]) {
    Locale.setDefault(Locale.US);

    Scanner scanner = new Scanner(System.in);

    int N = scanner.nextInt();

    for (int i = 0; i < N; i++) {

      // Imprime os pontos da esquerda
      for (int j = 0; j < (N - 1 - i); j++) {
        System.out.print(".");
      }

      // Imprime os numeros
      System.out.printf("%d", N);
      for (int k = 0; k < ((i + 1) - 1); k++) {
        System.out.printf(".%d", N);
      }

      // Imprime os pontos da direita
      for (int l = 0; l < (N - 1 - i); l++) {
        System.out.print(".");
      }

      System.out.println();
    }
    scanner.close();
  }
}

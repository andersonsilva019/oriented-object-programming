import java.util.Locale;
import java.util.Scanner;

public class Problema7 {
  public static void main(String args[]) {

    Locale.setDefault(Locale.US);

    Scanner scanner = new Scanner(System.in);

    int N = scanner.nextInt();

    int[] fila = new int[N];
    int[] impares = new int[N];
    int[] pares = new int[N];

    for (int i = 0; i < N; i++) {
      fila[i] = scanner.nextInt();
    }

    for (int i = 0; i < fila.length; i++) {
      if (fila[i] % 2 == 0) {
        pares[i] = fila[i];
      } else {
        impares[i] = fila[i];
      }
    }

    // Imprimindo os pares
    System.out.print("[");
    for (int i = 0; i < impares.length; i++) {
      if (impares[i] != 0) {
        System.out.print(" " + impares[i]);
      }
    }
    System.out.println(" ]");

    // Imprimindo os pares
    System.out.print("[");
    for (int i = 0; i < pares.length; i++) {
      if (pares[i] != 0) {
        System.out.print(" " + pares[i]);
      }
    }
    System.out.println(" ]");

    scanner.close();
  }
}

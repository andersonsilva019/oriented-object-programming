import java.util.Locale;
import java.util.Scanner;

public class Problema8 {
  public static void main(String args[]) {
    Locale.setDefault(Locale.US);

    Scanner scanner = new Scanner(System.in);

    int N = scanner.nextInt();
    int[] vetor = new int[N];
    int contador = 0;

    for (int i = 0; i < N; i++) {
      vetor[i] = scanner.nextInt();
    }

    for (int i = 0; i < vetor.length; i++) {
      for (int j = i + 1; j < vetor.length; j++) {
        if (vetor[i] == vetor[j]) {
          vetor[j] = 0;
        }
      }
    }

    for (int i = 0; i < vetor.length; i++) {
      if (vetor[i] != 0) {
        contador++;
      }
    }

    System.out.println(contador);

    scanner.close();
  }
}

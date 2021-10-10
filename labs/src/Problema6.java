import java.util.Scanner;

public class Problema6 {
  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);

    boolean isOrdered = true;

    int N = scanner.nextInt();

    int[] vetor = new int[N];

    for (int i = 0; i < N; i++) {
      vetor[i] = scanner.nextInt();
    }

    for (int i = 0; i < N; i++) {
      for (int j = i + 1; j <= N - 1; j++) {
        if (vetor[i] > vetor[j]) {
          isOrdered = false;
        }
      }
    }

    if (isOrdered) {
      System.out.println("ok");
    } else {
      System.out.println("precisa de ajuste");
    }

    scanner.close();
  }
}

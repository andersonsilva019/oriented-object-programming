import java.util.Locale;
import java.util.Scanner;

public class Problema2 {
  public static void main(String args[]) {
    Locale.setDefault(Locale.US);

    Scanner scanner = new Scanner(System.in);

    int N = scanner.nextInt();

    int qtdPossiveisGanhadores = 0;

    int[] arremessoA = new int[N];
    int[] arremessoB = new int[N];
    int[] ganhadores = new int[N];

    int vencedor = -1;

    for (int i = 0; i < N; i++) {
      arremessoA[i] = scanner.nextInt();
      arremessoB[i] = scanner.nextInt();
    }

    // Pegando os possiveis ganhadores
    for (int i = 0; i < N; i++) {
      if (arremessoA[i] >= 10 && arremessoB[i] >= 10) {
        ganhadores[qtdPossiveisGanhadores] = i;
        qtdPossiveisGanhadores++;
      }
    }

    // Definindo o ganhador
    if (qtdPossiveisGanhadores > 1) {
      for (int i = 0; i < qtdPossiveisGanhadores - 1; i++) {
        int resultPrev = arremessoA[ganhadores[i]] - arremessoB[ganhadores[i]];
        int resultNext = arremessoA[ganhadores[i + 1]] - arremessoB[ganhadores[i + 1]];

        if (resultPrev < 0) {
          resultPrev *= -1;
        }

        if (resultNext < 0) {
          resultNext *= -1;
        }

        if (resultPrev < resultNext) {
          vencedor = ganhadores[i];
        } else {
          vencedor = ganhadores[i + 1];
        }

      }
    } else {
      if (arremessoA[ganhadores[0]] >= 10 && arremessoB[ganhadores[0]] >= 10) {
        vencedor = ganhadores[0];
      }
    }

    if (vencedor == -1) {
      System.out.println("sem ganhador");
    } else {
      System.out.println(vencedor);
    }

    scanner.close();
  }
}

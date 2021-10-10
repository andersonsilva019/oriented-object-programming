import java.util.Locale;
import java.util.Scanner;

public class Problema9 {
  public static void main(String args[]) {

    Locale.setDefault(Locale.US);

    Scanner scanner = new Scanner(System.in);

    int N = scanner.nextInt();
    float[] vProdutos = new float[N];
    float[] chutesJogadorA = new float[N];
    char[] chutesJogadorB = new char[N];

    int pontosJogadorA = 0;
    int pontosJogadorB = 0;

    // Valor dos produtos
    for (int i = 0; i < N; i++) {
      vProdutos[i] = scanner.nextFloat();
    }

    // Chutes do primeiro jogador
    for (int i = 0; i < N; i++) {
      chutesJogadorA[i] = scanner.nextFloat();
    }

    // Chutes do segundo jogador
    for (int i = 0; i < N; i++) {
      chutesJogadorB[i] = scanner.next().charAt(0);
      ;
    }

    for (int i = 0; i < N; i++) {
      if ((vProdutos[i] < chutesJogadorA[i]) && (chutesJogadorB[i] == 'm')) {
        pontosJogadorB++;
      } else if ((vProdutos[i] > chutesJogadorA[i]) && (chutesJogadorB[i] == 'M')) {
        pontosJogadorB++;
      } else {
        pontosJogadorA++;
      }
    }

    if (pontosJogadorA == pontosJogadorB) {
      System.out.println("empate");
    }
    if (pontosJogadorA > pontosJogadorB) {
      System.out.println("primeiro");
    }
    if (pontosJogadorB > pontosJogadorA) {
      System.out.println("segundo");
    }

    scanner.close();
  }
}

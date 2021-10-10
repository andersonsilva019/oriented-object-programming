import java.util.Locale;
import java.util.Scanner;

public class Problema4 {
  public static void main(String args[]) {
    Locale.setDefault(Locale.US);

    Scanner scanner = new Scanner(System.in);

    int A = scanner.nextInt();
    int B = scanner.nextInt();

    while (A <= B) {
      if (primo(A)) {
        System.out.println(A);
      }
      A++;
    }

    scanner.close();
  }

  public static boolean primo(int num) {

    int qtdDivisores = 0;

    for (int i = 1; i <= num; i++) {
      if (num % i == 0) { // Pegando o resto da divisao
        qtdDivisores++;
      }
    }

    if (!(qtdDivisores == 2)) { // Significa que o num nao é divisivel por 1 e ele mesmo
      return false;
    } else {
      return true;
    }
  }
}

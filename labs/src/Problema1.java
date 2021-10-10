import java.util.Locale;
import java.util.Scanner;

public class Problema1 {
    public static void main(String[] args) throws Exception {
        Locale.setDefault(Locale.US);

        int menor = 50; // Pode ser qualquer valor maior que 30

        int[] array = new int[5];

        Scanner scanner = new Scanner(System.in);
        // Obtendo os 5 numeros
        for (int i = 0; i < 5; i++) {
            array[i] = scanner.nextInt();
        }
        // Encontrando o menor
        for (int i = 0; i < array.length; i++) {
            if (array[i] < menor) {
                menor = array[i];
            }
        }

        System.out.println(menor);
        scanner.close();
    }
}

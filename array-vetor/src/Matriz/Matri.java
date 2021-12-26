package Matriz;

import java.util.Scanner;

public class Matri {
  private static Scanner sc = new Scanner(System.in);
  public static void main(String[] args) {
    int n = sc.nextInt();
    int[][] matriz = new int[n][n];

    preencheMatriz(matriz);
    imprimeMatriz(matriz);
    
  }

  public static void preencheMatriz(int[][] m){
    /**
     * m.length -> Número de linhas
     * m[0].length -> Número de elementos da coluna 0
     */
    for(int i = 0; i < m.length; i++){
      for(int j = 0; j < m[i].length; j++){
        m[i][j] = sc.nextInt();
      }
    }
  }

  public static void imprimeMatriz(int[][] m){
    for(int i = 0; i < m.length; i++){
      for(int j = 0; j < m[i].length; j++){
        System.out.print(m[i][j] + " ");
      }
      System.out.println();
    }
  }
}

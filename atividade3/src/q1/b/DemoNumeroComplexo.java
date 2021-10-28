package q1.b;

import q1.a.NumeroComplexo;

public class DemoNumeroComplexo {
  public static void main(String[] args) {
    NumeroComplexo num1 = new NumeroComplexo();
    NumeroComplexo num2 = new NumeroComplexo();

    // Soma
    num1.inicializaNumero(2, 3);
    num2.inicializaNumero(1, 2);
    NumeroComplexo resultadoSoma = num1.soma(num2);
    System.out.print("Soma: ");
    resultadoSoma.imprimeNumero();
    
    // Subtracao
    NumeroComplexo resultadoSubtracao = num1.subtrai(num2);
    System.out.print("Subtracao: ");
    resultadoSubtracao.imprimeNumero();
    
    //Multiplicacao
    num1.inicializaNumero(5, 2);
    num2.inicializaNumero(2, 4);
    NumeroComplexo resultadoMultiplicacao = num1.multiplica(num2);
    System.out.print("Multiplicacao: ");
    resultadoMultiplicacao.imprimeNumero();
    
    //Divisao
    num1.inicializaNumero(2, 24);
    num2.inicializaNumero(1, 2);
    NumeroComplexo resultadoDivisao = num1.divide(num2);
    System.out.print("Divisão: ");
    resultadoDivisao.imprimeNumero();

    // Verificando se são iguais
    num1.inicializaNumero(5, 2);
    num2.inicializaNumero(5, 2);
    if(num1.ehIgual(num2)){
      System.out.println("Número iguais!");
    }else{
      System.out.println("Número diferentes!");
      
    // Verificando se são diferentes
    }num1.inicializaNumero(5, 2);
    num2.inicializaNumero(5, 1);
    if(num1.ehIgual(num2)){
      System.out.println("Número iguais!");
    }else{
      System.out.println("Número diferentes!");
    }

    NumeroComplexo num10 = new NumeroComplexo();
    num10.inicializaNumero(1, -10);

    num10.imprimeNumero();
  }
}

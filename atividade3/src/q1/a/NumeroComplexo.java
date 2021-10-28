package q1.a;

public class NumeroComplexo { 
    
  private double parteReal;
  private double parteImaginaria;

  /**
     * Método de inicialização
     *
     * @param parteReal - parte real
     * @param parteImaginaria - parte imaginária
     */
  public void inicializaNumero(double parteReal, double parteImaginaria){
    this.parteReal = parteReal;
    this.parteImaginaria = parteImaginaria;
  }

  public void imprimeNumero(){
    if(this.parteImaginaria < 0){
      System.out.println(this.parteReal + " " + this.parteImaginaria + "i");
    }else {
      System.out.println(this.parteReal + " + " + this.parteImaginaria + "i");
    }
  }

  /**
   * Método que retorna se os numeros complexos são iguais
   * 
   * @param numero
   * @return Este método retorna true se os numeros sao iguai e false caso contrario.
   */
  public boolean ehIgual(NumeroComplexo numero){
    if(numero.getParteReal() == this.parteReal && numero.getParteImaginaria() == this.parteImaginaria){
      return true;
    }else{
      return false;
    }
  }

  /**
   * Método que retorna a soma
   * @param numero
   * @return Este metodo retorna um novo numero complexo com o resultado da soma
   */
  public NumeroComplexo soma(NumeroComplexo numero){
    double parteRealSoma = this.parteReal + numero.getParteReal();
    double parteImaginariaSoma = this.parteImaginaria + numero.getParteImaginaria();
    NumeroComplexo soma = new NumeroComplexo();
    soma.inicializaNumero(parteRealSoma, parteImaginariaSoma);
    return soma;
  }

  /**
   * Método que retorna a subtração
   * @param numero
   * @return Este metodo retorna um novo numero complexo com o resultado da subtracao
   */
  public NumeroComplexo subtrai(NumeroComplexo numero){
    double parteRealSubtrai = this.parteReal - numero.getParteReal();
    double parteImaginariaSubtrai = this.parteImaginaria - numero.getParteImaginaria();
    NumeroComplexo subtracao = new NumeroComplexo();
    subtracao.inicializaNumero(parteRealSubtrai, parteImaginariaSubtrai);
    return subtracao;
  }

  /**
   * Método que retorna a multiplicação
   * @param numero
   * @return Este metodo retorna um novo numero complexo com o resultado da multiplicacao
   */
  public NumeroComplexo multiplica(NumeroComplexo numero){
    double parteRealMul = (this.parteReal * numero.getParteReal()) - (this.parteImaginaria * numero.getParteImaginaria());
    double parteImaginariaMul = (this.parteReal * numero.getParteImaginaria()) + (this.parteImaginaria * numero.getParteReal());
    NumeroComplexo mul = new NumeroComplexo();
    mul.inicializaNumero(parteRealMul, parteImaginariaMul);
    return mul;
  }

  /**
   * Método que retorna a divisão
   * 
   * @param numero
   * @return  Este metodo retorna um novo numero complexo com o resultado da divisao
   */
  public NumeroComplexo divide(NumeroComplexo numero){
    double parteRealDiv = (((this.parteReal * numero.getParteReal()) + (this.parteImaginaria * numero.getParteImaginaria()))
                / ((numero.getParteReal() * numero.getParteReal()) + (numero.getParteImaginaria() * numero.getParteImaginaria())));    
    double parteImaginariaDiv = (((this.parteImaginaria * numero.getParteReal()) - (this.parteReal * numero.getParteImaginaria()))
                / ((numero.getParteReal() * numero.getParteReal()) + (numero.getParteImaginaria() * numero.getParteImaginaria())));
    NumeroComplexo div = new NumeroComplexo();

    div.inicializaNumero(parteRealDiv, parteImaginariaDiv);

    return div;
  }

  public double getParteReal() {
    return this.parteReal;
  }

  public double getParteImaginaria() {
    return this.parteImaginaria;
  }
}

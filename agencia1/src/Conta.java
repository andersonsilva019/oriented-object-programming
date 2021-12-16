public class Conta {
  // Atributos

  private int id; // O número da conta
  private Financas financas;

  /**
   * Método construtor
   * 
   * @param id O número da conta
   */
  public Conta(int id) {
    this.id = id;
    this.financas = new Financas();
    this.financas.addOperacao(Label.abertura, 0);
  }

  // só realiza a operação se houver dinheiro suficiente na conta
  /**
   * Método que realiza uma operação de saque
   * 
   * @param value O valor a ser sacado
   * @return true se o saque foi realizado com sucesso, false caso contrário
   */
  public boolean sacar(int value) {
    Boolean hasBalance = this.financas.getSaldo() >= value;
    if (!hasBalance) {
      System.out.println("fail: saldo insuficiente");
      return false;
    }
    this.financas.addOperacao(Label.saque, value);
    return true;
  }

  // retira o dinheiro, mesmo que o saldo fique negativo
  /**
   * Método que realiza uma operação de tarifa
   * 
   * @param value O valor da tarifa
   * @return true se a tarifa foi realizada com sucesso, false caso contrário
   */
  public boolean tarifar(int value) {
    this.financas.addOperacao(Label.tarifa, value);
    return true;
  }

  // se o índice for válido e representar uma operação de tarifa
  // adicione o mesmo valor tarifado, mas com label de extorno
  /**
   * Método que realiza uma operação de extorno
   * 
   * @param indice O índice da operação
   * @return true se o extorno foi realizado com sucesso, false caso contrário
   */
  public boolean extornar(int indice) {
    if (indice < 0 || indice >= this.financas.getExtrato().size()) {
      System.out.println("fail: indice " + indice + " invalido");
      return false;
    }

    if (this.financas.getExtrato().get(indice).getLabel() != Label.tarifa) {
      System.out.println("fail: indice " + indice + " nao e tarifa");
      return false;
    }
    this.financas.addOperacao(Label.extorno, this.financas.getExtrato().get(indice).getValue());
    return true;
  }

  // adiciona valor à conta
  /**
   * Método que realiza uma operação de depósito
   * 
   * @param label O label da operação
   * @param value O valor da operação
   * @return true se o depósito foi realizado com sucesso, false caso contrário
   */
  public boolean creditar(Label label, int value) {
    if (value <= 0) {
      System.out.println("fail: valor invalido");
      return false;
    }
    this.financas.addOperacao(label, value);
    return true;
  }

  @Override
  public String toString() {
    return String.format("conta:%d saldo:%d", this.id, this.financas.getSaldo());
  }

  public Financas getFinancas() {
    return this.financas;
  }
}

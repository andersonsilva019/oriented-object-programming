import java.util.ArrayList;
import java.util.List;

public class Financas {
  // O id da próxima operação dessa conta
  private int nextId;
  // A lista de operações realizadas
  private List<Operacao> extrato;
  private int saldo;

  public Financas() {
    this.nextId = 0;
    this.extrato = new ArrayList<Operacao>();
    this.saldo = 0;
  }

  // Adiciona value ao saldo
  // Crie operação e adiciona ao vetor de operações
  // Incrementa o nextId
  public void addOperacao(Label label, int value) {
    switch (Label.valueOf(label.toString())) {
      case abertura:
        this.saldo = value;
        this.extrato.add(new Operacao(this.nextId, label, value, this.saldo));
        this.nextId++;
        break;
      case deposito:
        this.saldo += value;
        this.extrato.add(new Operacao(this.nextId, label, value, this.saldo));
        this.nextId++;
        break;
      case saque:
        this.saldo -= value;
        this.extrato.add(new Operacao(this.nextId, label, -value, this.saldo));
        this.nextId++;
        break;
      case tarifa:
        this.saldo -= value;
        this.extrato.add(new Operacao(this.nextId, label, -value, this.saldo));
        this.nextId++;
        break;
      case extorno:
        this.saldo += (value * -1);
        this.extrato.add(new Operacao(this.nextId, label, (value * -1), this.saldo));
        this.nextId++;
        break;
      default:
        break;
    }

  }

  public int getSaldo() {
    return this.saldo;
  }

  public List<Operacao> getExtrato() {
    return this.extrato;
  }

  public List<Operacao> getExtrato(int qtdOp) {
    return this.extrato.subList(this.extrato.size() - qtdOp, this.extrato.size());
  }
}
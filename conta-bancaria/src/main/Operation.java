package main;

public class Operation {

  public static int qtdOperations = 0;

  private int id;
  private String type;
  private float amount;
  private float balance;

  public Operation(String type, float amount, float balance) {
    this.id = qtdOperations;
    qtdOperations++;
    this.type = type;
    this.amount = amount;
    this.balance = balance;
  }

  public String toString() {
    if (this.type == "saque" || this.type == "tarifa") {
      return this.id + ": " + this.type + ": " + (this.amount * -1) + ": " + this.balance;
    } else {
      return this.id + ": " + this.type + ": " + this.amount + ": " + this.balance;
    }
  }
}

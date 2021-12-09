package main;

import java.util.ArrayList;
import java.util.List;

public class Account {
  private int number;
  private float balance;
  private ArrayList<Operation> operations;

  public Account(int number) {
    this.number = number;
    this.balance = 0;
    operations = new ArrayList<>();
  }

  public void getExtract() {
    for (int i = 0; i < Operation.qtdOperations; i++) {
      System.out.println(this.operations.get(i));
    }
  }

  public void credit(float amount) {
    if (amount <= 0) {
      System.out.println("Deposite uma valor válido");
      return;
    } else {
      this.balance += amount;
      Operation operation = new Operation("deposito", amount, this.balance);
      operations.add(operation);
    }
  }

  public void setRate(float amount) {
    this.balance -= amount;
    Operation operation = new Operation("tarifa", amount, this.balance);
    operations.add(operation);
  }

  // public Operation nGetOperations(int n){
  // return this.operations.get
  // }

  public void debit(float amount) {
    if (this.balance - amount < 0) {
      System.out.println("Saldo insuficiente");
    } else {
      this.balance -= amount;
      Operation operation = new Operation("saque", amount, this.balance);
      operations.add(operation);
    }
  }

  public float getBalance() {
    return this.balance;
  }

  public String toString() {
    return "conta:" + this.number + " saldo:" + this.balance;
  }
}

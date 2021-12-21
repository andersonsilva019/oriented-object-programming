public abstract class Account {
  protected int id;
  protected float balance;
  protected String clientId;
  protected String type; // CC or CP

  /**
   * 
   * @param id       - id of account
   * @param idClient - id of client
   */
  public Account(int id, String clientId) {
    this.id = id;
    this.clientId = clientId;
    this.balance = 0;
  }

  // abstract method
  public abstract void monthlyUpdate();

  /**
   * Method that do operation withDraw
   * 
   * @param value - value of transaction
   * @throws AccountException
   */
  public void withdraw(float value) {
    if (value > this.balance) {
      throw new AccountException("fail: saldo insuficiente");
    } else {
      this.balance -= value;
    }
  }

  /**
   * 
   * @param value - value of transaction
   * @throws AccountException
   */
  public void deposit(float value) {
    if (value < 0) {
      throw new AccountException("fail: valor invalido");
    } else {
      this.balance += value;
    }
  }

  /**
   * 
   * @param other - account destination
   * @param value - value of transaction
   * @throws AccountException
   */
  public void transfer(Account other, float value) {
    if (value > this.balance) {
      throw new AccountException("fail: valor invalido");
    } else if (value <= 0) {
      throw new AccountException("fail: valor invalido");
    } else {
      this.balance -= value;
      other.balance += value;
    }
  }

  public String toString() {
    return String.format("%d:%s:%.2f:%s", this.id, this.clientId, this.balance, this.type);
  }

  // GETS and SETS
  public int getId() {
    return this.id;
  }

  public float getBalance() {
    return this.balance;
  }

  public String getClientId() {
    return this.clientId;
  }

  public String getType() {
    return this.type;
  }
}
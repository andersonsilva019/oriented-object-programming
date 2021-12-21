public class SavingsAccount extends Account {

  public final static float INTEREST_RATE = 0.01f;

  public SavingsAccount(int id, String idClient) {
    super(id, idClient);
    this.type = "CP";
  }

  // aumenta saldo em 1%
  public void monthlyUpdate() {
    super.balance += (super.balance * INTEREST_RATE);
  }

  @Override
  public String toString() {
    return super.toString();
  }
}
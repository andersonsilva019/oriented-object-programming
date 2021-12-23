import java.util.ArrayList;
import java.util.List;

class Client {
  private String clientId;
  private List<Account> accounts;

  /**
   * 
   * @param clientId - id of client
   */
  public Client(String clientId) {
    this.clientId = clientId;
    this.accounts = new ArrayList<Account>();
  }

  /**
   * 
   * @param account - account
   */
  public void addAccount(Account account) {
    this.accounts.add(account);
  }

  @Override
  public java.lang.String toString() {
    String str = "- " + this.clientId + " [";
    for (Account account : this.accounts) {
      str += (account instanceof CheckingAccount) ? account.getId() + ", " : account.getId();
    }
    str += "]\n";
    return str;
  }

  // GETS and SETS
  public String getClientId() {
    return this.clientId;
  }

  public void setClientId(String clientId) {
    this.clientId = clientId;
  }

  public List<Account> getAccounts() {
    return this.accounts;
  }

  public void setAccounts(List<Account> accounts) {
    this.accounts = accounts;
  }
};
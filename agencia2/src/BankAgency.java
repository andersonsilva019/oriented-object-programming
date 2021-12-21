import java.util.Map;
import java.util.TreeMap;

public class BankAgency {
  private Map<String, Client> clients;
  private Map<Integer, Account> accounts;
  private int nextAccountId = 0;

  /**
   * Gets the account or throws an exception.
   * 
   * @param id - id of account
   * @return account
   * @throws AccountException
   */
  private Account getAccount(int id) {
    if (!this.accounts.containsKey(id)) {
      throw new AccountException("fail: conta nao encontrada");
    }
    return this.accounts.get(id);
  }

  /**
   * Construtor method.
   * Class TreeMap - This class guarantees that the map will be in
   * ascending key order, sorted according to the natural order for
   * the key's class (see Comparable), or by the comparator provided
   * at creation time, depending on which constructor is used.
   * 
   * Reference: https://docs.oracle.com/javase/8/docs/api/java/util/TreeMap.html
   */
  public BankAgency() {
    this.clients = new TreeMap<String, Client>();
    this.accounts = new TreeMap<Integer, Account>();
  }

  /**
   * @param clientId - id of client
   */
  public void addClient(String clientId) {
    if (!this.clients.containsKey(clientId)) {
      // create client
      Client client = new Client(clientId);

      // create checking account
      CheckingAccount checkingAccount = new CheckingAccount(this.nextAccountId, clientId);
      client.addAccount(checkingAccount);
      this.accounts.put(this.nextAccountId, checkingAccount);
      this.nextAccountId++;

      // create savings account
      SavingsAccount savingsAccount = new SavingsAccount(this.nextAccountId, clientId);
      client.addAccount(savingsAccount);
      this.accounts.put(this.nextAccountId, savingsAccount);
      this.nextAccountId++;

      // add client to clients map
      this.clients.put(clientId, client);
    }
  }

  /**
   * Get client and invoke actions.
   * Method that do operation withDraw
   * 
   * @param idConta - id of account
   * @param value   - value of transaction
   */
  public void withdraw(int idConta, float value) {
    Account account = this.getAccount(idConta);
    account.withdraw(value);
  }

  /**
   * 
   * @param idConta - id of account
   * @param value   - value of transaction
   */
  public void deposit(int idConta, float value) {
    Account account = this.getAccount(idConta);
    account.deposit(value);
  }

  /**
   * 
   * @param contaDe   - account origin
   * @param contaPara - account destination
   * @param value     - value of transaction
   */
  public void transfer(int contaDe, int contaPara, float value) {
    Account accountOrigin = this.getAccount(contaDe);
    Account accountDestination = this.getAccount(contaPara);
    accountOrigin.transfer(accountDestination, value);
  }

  public void monthlyUpdate() {
    for (Account account : this.accounts.values()) {
      account.monthlyUpdate();
    }
  }

  public String toString() {
    String str = "Clients:\n";
    for (Client client : this.clients.values()) {
      str += client.toString();
    }
    str += "Accounts:\n";
    for (Account account : this.accounts.values()) {
      str += account.toString() + "\n";
    }
    return str.trim();
  }
}
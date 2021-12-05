import java.util.ArrayList;

public class Sala {
  // Atributo
  private ArrayList<Client> cadeiras;

  /**
   * Método construtor
   * 
   * @param capacidade - capacidade da sala
   */
  public Sala(int capacidade) {
    this.cadeiras = new ArrayList<Client>(capacidade);

    for (int i = 0; i < capacidade; i++) {
      this.cadeiras.add(null);
    }
  }

  public ArrayList<Client> getCadeiras() {
    return this.cadeiras;
  }

  /**
   * Método que adiciona um cliente à sala
   * 
   * @param id   - id do cliente
   * @param fone - fone do cliente
   * @param num  - número da cadeira
   * @return true se o cliente foi adicionado à sala, false caso contrário
   */
  public boolean reservar(String id, String fone, int num) {
    if (num > this.cadeiras.size() || num < 0) {
      System.out.println("fail: cadeira indisponível");
      return false;
    }
    for (Client client : this.cadeiras) {
      if (client != null) {
        Boolean clientAlreadyExists = client.getId().equals(id);
        if (clientAlreadyExists) {
          System.out.println("failure: cliente ja esta no cinema");
          return false;
        }
      }
    }

    if (this.cadeiras.get(num) != null) {
      System.out.println("failure: cadeira ja esta ocupada");
      return false;
    }

    Client client = new Client(id, fone);
    this.cadeiras.set(num, client);
    return true;
  }

  /**
   * Método que remove um cliente da sala
   * 
   * @param id - id do cliente
   */
  public void cancelar(String id) {
    for (int i = 0; i < this.cadeiras.size(); i++) {
      if (this.cadeiras.get(i) != null) {
        if (this.cadeiras.get(i).getId().equals(id)) {
          this.cadeiras.set(i, null);
          break;
        } else {
          System.out.println("failure: cliente nao esta no cinema");
        }
      }
    }
  }

  public String toString() {
    String state = "";
    state += "[ ";

    for (int i = 0; i < this.cadeiras.size(); i++) {
      if (this.cadeiras.get(i) == null) {
        state += "- ";
      } else {
        state += this.cadeiras.get(i).toString() + " ";
      }
    }
    state += "]";

    return state;
  }
}

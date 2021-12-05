public class Client {
  // Atributos
  private String id;
  private String fone;

  /**
   * Método construtor
   * 
   * @param id   id do cliente
   * @param fone fone do cliente
   */
  public Client(String id, String fone) {
    this.id = id;
    this.fone = fone;
  }

  public String toString() {
    return this.id + ":" + this.fone;
  }

  /**
   * Método getter que retorna o id do cliente
   * 
   * @return id do cliente
   */
  public String getId() {
    return this.id;
  }

  /**
   * Método setter que define o id do cliente
   * 
   * @param id id do cliente
   */
  public void setId(String id) {
    this.id = id;
  }

  /**
   * Método getter que retorna o fone do cliente
   * 
   * @return fone do cliente
   */
  public String getFone() {
    return this.fone;
  }

  /**
   * Método setter que define o fone do cliente
   * 
   * @param fone fone do cliente
   */
  public void setFone(String fone) {
    this.fone = fone;
  }
}

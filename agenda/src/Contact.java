import java.util.ArrayList;

public class Contact {
  // Attributes
  private String name;
  private ArrayList<Fone> fones;
  protected String prefix = "-"; // utilizado no toString
  // Crie um ArrayList para o ATRIBUTO fones
  // Se a variável fones não for null, adicione todos os fones usando o método
  // addFone

  /**
   * Método construtor
   * 
   * @param name  Nome do contato
   * @param fones ArrayList de fones
   */
  public Contact(String name, ArrayList<Fone> fones) {
    this.name = name == null ? "" : name;
    this.fones = new ArrayList<Fone>();

    if (fones != null) {
      for (Fone fone : fones) {
        this.addFone(fone);
      }
    }

  }

  // Se fone for válido, insira no atributo fones
  // Se não, informe o erro
  /**
   * Método que adiciona um fone a lista contatos
   * 
   * @param fone - Fone a ser adicionado
   */
  public void addFone(Fone fone) {
    if (Fone.validate(fone.getNumber())) {
      this.fones.add(fone);
    } else {
      System.out.println("fail: invalid number");
    }
  }

  // Se o índice existir no ArrayList, remova o telefone com esse índice
  /**
   * Método que remove um fone da lista contatos
   * 
   * @param index - índice do telefone a ser removido
   */
  public void rmFone(int index) {
    if (index < this.fones.size() && index >= 0) {
      this.fones.remove(index);
    } else {
      System.out.println("fail: invalid index");
    }
  }

  // Use um contador para mostrar o índice do telefone
  // Use o toString do fone para adicioná-lo à saída
  // O resultado dever ficar assim:
  // - david [0:oi:123] [1:tim:9081] [2:claro:5431]
  public String toString() {
    String state = this.prefix + " " + this.name + " ";

    for (int i = 0; i < this.fones.size(); i++) {
      state += "[";
      state += i + ":" + this.fones.get(i).toString();
      state += "]";
    }
    return state;
  }

  // GETS e SETS
  /**
   * Método getter que retorna o nome do contato
   * 
   * @return - Nome do contato
   */
  public String getName() {
    return this.name;
  }

  /**
   * Método setter que define o nome do contato
   * 
   * @param name - Nome do contato
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Méto que retorna o ArrayList de fones
   * 
   * @return - ArrayList de fones
   */
  public ArrayList<Fone> getFones() {
    return this.fones;
  }
}

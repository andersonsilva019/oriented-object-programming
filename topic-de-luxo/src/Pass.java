public class Pass {
  // Atributos
  private String name;
  private int age;

  /**
   * Método construtor
   * 
   * @param name Nome do passageiro
   * @param age  Idade do passageiro
   */
  public Pass(String name, int age) {
    this.name = name;
    this.age = age;
  }

  // return true if pass.age >= 65
  /**
   * Método que verifica se o passageiro é prioritário
   * 
   * @return true se o passageiro é prioritário
   */
  public boolean isPriority() {
    return this.age >= 65 ? true : false;
  }

  // GETS e SETS
  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return this.age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String toString() {
    return this.name + ":" + this.age;
  }
}

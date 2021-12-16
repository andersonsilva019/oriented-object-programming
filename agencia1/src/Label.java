public enum Label {
  saque("saque"),
  deposito("deposito"),
  tarifa("tarifa"),
  extorno("extorno"),
  abertura("abertura");

  private String name;

  // nas enums o Construtor tem que ser privado
  private Label(String name) {
    this.name = name;
  }

  String getName() {
    return this.name;
  }

  @Override
  public String toString() {
    return this.name;
  }
}

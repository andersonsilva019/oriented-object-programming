package entities;

public class Fone {
  private String id;
  private String number;

  public Fone(String id, String number) {
    this.id = id;
    this.number = number;
  }

  // verifica se o número é um número de telefone válido
  /**
   * ^ - inicio da string
   * \(? - Obtendo um parêntese opcional
   * [0-9]{2} - Obtendo um conjunto de dois digitos de 0 a 9
   * \)? - Obtendo um parêntese opcional
   * (\s*)? - Obtendo um espaço ou traço opcional
   * ([0-9]*) - Obtendo um conjunto de qualquer tamanho de digitos de 0 a 9
   * [.]? - Obtendo um ponto opcional
   * ([0-9]*) - Obtendo um conjunto de qualquer tamanho de digitos de 0 a 9
   * $ - fim da string
   * 
   * @param number - número de telefone a ser verificado
   * @return true se o número é válido, false caso contrário
   */
  public static boolean validate(String number) {
    return number.matches("^\\(?[1-9]{2}\\)?(\\s*)?([0-9]*)[.]?([0-9]*)$");
  }

  // O resultado deve ficar assim
  // oi:1234
  @Override
  public String toString() {
    return this.id + ":" + this.number;
  }

  // GETS e SETS
  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getNumber() {
    return this.number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  // utiliza o static validate para retornar se essa instancia do fone é valida
  public boolean isValid() {
    return Fone.validate(this.number);
  }
}
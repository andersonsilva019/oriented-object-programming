public class Linha {

  /**
   * Atributos
   */
  private Ponto2D pontoA;
  private Ponto2D pontoB;

  /**
   * Construtor
   */
  public Linha(Ponto2D pontoA, Ponto2D pontoB) {
    this.pontoA = pontoA;
    this.pontoB = pontoB;
  }

  /**
   * Métodos
   */

  // Função para calcular a distancia entre dois pontos
  public double distance() {
    float x1 = this.pontoA.getX();
    float x2 = this.pontoB.getX();
    float y1 = this.pontoA.getY();
    float y2 = this.pontoB.getY();

    double d = Math.pow((double) (x2 - x1), 2) + Math.pow((double) (y2 - y1), 2);

    return Math.sqrt(d);
  }
}

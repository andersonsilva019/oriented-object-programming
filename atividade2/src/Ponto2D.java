public class Ponto2D {

  /**
   * Atributos
   */
  private float x;
  private float y;

  /**
   * Métodos
   */
  public void initialize(float x, float y) {
    this.x = x;
    this.y = y;
  }

  public String print() {
    return "Coordenada x: " + this.x + "\n" + "Coordenada y: " + this.y;
  }

  public float getY() {
    return this.y;
  }

  public float getX() {
    return this.x;
  }
}

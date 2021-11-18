public class Grafite {
  private float calibre;
  private String dureza;
  private int tamanho;

  Grafite(float calibre, String dureza, int tamanho) {
    this.calibre = calibre;
    this.dureza = dureza;
    this.tamanho = tamanho;
  }

  public void setTamanho(int tamanho) {
    this.tamanho = tamanho;
  }

  public int getTamanho() {
    return this.tamanho;
  }

  public String getDureza() {
    return this.dureza;
  }

  public float getCalibre() {
    return this.calibre;
  }

  public String toString() {
    return "[" + this.calibre + ":" + this.dureza + ":" + this.tamanho + "]";
  }

  public int desgastePorFolha() {

    int desgaste = 0;

    switch (this.dureza) {
    case "HB":
      desgaste = 1;
      break;
    case "2B":
      desgaste = 2;
      break;
    case "4B":
      desgaste = 4;
      break;
    case "6B":
      desgaste = 6;
      break;
    default:
      desgaste = 0;
      break;
    }

    return desgaste;
  }
}
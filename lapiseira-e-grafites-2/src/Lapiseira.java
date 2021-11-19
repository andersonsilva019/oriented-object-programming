import java.util.ArrayList;

public class Lapiseira {

  /**
   * Declaração dos atributos
   */
  private float calibre;
  private Grafite bico;
  private ArrayList<Grafite> tambor;

  // Declarando uma constante para o tamanho mínimo do grafite
  private static final int TAMANHO_MIN_GRAFITE = 10;

  /**
   * Método construtor
   * 
   * @param calibre
   */
  public Lapiseira(float calibre) {
    this.calibre = calibre;
    this.bico = null;
    this.tambor = new ArrayList<Grafite>();
  }

  /**
   * Método que realiza uma inserção
   * 
   * @param grafite
   * @return
   */
  public boolean inserir(Grafite grafite) {
    if (this.calibre != grafite.getCalibre()) {
      System.out.println("fail: calibre incompatível");
      return false;
    } else {
      this.tambor.add(grafite);
      return true;
    }
  }

  /**
   * Método que remove um grafite do tambor para o bico da lapiseira
   * 
   * @return True se a operação foi concluída e false caso contrário.
   */
  public boolean puxar() {
    if (this.tambor.size() == 0) {
      System.out.println("fail: nao existe grafite no tambor");
      return false;
    } else if (this.bico != null) {
      System.out.println("fail: ja existe grafite no bico");
      return false;
    } else {
      this.bico = this.tambor.remove(0);
      return true;
    }
  }

  public String toString() {
    if (this.tambor.size() >= 1 && this.bico == null) {
      String str = null;
      str = "calibre: " + this.calibre + ", bico: []" + ", tambor: {";
      for (int i = 0; i < this.tambor.size(); i++) {
        str += this.tambor.get(i).toString();
      }
      str += "}";
      return str;
    } else if (this.tambor.size() >= 1 && this.bico != null) {
      String str = null;
      str = "calibre: " + this.calibre + ", bico: " + this.bico + ", tambor: {";
      for (int i = 0; i < this.tambor.size(); i++) {
        str += this.tambor.get(i).toString();
      }
      str += "}";
      return str;
    } else if (this.tambor.size() == 0 & this.bico != null) {
      return "calibre: " + this.calibre + ", bico: " + this.bico + ", tambor: {}";
    } else {
      return "calibre: " + this.calibre + ", bico: []" + ", tambor: {}";
    }
  }

  /**
   * Método que remove um grafite do bico
   * 
   * @return Grafite ou null
   */
  public Grafite remover() {
    if (this.bico == null) {
      System.out.println("fail: nao existe grafite");
      return null;
    } else {
      Grafite grafiteRef = this.bico;
      Grafite grafiteTemp = new Grafite(grafiteRef.getCalibre(), grafiteRef.getDureza(), grafiteRef.getTamanho());
      this.bico = null;
      return grafiteTemp;
    }
  }

  public void escrever() {
    int desgaste = 0;
    if (this.bico != null) {
      desgaste = this.bico.desgastePorFolha();
    }

    if (this.bico == null) {
      System.out.println("fail: nao existe grafite no bico");
    } else if (this.bico.getTamanho() <= TAMANHO_MIN_GRAFITE) {
      System.out.println("warning: grafite acabou");
    } else if (this.bico.getTamanho() - desgaste == TAMANHO_MIN_GRAFITE) {
      this.bico.setTamanho(this.bico.getTamanho() - desgaste);
      System.out.println("warning: grafite acabou");
    } else if (this.bico.getTamanho() - desgaste < TAMANHO_MIN_GRAFITE) {
      System.out.println("fail: folha incompleta");
      System.out.println("warning: grafite acabou");
      this.bico.setTamanho(TAMANHO_MIN_GRAFITE);
    } else {
      this.bico.setTamanho(this.bico.getTamanho() - desgaste);
    }
  }
}
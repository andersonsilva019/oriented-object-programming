class Lapiseira {

  /**
   * Declaração dos atributos
   */
  private float calibre;
  private Grafite grafite;

  // Criando uma constante com o tamanho mínimo do grafite
  private static final int TAMANHO_MIN_GRAFITE = 10;

  /**
   * Método construtor
   * 
   * @param calibre calibre inicial da lapiseira
   */
  public Lapiseira(float calibre) {
    this.calibre = calibre;
    this.grafite = null;
  }

  /**
   * @return retorna uma string formatada [calibre: *, grafite: *]
   */
  public String toString() {
    return "calibre: " + this.calibre + ", grafite: " + this.grafite;
  }

  /**
   * Método que realiza uma inserção do grafite na lapiseira
   * 
   * @param grafite
   * @return retorna true caso a inserção tenha sido feita. Caso contrário,
   *         retorna false
   */
  public boolean inserir(Grafite grafite) {
    if (this.calibre != grafite.getCalibre()) {
      System.out.println("fail: calibre incompatível");
      return false;
    } else if (this.grafite != null) {
      System.out.println("fail: ja existe grafite");
      return false;
    } else {
      this.grafite = grafite;
      return true;
    }
  }

  /**
   * Método que remove um grafite da lapiseira
   * 
   * @return retorna o grafite removido
   */
  public Grafite remover() {
    if (this.grafite == null) {
      System.out.println("fail: nao existe grafite");
      return null;
    } else {
      Grafite grafiteRef = this.grafite;
      Grafite grafiteTemp = new Grafite(grafiteRef.getCalibre(), grafiteRef.getDureza(), grafiteRef.getTamanho());
      this.grafite = null;
      return grafiteTemp;
    }
  }

  public void escrever() {
    int desgaste = this.grafite.desgastePorFolha();

    if (this.grafite.getTamanho() <= TAMANHO_MIN_GRAFITE) {
      System.out.println("warning: grafite acabou");
    } else if (this.grafite.getTamanho() - desgaste == TAMANHO_MIN_GRAFITE) {
      this.grafite.setTamanho(this.grafite.getTamanho() - desgaste);
      System.out.println("warning: grafite acabou");
    } else if (this.grafite.getTamanho() - desgaste < TAMANHO_MIN_GRAFITE) {
      System.out.println("fail: folha incompleta");
      System.out.println("warning: grafite acabou");
      this.grafite.setTamanho(TAMANHO_MIN_GRAFITE);
    } else {
      this.grafite.setTamanho(this.grafite.getTamanho() - desgaste);
    }
  }
}
public class LivroDeLivraria {
  private Livro livro;
  private float preco;
  private String estadoDeConservacao; // De 0 a 5

  public LivroDeLivraria(Livro livro, float preco, int estadoDeConservacao) {
    this.livro = livro;
    this.preco = preco;

    switch (estadoDeConservacao) {
      case 0:
        this.estadoDeConservacao = "Péssimo";
        break;
      case 1:
        this.estadoDeConservacao = "Ruim";
        break;
      case 2:
        this.estadoDeConservacao = "Bom";
        break;
      case 3:
        this.estadoDeConservacao = "Ótimo";
        break;
      case 4:
        this.estadoDeConservacao = "Excelente";
        break;
      default:
        this.estadoDeConservacao = "Entrada inválida. Avalie de 0 a 5";
        break;
    }
  }

}

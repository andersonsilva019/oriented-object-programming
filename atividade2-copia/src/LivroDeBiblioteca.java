public class LivroDeBiblioteca {
  private Livro livro;
  private String codigo; // Usado para identificar o livro
  private String nomeLeitor; // Nome da pessoa que pegou emprestado o livro
  private String dataDeDevolucao;

  public LivroDeBiblioteca(Livro livro, String codigo, String nomeLeitor, String dataDeDevolucao) {
    this.livro = livro;
    this.codigo = codigo;
    this.nomeLeitor = nomeLeitor;
    this.dataDeDevolucao = dataDeDevolucao;
  }
}

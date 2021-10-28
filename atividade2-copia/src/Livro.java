public class Livro {
  private String autor;
  private String nome;
  private String editora;
  private String edicao;

  public String getEdicao() {
    return edicao;
  }

  public String getAutor() {
    return autor;
  }

  public void setAutor(String autor) {
    this.autor = autor;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getEditora() {
    return editora;
  }

  public void setEditora(String editora) {
    this.editora = editora;
  }

  public void setEdicao(String edicao) {
    this.edicao = edicao;
  }
}

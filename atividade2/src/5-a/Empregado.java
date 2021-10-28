public class Empregado {
  private String nome;
  private String departamento;
  private int horasTrabalhadasNoMes;
  private double salarioPorHora;

  public Empregado(String nome, String departamento, int horasTrabalhadasNoMes, double salarioPorHora) {
    this.nome = nome;
    this.departamento = departamento;
    this.horasTrabalhadasNoMes = horasTrabalhadasNoMes;
    this.salarioPorHora = salarioPorHora;
  }

  public void mostraDados() {
    System.out.println("Nome: " + this.nome);
    System.out.println("Departamento: " + this.departamento);
    System.out.println("Salário mensal: " + this.calculaSalarioMensal(horasTrabalhadasNoMes, salarioPorHora));
  }

  public double calculaSalarioMensal(int horasTrabalhadasNoMes, double salarioPorHora) {
    return horasTrabalhadasNoMes * salarioPorHora;
  }
}

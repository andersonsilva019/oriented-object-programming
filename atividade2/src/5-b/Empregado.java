public class Empregado {
  private String nome;
  private String departamento;
  private int horasNormal;
  private int horasExtra;
  private double salarioPorHora;

  public Empregado(
    String nome,
    String departamento,
    int horasNormal,
    int horasExtra,
    double salarioPorHora
  ) {
    this.nome = nome;
    this.departamento = departamento;
    this.horasNormal = horasNormal;
    this.horasExtra = horasExtra;
    this.salarioPorHora = salarioPorHora;
  }

  public void mostraDados() {

    double salarioFinal = this.calculaSalarioMensal(this.horasNormal, salarioPorHora) + this.calculaSalarioMensal(this.horasExtra, salarioPorHora);

    System.out.println("Nome: " + this.nome);
    System.out.println("Departamento: " + this.departamento);
    System.out.println("Salário mensal normal: " + this.calculaSalarioMensal(this.horasNormal, salarioPorHora));
    System.out.println("Salário mensal extra: " + this.calculaSalarioMensal(this.horasExtra, salarioPorHora));
    System.out.println("Salário final(normal + extra): " + salarioFinal);
  }

  public double calculaSalarioMensal(int horasTrabalhadas, double salarioPorHora) {
    return horasTrabalhadas * salarioPorHora;
  }
}

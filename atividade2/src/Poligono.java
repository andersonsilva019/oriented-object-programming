public class Poligono {
  private int qtdLado;

  Poligono(int qtdLado) {
    this.qtdLado = qtdLado;
  }

  public String nomeDoPoligono() {

    String nome = null;

    switch (qtdLado) {
      case 3:
        nome = "Triângulo ou trilátero";
        break;
      case 4:
        nome = "Quadrângulo ou quadrilátero";
        break;
      case 5:
        nome = "Pentágono";
        break;
      case 6:
        nome = "Hexágono";
        break;
      case 7:
        nome = "Heptágono";
        break;
      case 8:
        nome = "Octógono";
        break;
      case 9:
        nome = "Eneágono";
        break;
      case 10:
        nome = "Decágono";
        break;
      default:
        nome = "Entrada inválida";
        break;
    }

    return nome;
  }
}

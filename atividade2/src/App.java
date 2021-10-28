public class App {
    public static void main(String[] args) throws Exception {

        // DataHora dataHora = new DataHora();

        // dataHora.initialize(31, 12, 2020, 23, 59);

        // Ponto2D pontoA = new Ponto2D();
        // Ponto2D pontoB = new Ponto2D();

        // pontoA.initialize(1, -2);
        // pontoB.initialize(9, 4);

        // Linha reta = new Linha(pontoA, pontoB);

        // System.out.printf("%.2f", reta.distance());

        // dataHora.printDate();

        Empregado emp = new Empregado("Anderson", "RH", 160, 20 ,31.25);
        Empregado emp2 = new Empregado("Silva", "Diretoria", 160, 20 ,31.25);

        emp.mostraDados();
        System.out.println("---------------------------------------");
        emp2.mostraDados();
    }
}

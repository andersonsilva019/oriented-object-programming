public class DataHora {

  // Instanciando um objeto do tipo Data
  Data data = new Data();

  // Instanciando um objeto do tipo HoraAproximada
  HoraAproximada horaAproximada = new HoraAproximada();

  public void initialize(int day, int month, int year, int hour, int minute) {
    data.initialize(day, month, year);
    horaAproximada.initialize(hour, minute);
  }

  public void printDate() {
    System.out.println(data.getDate() + " " + horaAproximada.getTime());
  }
}

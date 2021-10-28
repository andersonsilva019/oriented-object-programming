public class HoraPrecisa {

  /**
   * --------------------------------------------------------------------------
   * Atributos
   * --------------------------------------------------------------------------
   */
  private int hour; // Poderia ser copiado do modelo HoraAproximada
  private int minute; // Poderia ser copiado do modelo HoraAproximada
  private int seconds;
  private int hundredths;

  /**
   * ---------------------------------------------------------------------------
   * Métodos
   * ---------------------------------------------------------------------------
   */

  /*
   * Poderia ser copiado do modelo HoraAproximada adicionando apenas os campos de
   * segundo e centesimos de segundos.
   */
  public String getTime() {
    if (this.hour >= 0 && this.hour <= 12) {
      return this.hour + ":" + this.minute + ":" + this.seconds + "." + this.hundredths + " AM";
    } else {
      return this.hour + ":" + this.minute + ":" + this.seconds + "." + this.hundredths + " PM";
    }
  }

  /*
   * Poderia ser copiado do modelo HoraAproximada adicionando apenas os campos de
   * segundo e centesimos de segundos.
   *
   */
  public void initialize(int hour, int minute, int sedonds, int hundredths) {
    if (isValid(hour, minute, sedonds, hundredths)) {
      this.hour = hour;
      this.minute = minute;
      this.seconds = sedonds;
      this.hundredths = hundredths;
    } else {
      this.hour = 0;
      this.minute = 0;
      this.seconds = 0;
      this.hundredths = 0;
    }
  }

  /*
   * Poderia ser copiados do modelo HoraAproximada adicionando apenas as
   * validações para os segundos e centesimos de segundos.
   */
  private boolean isValid(int hour, int minute, int sedonds, int hundredths) {
    if (hour > 23 || hour < 0) {
      return false;
    } else if (minute > 59 || minute < 0) {
      return false;
    } else if (seconds > 59 || seconds < 0) {
      return false;
    } else if (hundredths < 0) {
      return false;
    } else {
      return true;
    }
  }

}

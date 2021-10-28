public class HoraAproximada {

  /**
   * --------------------------------------------------------------------------
   * Atributos
   * --------------------------------------------------------------------------
   */
  public int hour;
  public int minute;

  /**
   * ---------------------------------------------------------------------------
   * Métodos
   * ---------------------------------------------------------------------------
   */

  public void initialize(int hour, int minute) {
    if (isValid(hour, minute)) {
      this.hour = hour;
      this.minute = minute;
    } else {
      this.hour = 0;
      this.minute = 0;
    }
  }

  // Realizando uma formatação no horário
  public String getTime() {
    if (this.hour >= 0 && this.hour <= 12) {
      return this.hour + ":" + this.minute + " AM";
    } else {
      return this.hour + ":" + this.minute + " PM";
    }
  }

  // Função de validação
  private boolean isValid(int hour, int minute) {
    if (hour >= 24 || hour < 0) {
      return false;
    } else if (minute > 59 || minute < 0) {
      return false;
    } else {
      return true;
    }
  }
}

public class Data {
  private int day;
  private int month;
  private int year;

  public void initialize(int day, int month, int year) {
    if (isValid(day, month, year)) {
      this.day = day;
      this.month = month;
      this.year = year;
    } else {
      this.day = 0;
      this.month = 0;
      this.year = 0;
    }
  }

  public String mostraData() {
    if (isValid(this.day, this.month, this.year)) {
      return this.day + "/" + this.month + "/" + this.year;
    } else {
      return "Data inválida";
    }
  }

  /**
   * O método isValid() é o equivalente ao método dataEhVálida() que foi visto em
   * aula
   */

  private boolean isValid(int day, int month, int year) {
    if (day == 31
        && !(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)) {
      return false;
    } else if (day == 30 && !(month == 4 || month == 6 || month == 9 || month == 11)) {
      return false;
    } else if ((day == 29 && month == 2) && !((year % 4 == 0) && (year % 100 != 0 || year % 400 == 0))) {
      return false;
    } else if (day < 1 || day > 31 || month < 1 || month > 12) {
      return false;
    } else {
      return true;
    }
  }

}

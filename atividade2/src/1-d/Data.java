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

  private boolean isValid(int day, int month, int year) {
    if (day >= 1 && day <= 31 && month >= 1 && month <= 12) {
      return true;
    } else {
      return false;
    }
  }
}

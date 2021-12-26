package motorcycle;

public class Motorcycle {
  private Person person; // agregacao
  private int power;
  private int time;

  // Inicia o atributo power, time com zero e person com null
  public Motorcycle(int power) {
    this.person = null;
    this.time = 0;
    this.power = power;
  }

  // Comprar mais tempo
  public void buy(int time) {
    this.time += time;
  }

  // Se estiver vazio, coloca a pessoa na moto e retorna true
  public boolean in(Person person) {
    if (this.person == null) {
      this.person = person;
      return true;
    } else {
      System.out.println("fail: moto ocupada");
      return false;
    }
  }

  // Se houver uma person, retira e retorna
  // Se não, retorna null
  public Person out() {
    if (this.person != null) {
      Person personTemp = new Person(this.person.getName(), this.person.getAge());
      this.person = null;
      return personTemp;
    } else {
      System.out.println("fail: moto vazia");
      return null;
    }
  }

  public void drive(int time) {
    if (this.person.getAge() <= 10 && time < this.time && this.time != 0) {
      this.time -= time;
    } else if (this.person.getAge() <= 10 && time > this.time && this.time != 0) {
      System.out.println("fail: andou " + this.time + " min e acabou o tempo");
      this.time = 0;
    } else if (this.time == 0) {
      System.out.println("fail: tempo zerado");
    } else {
      System.out.println("fail: muito grande para andar de moto");
    }
  }

  public void honk() {
    if (this.person != null) {
      System.out.print("P");
      for (int i = 0; i < this.power; i++) {
        System.out.print("e");
      }
      System.out.println("m");
    } else {
      System.out.println("fail: moto vazia");
    }
  }

  public String toString() {
    return "potencia: " + this.power + ", minutos: " + this.time + ", pessoa: " + this.person;
  }
}

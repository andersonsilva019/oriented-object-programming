public class Kid {
  private int age;
  private String name;

  public Kid(String name, int age) {
    this.name = name;
    this.age = age;
  }

  public int getAge() {
    return this.age;
  }

  public String getName() {
    return this.name;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public void setName(String name) { // gs
    this.name = name;
  }

  public String toString() {
    return this.name + ":" + this.age + " ";
  }
}

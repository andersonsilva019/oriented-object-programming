package main;

public class Person {
  private String id;
  private String phone;

  public Person(String id, String phone) {
    this.id = id;
    this.phone = phone;
  }

  public String getId() {
    return this.id;
  }

  public String getPhone() {
    return this.phone;
  }
}

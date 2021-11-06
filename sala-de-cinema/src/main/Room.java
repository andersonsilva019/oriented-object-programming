package main;

import java.util.ArrayList;

public class Room {
  private ArrayList<Person> chairs;
  private int maxChairs;

  /**
   * 
   * @param maxChairs maximum number of chairs
   */
  public Room(int maxChairs) {
    this.maxChairs = maxChairs;
    this.chairs = new ArrayList<Person>(maxChairs);

    for (int i = 0; i < maxChairs; i++) {
      this.chairs.add(null);
    }
  }

  public void reserve(String id, String phone, int num) {
    for (int i = 0; i < maxChairs; i++) {
      if (this.chairs.get(i) != null) {
        Boolean personAlreadyExists = this.chairs.get(i).getId().equals(id);
        if (personAlreadyExists) {
          System.out.println("failure: cliente ja esta no cinema");
          return;
        }
      }
    }

    if (this.chairs.get(num) != null) {
      System.out.println("failure: cadeira ja esta ocupada");
      return;
    } else {
      Person person = new Person(id, phone);
      this.chairs.add(num, person);
      return;
    }
  }

  public void cancel(String id) {
    for (int i = 0; i < maxChairs; i++) {
      if (this.chairs.get(i) != null) {
        if (this.chairs.get(i).getId().equals(id)) {
          this.chairs.set(i, null);
        } else {
          System.out.println("failure: cliente nao esta no cinema");
        }
      }
    }
  }

  public String toString() {
    String state = "";
    state += "[ ";

    for (int i = 0; i < maxChairs; i++) {
      if (this.chairs.get(i) == null) {
        state += "- ";
      } else {
        state += this.chairs.get(i).getId() + ":" + this.chairs.get(i).getPhone() + " ";
      }
    }
    state += "]";

    return state;
  }
}

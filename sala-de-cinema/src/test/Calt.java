package test;

import main.Calce;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class Calt {

  Calce calce = new Calce();

  @Test
  public void sum() {
    assertEquals(2, calce.add(1, 1));
  }
}

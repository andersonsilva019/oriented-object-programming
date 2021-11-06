package test;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import main.Person;
import main.Room;

public class RoomTest {

  private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
  private final PrintStream originalOut = System.out;

  private final Person personOne = new Person("Anderson", "1234");
  private final Person personTwo = new Person("ino", "1234");
  private final Room room = new Room(4);

  @Before
  public void setUpStreams() {
    System.setOut(new PrintStream(outContent));
  }

  @After
  public void restoreStreams() {
    System.setOut(originalOut);
  }

  @Test
  @DisplayName("Deve reservar um cliente dado um numero da cadeira como entrada")
  public void reserveTest() {
    room.reserve(this.personOne.getId(), this.personOne.getPhone(), 2);
    assertEquals("[ - - Anderson:1234 - ]", room.toString());
  }

  @Test
  @DisplayName("Deve emitir um erro ao tentar reservar um cliente com mesmo id")
  public void notReserveWithEqualsId() {
    room.reserve(this.personOne.getId(), this.personOne.getPhone(), 2);
    room.reserve(this.personOne.getId(), this.personOne.getPhone(), 1);

    assertEquals("failure: cliente ja esta no cinema\n", outContent.toString());
  }

  @Test
  @DisplayName("Deve emitir um erro ao tentar reservar um cliente em um lugar ocupado")
  public void notReserveWithNumberOfChairsEquals() {
    room.reserve(this.personOne.getId(), this.personOne.getPhone(), 2);
    room.reserve(this.personTwo.getId(), this.personTwo.getPhone(), 2);

    assertEquals("failure: cadeira ja esta ocupada\n", outContent.toString());
  }

  @Test
  @DisplayName("Deve retirar um cliente da sala de cinema")
  public void cancelTest() {
    room.reserve(this.personOne.getId(), this.personOne.getPhone(), 2);
    room.cancel(this.personOne.getId());

    assertEquals("[ - - - - ]", room.toString());
  }
}

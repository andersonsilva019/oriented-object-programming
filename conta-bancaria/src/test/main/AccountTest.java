package test.main;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import main.Account;

public class AccountTest {

  private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
  private final PrintStream originalOut = System.out;

  @Before
  public void setUpStreams() {
    System.setOut(new PrintStream(outContent));
  }

  @After
  public void restoreStreams() {
    System.setOut(originalOut);
  }

  @Test
  @DisplayName("Deve retorna uma conta com valores iniciais")
  public void initAccount() {
    Account account = new Account(1234);
    assertEquals("conta:1234 saldo:0.0", account.toString());
  }

  @Test
  @DisplayName("Deve ser possivel depositar")
  public void addAmountWithTypeCredit() {
    Account account = new Account(1234);
    account.credit(100);
    assertEquals(account.getBalance(), 100);
  }

  @Test
  @DisplayName("Deve emitir um erro ao tenta depositar um valor <= 0")
  public void notAmountLessOrEqualZero() {
    Account account = new Account(1234);
    account.credit(-1);
    assertEquals("Deposite uma valor válido\n", outContent.toString());
  }

  @Test
  @DisplayName("Deve ser possivel realizar um saque")
  public void doDebitAccount() {
    Account account = new Account(1234);
    account.credit(100);
    account.debit(50);
    assertEquals(account.getBalance(), 50);
  }

  @Test
  @DisplayName("Deve emitir um erro ao realizar um saque maior que o saldo disponivel")
  public void notDoDebitAccount() {
    Account account = new Account(1234);
    account.credit(100);
    account.debit(150);
    assertEquals(account.getBalance(), 100);
    assertEquals("Saldo insuficiente\n", outContent.toString());
  }

  @Test
  @DisplayName("Deve ser possivel obter o extrato das operacoes realizadas")
  public void getExtractAccount() {
    Account account = new Account(1234);
    account.credit(100);
    account.credit(100);
    account.debit(50);
    account.getExtract();
    assertEquals("0: deposito: 100.0: 100.0\n1: deposito: 100.0: 200.0\n2: saque: -50.0: 150.0\n",
        outContent.toString());
  }

  @Test
  @DisplayName("Deve retornar o saldo descontando o valor da tarifa")
  public void setRateTest() {
    Account account = new Account(1234);
    account.credit(100);
    account.setRate(10);
    account.getExtract();
    assertEquals("0: deposito: 100.0: 100.0\n1: tarifa: -10.0: 90.0\n", outContent.toString());
  }

  // @Test
  // @DisplayName("Deve retornar o extrato das ultimas n operações")
  // public void nGetOperationsTest() {
  // Account account = new Account(1234);
  // account.credit(100);
  // account.setRate(10);
  // account.nGetOperations(1);
  // assertEquals("1: tarifa: -10.0: 90.0\n", outContent.toString());
  // }
}

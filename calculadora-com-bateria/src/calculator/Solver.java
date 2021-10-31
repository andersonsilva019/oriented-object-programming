package calculator;

import java.util.Locale;
import java.util.Scanner;

public class Solver{
  public static void main(String[] args) {
      Locale.setDefault(Locale.US);
      Scanner scanner = new Scanner(System.in);
      Calculator calc = new Calculator(0);
      while(true){
          String line = scanner.nextLine();
          System.out.println("$" + line);
          String ui[] = line.split(" ");
          if(line.equals("end")) {
              break;
          } else if(ui[0].equals("init")) { //batteryMax
              calc = new Calculator(Integer.parseInt(ui[1]));
          } else if(ui[0].equals("show")) {
              System.out.println(calc);
          } else if(ui[0].equals("charge")) {
              calc.chargeBattery(Integer.parseInt(ui[1]));
          } else if(ui[0].equals("sum")) {//value value
              calc.sum(Integer.parseInt(ui[1]), Integer.parseInt(ui[2]));
          } else if(ui[0].equals("div")) {//value value
              calc.division(Integer.parseInt(ui[1]), Integer.parseInt(ui[2]));
          } else if(ui[0].equals("mul")){
            calc.multiply(Integer.parseInt(ui[1]), Integer.parseInt(ui[2]));
          } else if(ui[0].equals("sub")){
            calc.subtract(Integer.parseInt(ui[1]), Integer.parseInt(ui[2]));
          } else {
            System.out.println("fail: comando invalido");
          }
      }
      scanner.close();
  }
}
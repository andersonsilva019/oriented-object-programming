package calculator;

import java.text.DecimalFormat;

public class Calculator {
  private int batteryMax;
  private int battery;
  private float display;
  //Inicia os atributos, battery e display começam com o zero.
  public Calculator(int batteryMax){
    this.batteryMax = batteryMax;
    this.battery = 0;
    this.display = 0;
  }
  //Aumenta a bateria, porém não além do máximo.
  public void chargeBattery(int value){
    int newBatteryValue = this.battery + value;
    if(newBatteryValue >= this.batteryMax){
      this.battery = this.batteryMax;
    }else{
      this.battery = newBatteryValue;
    }
  }
  //Tenta gastar uma unidade da bateria e emite um erro se não conseguir.
  public boolean useBattery(){
    if(this.battery > 0){
      this.battery--;
      return true;
    }else{
      return false;
    }
  }
  //Se conseguir gastar bateria, armazene a soma no atributo display.
  public void sum(int a, int b){
    if(useBattery()){
      this.display = a + b;
    }else{
      System.out.println("fail: bateria insuficiente");
    }
  } 
  //Se conseguir gastar bateria e não for divisão por 0.
  public void division(int num, int den){
    if(useBattery() && den != 0){
      this.display = (float)num / (float)den;
    }else if(den == 0){
      System.out.println("fail: divisao por zero");
    }else {
      System.out.println("fail: bateria insuficiente");
    }
  }

  public void subtract(int a, int b){
    if(useBattery()){
      this.display = a - b;
    }else{
      System.out.println("fail: bateria insuficiente");
    }
  }

  public void multiply(int a, int b){
    if(useBattery()){
      this.display = a * b;
    }else{
      System.out.println("fail: bateria insuficiente");
    }
  }

  //Retorna o conteúdo do display com duas casas decimais.
  public String toString(){
    DecimalFormat form = new DecimalFormat("0.00");
    return "display = "+form.format(this.display)+", battery = "+this.battery;
  } 
}

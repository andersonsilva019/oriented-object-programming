package car;

public class Car {
  private int pass; // Passageiros
  private int passMax; // limite de Passageiros
  private int gas; // tanque
  private int gasMax; // limite do tanque
  private int km; // quantidade de quilometragem

  public Car(){
    this.pass = 0;
    this.gas = 0;
    this.km = 0;
    this.passMax = 2;
    this.gasMax = 100;
  }

  public void in(){
    if(this.pass < this.passMax){
      this.pass++;
    }else{
      System.out.println("fail: limite de pessoas atingido");
    }
  }

  public void out(){
    if(this.pass != 0){
      this.pass--;
    }else{
      System.out.println("fail: nao ha ninguem no carro");
    }
  }
  
  public void fuel(int gas){
    int somaGas = this.pass + gas;
    if(somaGas <= this.gasMax){
      this.gas = somaGas;
    }else{
      this.gas = 100;
    }
  }

  public void drive (int km){
    if(this.pass > 0 && km < this.gas){
      this.gas -= km;
      this.km += km;
    }else if(this.pass > 0 && km > this.gas && this.gas != 0){
      System.out.println("fail: tanque vazio apos andar "+this.gas+" km");
      this.km += this.gas;
      this.gas = 0;
    }else if(this.gas == 0){
      System.out.println("fail: tanque vazio");
    }else{
      System.out.println("fail: nao ha ninguem no carro");
    }
  }
  public String toString(){
    return "pass: "+this.pass+ ", gas: "+this.gas+ ", km: "+this.km;
  }
};
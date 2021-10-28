package q3.a;

import q2.a.Data;

public class Voo {
  private int voo;
  private Data data;
  private byte hora;
  private byte minuto;
  private byte[] passageiros = new byte[100];

  public int getVoo() {
    return this.voo;
  }

  public Data getData() {
    return this.data;
  }  

  public Voo(int voo, Data data, byte hora, byte minuto){
    this.voo = voo;
    this.data = data;
    this.hora = hora;
    this.minuto = minuto;
  }

  /**
   * 
   * @return Este método retorna a proxima cadeira livre (byte)
   */
  public byte proximoLivre(){

    byte livre = 0;

    for(int i = 0; i < passageiros.length; i++){
      if(passageiros[i] == 0){
        livre =  (byte)i;
        break;
      }
    }
    return livre;
  }

  /**
   * 
   * @param numeroDaCadeira
   * @return Este método verifica se o numero da cadeira está ocupada (boolean)
   */
  public boolean verifica(byte numeroDaCadeira){
    if(passageiros[numeroDaCadeira] != 0){ // Significa que está ocupada
      return true;
    }else {
      return false; 
    }
  }

  /**
   * 
   * @param numeroDaCadeira
   * @return Este método ocupa a cadeira passada como parâmetro (boolean)
   */
  public boolean ocupa(byte numeroDaCadeira){
    if(this.verifica(numeroDaCadeira)){
      return false;
    }else{
      passageiros[numeroDaCadeira] = 1;
      return true;
    }
  }

  /**
   * 
   * @return  Este método retorna a quantidade de cadeiras disponiveis (byte)
   */
  public byte vagas(){
    
    byte contador = 0;
    
    for(int i = 0; i < passageiros.length; i++){
      if(passageiros[i] == 0){
        contador++;
      }
    }

    return contador;
  }

  public Voo clone(){
    Voo voo = new Voo(this.voo, this.data, this.hora, this.minuto);
    for(int i = 0; i < passageiros.length; i++){
      if(passageiros[i] != 0){
        voo.ocupa((byte)i);
      }
    }
    return voo;
  }

  public String toString(){
    return "========\n" 
    + "Voo: "
    + this.voo 
    + "\nData: "
    + this.data
    + "\nHora: "
    + this.hora
    + "\nMinuto: "
    + this.minuto
    + "\nVagas diponíveis: "
    + this.vagas()+"\n"
    +"========";
  }

}

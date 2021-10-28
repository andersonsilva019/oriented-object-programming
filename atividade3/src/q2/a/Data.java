package q2.a;

public class Data {
  private byte dia, mes;
  private short ano;

  /**
   * Método construtor
   * @param dia
   * @param mes
   * @param ano
   */
  public Data(byte dia, byte mes, short ano){
    if(isValid(dia, mes, ano)){
      this.dia = dia;
      this.mes = mes;
      this.ano = ano;
    }else{
      this.dia = 01;
      this.mes = 01;
      this.ano = 0001;
    }
  }


  public byte getDia() {
    return this.dia;
  }

  public byte getMes() {
    return this.mes;
  }

  public short getAno() {
    return this.ano;
  }

  /**
   * 
   * @return Este método retorna o mes por extenso (String)
   */
  public String getMesExtenso(){

    String mesPorExtenso = null;

    switch(this.mes){
      case 1: {
        mesPorExtenso = "Janeiro";
        break;
      }
      case 2: {
        mesPorExtenso = "Fevereiro";
        break;
      }
      case 3: {
        mesPorExtenso = "Março";
        break;
      }
      case 4: {
        mesPorExtenso = "Abril";
        break;
      }
      case 5: {
        mesPorExtenso = "Maio";
        break;
      }
      case 6: {
        mesPorExtenso = "Junho";
        break;
      }
      case 7: {
        mesPorExtenso = "Julho";
        break;
      }
      case 8: {
        mesPorExtenso = "Agosto";
        break;
      }
      case 9: {
        mesPorExtenso = "Setembro";
        break;
      }
      case 10: {
        mesPorExtenso = "Outubro";
        break;
      }
      case 11: {
        mesPorExtenso = "Novembro";
        break;
      }
      case 12: {
        mesPorExtenso = "Desembro";
        break;
      }
    }

    return mesPorExtenso;
  }

  /**
   * Método que retorna uma instância da classe Data copiando os valores corrente
   */
  public Data clone(){
    Data d = new Data(this.dia, this.mes, this.ano);
    return d;
  }

  /**
   * Método que compara duas datas
   * @param data
   * @return São iguais retorna 0. dataCorrente > dataParametro retorna 1. dataParametro > dataCorrente retorna -1
   */
  public byte compara(Data data){

    int dataParametro = (data.getAno() * 10000)+(data.getMes() * 100) + data.getDia();
    int dataCorrente = (this.ano * 10000)+(this.mes * 100) + this.dia;


    if(dataParametro == dataCorrente){
      return 0;
    }else if(dataCorrente > dataParametro){
      return 1;
    }else{
      return -1; // dataParametro > dataCorrente
    }
  }

  /**
   * 
   * @return Este método retorna se um ano é bissexto (boolean)
   */
  public boolean isBissexto(){
    return ((this.ano % 4 == 0) && (this.ano % 100 != 0 || this.ano % 400 == 0));
  }

  public String toString(){
    return this.dia + "/" + this.mes + "/" + this.ano;
  }

  /**
   * Método de validação para datas
   * @param dia
   * @param mes
   * @param ano
   * @return Este método retorna true se a data é valida e false caso contrario
   */
  private boolean isValid(byte dia, byte mes, short ano) {
    if (dia == 31
        && !(mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12)) {
      return false;
    } else if (dia == 30 && !(mes == 4 || mes == 6 || mes == 9 || mes == 11)) {
      return false;
    } else if ((dia == 29 && mes == 2) && !((ano % 4 == 0) && (ano % 100 != 0 || ano % 400 == 0))) {
      return false;
    } else if (dia < 1 || dia > 31 || mes < 1 || mes > 12) {
      return false;
    } else {
      return true;
    }
  }
}
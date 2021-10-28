package q2.b;

import q2.a.Data;

public class DemoData {
    public static void main(String[] args) throws Exception {

        Data data1 = new Data((byte)4, (byte)7, (short)2012);
        Data data2 = new Data((byte)16, (byte)12, (short)2012);
        Data data3 = data1.clone();
        Data data4 = new Data((byte)22, (byte)10, (short)2021);

        if(data1.compara(data2) == 0){
            System.out.println("As datas são iguais " +data1 + " e " +data2);
        }else if(data1.compara(data2) == 1){
            System.out.println(
                "A data1 é maior que a data2 "
                + data1.getDia() + "/"
                + data1.getMes() + "/"
                + data1.getAno() + " > "
                + data2.getDia() + "/"
                + data2.getMes() + "/"
                + data2.getAno());
        }else {
            System.out.println(
                "A data2 é maior que a data1 "
                + data2.getDia() + "/"
                + data2.getMes() + "/"
                + data2.getAno() + " > "
                + data1.getDia() + "/"
                + data1.getMes() + "/"
                + data1.getAno());
        }

        if(data3.compara(data1) == 0){
            System.out.println(
                "As datas são iguais "
                + data3.getDia() + "/"
                + data3.getMes() + "/"
                + data3.getAno() + " = "
                + data1.getDia() + "/"
                + data1.getMes() + "/"
                + data1.getAno());
        }

        if(data1.isBissexto()){
            System.out.println("O ano " + data1.getAno() + " é bissexto");
        }else{
            System.out.println("O ano " + data1.getAno() + " não é bissexto");
        }

        if(data4.isBissexto()){
            System.out.println("O ano " + data4.getAno() + " é bissexto");
        }else{
            System.out.println("O ano " + data4.getAno() + " não é bissexto");
        }

        System.out.println("Data1: "+ data1.getDia() + " de " + data1.getMesExtenso() + " de " + data1.getAno());
        System.out.println("Data2: "+ data2.getDia() + " de " + data2.getMesExtenso() + " de " + data2.getAno());
        System.out.println("Data3: "+ data3.getDia() + " de " + data3.getMesExtenso() + " de " + data3.getAno());
        System.out.println("Data4: "+ data4.getDia() + " de " + data4.getMesExtenso() + " de " + data4.getAno());
    }
}

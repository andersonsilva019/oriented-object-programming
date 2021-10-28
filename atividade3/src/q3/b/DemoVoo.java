package q3.b;

import q2.a.Data;
import q3.a.Voo;

public class DemoVoo {
    public static void main(String[] args) {
        Data dataVoo1 = new Data((byte)22, (byte)10, (short)2021);
        Voo voo1 = new Voo(123, dataVoo1, (byte)16, (byte)30);

        // Reservando a cadeira de numero 10
        voo1.ocupa((byte)10);
        System.out.println(voo1);
        
        // Reservando a cadeira de numero 12
        voo1.ocupa((byte)12);
        System.out.println(voo1);

        // Imprimindo o numero de cadeiras livre
        System.out.println("Existem "+voo1.vagas() + " vagas disponiveis no voo de número "+voo1.getVoo());

        // Verificando se a cadeira de numero 13 está ocupada
        if(voo1.verifica((byte)13)){
            System.out.println("Cadeira ocupada!");
        }else{
            System.out.println("Cadeira livre!");
        }
        
        // Verificando se a cadeira de numero 12 está ocupada
        if(voo1.verifica((byte)12)){
            System.out.println("Cadeira ocupada!");
        }else{
            System.out.println("Cadeira livre!");
        }

        // Reservando a cadeira de numero 0
        voo1.ocupa((byte)0);

        // Verificando a proxima cadeira livre
        System.out.println("Proxima cadeira livre "+voo1.proximoLivre());

        // Retornando a data do voo
        System.out.println("Data do voo: "+voo1.getData());

        // Clonando o objeto voo1
        Voo voo2 = voo1.clone();
        System.out.println("Atenção tripulantes, repito, atenção tripulantes, o voo de número "+voo2.getVoo()+ " foi clonado!");
        System.out.println(voo2);

        /* Monstrando que o voo1 foi clonado e a variavel voo2 aponta para outro espaço de memória
         diferente da variavel voo1.*/
        voo2.ocupa((byte)2);
        System.out.println(voo2); // Retorna 96 vagas disponiveis
        System.out.println(voo1); // Retorna 97 vagas disponiveis
    }
}

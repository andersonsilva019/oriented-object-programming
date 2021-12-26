import java.util.Scanner;

public class DemoVetor {

    public static void main(String[] args) throws Exception {
       Vetor v = new Vetor(5);
       Scanner input = new Scanner(System.in);

    
       while(true){
           System.out.print("Digite um inteiro (ou \"exit\" para sair): ");
           String str = input.next();

           if(str.equals("exit")){
               break;
           }

           v.add(Integer.parseInt(str));    // boxing
       }

           System.out.println(v);

       input.close();
    }
}

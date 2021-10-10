import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Locale;
import java.util.Scanner;

public class Client {
    public static void main(String args[]) {
        /**
         * Para compilar: javac -d bin/ src/sockets/ChatClient.java Para executar: java
         * -cp "./bin/" sockets/ChatClient localhost
         */
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        // arguments supply message and hostname
        Socket s = null;

        try {
            System.out.println("Chat TCP ::: Estabelecendo conexão...\n");
            System.out.print("Digite o seu nome: ");
            String nome = sc.nextLine();
            System.out.println("Chat iniciado:");

            int serverPort = 7896;
            s = new Socket(args[0], serverPort);
            DataInputStream in = new DataInputStream(s.getInputStream());
            DataOutputStream out = new DataOutputStream(s.getOutputStream());

            String frase = "";
            // out.writeUTF(nome + ": " + frase); // UTF is a string encoding see Sn. 4.4,
            // escreve para o servidor
            while (!(frase.contains("bye") || frase.contains("Bye"))) {
                if (!frase.isEmpty()) {
                    out.writeUTF(nome + ": " + frase); // UTF is a string encoding see Sn. 4.4, escreve para o servidor
                }
                String data = in.readUTF(); // read a line of data from the stream, lê do servidor
                System.out.println(data);
                frase = sc.nextLine();
            }
            System.out.println("\nChat encerrado: " + nome + " saiu do chat.");
            sc.close();

        } catch (UnknownHostException e) {
            System.out.println("Socket:" + e.getMessage());
        } catch (EOFException e) {
            System.out.println("EOF:" + e.getMessage());
        } catch (IOException e) {
            System.out.println("readline:" + e.getMessage());
        } finally {
            if (s != null)
                try {
                    s.close();
                } catch (IOException e) {
                    System.out.println("close:" + e.getMessage());
                }
        }
    }
}
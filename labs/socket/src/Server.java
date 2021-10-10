import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Locale;
import java.util.Scanner;

public class Server {
  public static void main(String args[]) {
    /**
     * Para compilar: javac -d bin/ src/sockets/ChatServer.java Para executar: java
     * -cp "./bin/" sockets/ChatServer
     */
    try {
      Locale.setDefault(Locale.US);
      int serverPort = 7896; // the server port
      System.out.println("Servidor escutando:\nPorta: " + serverPort);
      ServerSocket listenSocket = new ServerSocket(serverPort);

      System.out.println("\nChat TCP ::: Estabelecendo conexão...\n");
      System.out.print("Digite o seu nome: ");

      while (true) {
        Socket clientSocket = listenSocket.accept();
        Connection c = new Connection(clientSocket);
      }
    } catch (IOException e) {
      System.out.println("Listen socket:" + e.getMessage());
    }
  }
}

class Connection extends Thread {
  DataInputStream in;
  DataOutputStream out;
  Socket clientSocket;

  public Connection(Socket aClientSocket) {
    try {
      clientSocket = aClientSocket;
      in = new DataInputStream(clientSocket.getInputStream());
      out = new DataOutputStream(clientSocket.getOutputStream());

      this.start();
    } catch (IOException e) {
      System.out.println("Connection:" + e.getMessage());
    }
  }

  public void run() {
    try { // an echo server
      Scanner sc = new Scanner(System.in);
      String nome = sc.nextLine();
      System.out.println("\nChat iniciado:");
      String data; // read a line of data from the stream, lê do cliente
      // String data = in.readUTF(); // read a line of data from the stream, lê do
      // cliente
      // String frase = sc.nextLine();
      String frase = "Heeeey";

      while (!(frase.contains("bye") || frase.contains("Bye"))) {
        if (!frase.isEmpty()) {
          out.writeUTF(nome + ": " + frase); // UTF is a string encoding see Sn. 4.4, escreve para o servidor
        }
        data = in.readUTF(); // read a line of data from the stream, lê do cliente
        System.out.println(data); // Imprime no terminal do servidor
        frase = sc.nextLine();
      }
      System.out.println("\nChat encerrado: " + nome + " saiu do chat.");
      sc.close();
    } catch (EOFException e) {
      System.out.println("EOF:" + e.getMessage());
    } catch (IOException e) {
      System.out.println("readline:" + e.getMessage());
    } finally {
      try {
        clientSocket.close();
      } catch (IOException e) {
        /* close failed */}
    }

  }
}
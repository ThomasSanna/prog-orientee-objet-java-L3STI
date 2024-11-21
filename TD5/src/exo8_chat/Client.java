package exo8_chat;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
  public static void main(String[] args) {
    String serverName = "localhost";
    int port = 2000;
    try {
      System.out.println("Connexion à " + serverName + ", port " + port);
      Socket client = new Socket(serverName, port);
      System.out.println("Connection réussie à l'adresse " + client.getRemoteSocketAddress());
      DataInputStream in = new DataInputStream(client.getInputStream());
      DataOutputStream out = new DataOutputStream(client.getOutputStream());
      System.out.println("Server says " + in.readUTF());

      // Thread to listen for messages from the server
      new Thread(() -> {
        try {
          while (true){
            String message = in.readUTF();
            System.out.println(message);
          }
        } catch (IOException e) {
          e.printStackTrace();
        }
      }).start();

      Scanner scanner = new Scanner(System.in);
      String message = "";
      while (!message.equals("stop")) {
        System.out.println("Entrez un message ('stop' pour partir) : ");
        message = scanner.nextLine();
        if (message.equals("stop")){
          message = "est parti.";
        }
        out.writeUTF(message);
        out.flush();
      }

      scanner.close();
      client.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
package exo8_chat;

import java.io.*;
import java.net.*;
import java.util.Scanner;

import exo8_chat.ActionClient.ReadMessage;

public class Client {
  public static void main(String[] args) {
    String serverName = "localhost";
    int port = 2000;
    try {
      System.out.println("Connexion à " + serverName + ", port " + port);
      Socket client = new Socket(serverName, port);
      System.out.println("Connection réussie à l'adresse " + client.getRemoteSocketAddress());

      Scanner scanner = new Scanner(System.in);

      String pseudo = "";
      while (pseudo.equals("")) {
        System.out.println("Entrez votre pseudo : ");
        pseudo = scanner.nextLine();
      }
      ObjectOutputStream oos = new ObjectOutputStream(client.getOutputStream());
      oos.writeUTF(pseudo);
      oos.flush();

      Thread readMessageThread = new Thread(new ReadMessage(client));
      readMessageThread.start();

      String message = "";
      while (!message.equals("stop")) {
        System.out.println("Entrez un message ('stop' pour partir) : ");
        message = scanner.nextLine();
        if (message.equals("stop")){
          message = "est parti.";
          ObjectOutputStream out = new ObjectOutputStream(client.getOutputStream());
          out.writeUTF(message);
          out.flush();
          break;
        }
        ObjectOutputStream out = new ObjectOutputStream(client.getOutputStream());
        out.writeUTF(message);
        out.flush();
      }

      scanner.close();
      client.close();
    } catch (IOException e) {
      System.out.println("JSP");
      e.printStackTrace();
    }
  }
}
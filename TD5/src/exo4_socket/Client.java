package exo4_socket;

import java.io.*;
import java.net.*;

public class Client {
  public static void main(String[] args) {
    String serverName = "localhost";
    int port = 2000;
    try {
      System.out.println("Connexion à " + serverName + ", port " + port);
      Socket client = new Socket(serverName, port);
      System.out.println("Connection réussie à l'adresse " + client.getRemoteSocketAddress());
      client.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
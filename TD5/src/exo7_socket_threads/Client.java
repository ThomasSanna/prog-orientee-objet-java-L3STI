package exo7_socket_threads;

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
      OutputStream outToServer = client.getOutputStream();
      DataInputStream in = new DataInputStream(client.getInputStream());
      System.out.println("Server says " + in.readUTF());
      client.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
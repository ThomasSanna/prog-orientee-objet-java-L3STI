package exo4_socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

  public static void main(String[] args) {
    int port = 2000;
    try {
      ServerSocket serverSocket = new ServerSocket(port);
      System.out.println("En attente de client " + serverSocket.getLocalPort() + "...");
      Socket server = serverSocket.accept();
      System.out.println("Un client s'est connecté :  " + server.getRemoteSocketAddress());

      server.close();
      serverSocket.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

package exo7_socket_threads;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
  private static int clientCount = 0;

  public static void main(String[] args) {
    int port = 2000;
    try {
      ServerSocket serverSocket = new ServerSocket(port);
      System.out.println("En attente de clients sur le port " + serverSocket.getLocalPort() + "...");

      while (true) {
        Socket server = serverSocket.accept();
        clientCount++;
        System.out.println("Un client s'est connecté : " + server.getRemoteSocketAddress());
        System.out.println("Nombre de clients connectés : " + clientCount);

        Thread clientThread = new Thread(new AcceptClient(server));
        clientThread.start();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
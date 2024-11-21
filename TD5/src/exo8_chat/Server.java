package exo8_chat;

import java.io.IOException;
import java.lang.reflect.Array;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
  private static int clientCount = 0;
  private static ArrayList<Socket> clients = new ArrayList<Socket>();

  public static ArrayList<Socket> getClients() {
    return clients;
  }

  public static void main(String[] args) {
    int port = 2000;
    try {
      ServerSocket serverSocket = new ServerSocket(port);
      System.out.println("En attente de clients sur le port " + serverSocket.getLocalPort() + "...");

      while (true) {
        Socket client = serverSocket.accept();
        clientCount++;
        clients.add(client);
        System.out.println("Un client s'est connecté : " + client.getRemoteSocketAddress());
        System.out.println("Nombre de clients connectés : " + clientCount);

        Thread clientThread = new Thread(new AcceptClient(client));
        clientThread.start();
        Thread receiveThread = new Thread(new ReceiveMessage(client));
        receiveThread.start();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
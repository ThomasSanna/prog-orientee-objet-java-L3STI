package exo8_chat;

import java.io.IOException;
import java.io.ObjectInput;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


import exo8_chat.ActionServer.AcceptClient;
import exo8_chat.ActionServer.ReceiveMessage;

import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;

public class Server {
  private static int clientCount = 0;
  private static ArrayList<Socket> clients = new ArrayList<Socket>();
  private static Map<Socket, ClientInfo> clientsMap = new HashMap<Socket, ClientInfo>();

  public static ArrayList<Socket> getClients() {
    return clients;
  }

  public static void enleverClient(Socket client) {
    clients.remove(client);
    clientsMap.remove(client);
  }

  public static ClientInfo getClientInfo(Socket client) {
    return clientsMap.get(client);
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

        ObjectInputStream ois = new ObjectInputStream(client.getInputStream());
        String pseudo = ois.readUTF();

        try{
          clientsMap.put(client, new ClientInfo(pseudo, new ObjectOutputStream(client.getOutputStream())));
        } catch (IOException e) {
          System.out.println("Problème OOS");
          e.printStackTrace();
        }

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
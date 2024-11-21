package exo5_socket_message;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

  public static void envoyerMessage(Socket socket, String message) {
    try {
      DataOutputStream out = new DataOutputStream(socket.getOutputStream());
      out.writeUTF(message);
      out.flush(); // Force l'envoi du message
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  public static void main(String[] args) {
    int port = 2000;
    try {
      ServerSocket serverSocket = new ServerSocket(port);
      System.out.println("En attente de client " + serverSocket.getLocalPort() + "...");
      Socket server = serverSocket.accept();
      System.out.println("Un client s'est connecté :  " + server.getRemoteSocketAddress());
      envoyerMessage(server, "Bonjour c'est le serveur qui parle.");

      server.close();
      serverSocket.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

package exo8_chat.ActionServer;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

import exo8_chat.ClientInfo;
import exo8_chat.Server;

public class BroadcastMessage implements Runnable{
  private String message;
  private Socket socketEnvoyeur;
  
  public BroadcastMessage(String message, Socket socketEnvoyeur) {
    this.message = message;
    this.socketEnvoyeur = socketEnvoyeur;
  }

  public void run() {
    ArrayList<Socket> clients = Server.getClients();
    for (Socket client : clients) {
      if (!client.isClosed()) {
        ClientInfo sockEnvInfo = Server.getClientInfo(socketEnvoyeur);
        ClientInfo cliInfo = Server.getClientInfo(client);
        ObjectOutputStream oos = cliInfo.getOos();
        try {
          oos.writeUTF(sockEnvInfo.getPseudo() + " : " + message);
          oos.flush();
        } catch (IOException e) {
          System.out.println("Problème BROADCAST");
          e.printStackTrace();
        }
      }
    }
  }
}

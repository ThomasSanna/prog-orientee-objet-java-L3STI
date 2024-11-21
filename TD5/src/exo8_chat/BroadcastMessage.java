package exo8_chat;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

public class BroadcastMessage {
  private String message;
  private Socket socketEnvoyeur;
  
  public BroadcastMessage(String message, Socket socketEnvoyeur) {
    this.message = message;
    this.socketEnvoyeur = socketEnvoyeur;
  }

  public void run() {
    System.out.println("ENVOIE EN COURS");
    ArrayList<Socket> clients = Server.getClients();
    for (Socket client : clients) {
      try (DataOutputStream out = new DataOutputStream(client.getOutputStream())) {
          out.writeUTF(socketEnvoyeur.getPort() + " a dit : " + message);
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
}

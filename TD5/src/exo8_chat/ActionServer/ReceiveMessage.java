package exo8_chat.ActionServer;

import java.io.*;
import java.net.*;

import exo8_chat.Server;

public class ReceiveMessage implements Runnable {
  private Socket socket;

  public ReceiveMessage(Socket socket){
    this.socket = socket;
  }

  public void run(){
    try {
      while(!socket.isClosed()){
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
        String message = in.readUTF();
        System.out.println(message + " " + socket.getInetAddress() + ":" + socket.getPort());
        if (message.equals("est parti.")){
          socket.close();
          Server.enleverClient(socket);
        }
        BroadcastMessage envoieMessage = new BroadcastMessage(message, socket);
        envoieMessage.run();
      }
    } catch (EOFException e){
      System.out.println("Fin de la connexion");
    } catch (IOException e) {
      System.out.println("Problème RECEIVE");
      e.printStackTrace();
    } 
  }
}
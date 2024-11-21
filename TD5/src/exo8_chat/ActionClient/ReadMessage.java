package exo8_chat.ActionClient;

import java.io.*;
import java.net.*;

public class ReadMessage implements Runnable {

  private Socket socket;

  public ReadMessage(Socket socket){
    this.socket = socket;
  }

  public void run(){
    try{
      ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
      while (true){
        try {
          String message = ois.readUTF();
          System.out.println(message);
        } catch (EOFException e){
          System.out.println("pb READ : Fin de la connexion");
          break;
        } catch (IOException e) {
          System.out.println("pb READ : Erreur lors de la lecture du message, réessayer...");
          e.printStackTrace();
        }
      }
    } catch (IOException e) {
      System.out.println("pb READ : Problème lors de l'initialisation du flux de lecture.");
      e.printStackTrace();
    }
  }
  
}
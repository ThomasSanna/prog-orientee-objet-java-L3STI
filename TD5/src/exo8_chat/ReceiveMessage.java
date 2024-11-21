package exo8_chat;

import java.io.*;
import java.net.*;

public class ReceiveMessage implements Runnable {
  private Socket socket;

  public ReceiveMessage(Socket socket){
    this.socket = socket;
  }

  public void run(){
    try {
      DataInputStream in = new DataInputStream(socket.getInputStream());
      while(true){
        String message = in.readUTF();
        System.out.println(message + " " + socket.getInetAddress() + ":" + socket.getPort());
        BroadcastMessage envoieMessage = new BroadcastMessage(message, socket);
        envoieMessage.run();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
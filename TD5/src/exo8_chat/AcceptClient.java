package exo8_chat;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class AcceptClient implements Runnable {
  private Socket socket;

  public AcceptClient(Socket socket) {
    this.socket = socket;
  }

  public void run() {
    try {
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        out.writeUTF("Bonjour c'est le serveur qui parle.");
        out.flush();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
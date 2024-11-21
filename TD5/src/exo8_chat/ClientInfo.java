package exo8_chat;

import java.io.ObjectOutputStream;

public class ClientInfo {
  private String pseudo;
  private ObjectOutputStream oos;

  public ClientInfo(String pseudo, ObjectOutputStream oos) {
    this.pseudo = pseudo;
    this.oos = oos;
  }

  public String getPseudo() {
    return pseudo;
  }

  public ObjectOutputStream getOos() {
    return oos;
  }
}

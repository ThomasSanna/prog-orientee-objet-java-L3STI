package Multijoueur;

import java.io.*;
import java.net.*;
import java.util.*;
import Local.*;
import Multijoueur.ActionServeur.*;
import Utils.*;

public class Client implements Serializable {
  private Joueur joueur;
  private Socket socket;

  public Client(Joueur joueur, Socket socket) {
    this.joueur = joueur;
    this.socket = socket;
  }

  public void exec(){
    try {
      ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
      ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
      out.writeObject(joueur);
      out.flush();
      System.out.println("En attente d'un adversaire..");
      Joueur joueur2 = (Joueur) in.readObject();
      System.out.println("Adversaire trouvé: " + joueur2.getNom() + " !");

      while (true) {
        String message = (String) in.readObject();
        System.out.println(message);
        if (message.equals("Fin de la partie !")) {
          break;
        }
      }

      System.out.println("Quelle beauté...");
      TempsAttente.attendre(2000);
  
    } catch (IOException | ClassNotFoundException e) {
      e.printStackTrace();
    }

  }
}

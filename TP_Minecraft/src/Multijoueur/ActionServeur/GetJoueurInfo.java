package Multijoueur.ActionServeur;

import java.io.*;
import java.net.*;

import Local.*;
import Multijoueur.Serveur;

public class GetJoueurInfo implements Runnable {
  private Socket client;
  private ObjectInputStream in;

  public GetJoueurInfo(Socket client, ObjectInputStream in) {
    this.client = client;
    this.in = in;
  }

  public void run(){
    try {
      Joueur joueur = (Joueur) in.readObject();
      Serveur.setJoueur(client, joueur);
    } catch (ClassNotFoundException | IOException e) {
        e.printStackTrace();
    }

    System.out.println("Joueur connecté : " + Serveur.getJoueursMap().get(client).getNom());
    
  }
  
}

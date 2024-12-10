package Multijoueur.ActionServeur;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import Local.Joueur;
import Multijoueur.Serveur;
import Utils.TempsAttente;

public class BoucleJeu {

  // 1. Savoir qui joue en premier (random 0 ou 1) /PremierJoueur/DeuxiemeJoueur/
  // 2. Boucle de jeu
  // 2.1. ECHANGE DATTAQUES SANS DEMANDE DU SERVEUR

  private ArrayList<Socket> clientsArrayList = new ArrayList<Socket>();
  private Map<Socket, Joueur> joueursMap = new HashMap<Socket, Joueur>();
  private Map<Socket, ObjectOutputStream> outMap = new HashMap<Socket, ObjectOutputStream>();
  private Map<Socket, ObjectInputStream> inMap = new HashMap<Socket, ObjectInputStream>();

  public BoucleJeu(ArrayList<Socket> clientsArrayList, Map<Socket, Joueur> joueursMap,
      Map<Socket, ObjectOutputStream> outMap, Map<Socket, ObjectInputStream> inMap) {
    this.clientsArrayList = clientsArrayList;
    this.joueursMap = joueursMap;
    this.outMap = outMap;
    this.inMap = inMap;
  }

  public void broadcast(int code, String message) {
    for (Socket client : clientsArrayList) {
      try {
        outMap.get(client).writeInt(code);
        outMap.get(client).writeObject(message);
        outMap.get(client).flush();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }

  public void broadcastJoueur(int code, String message, Socket client) {
    try {
      outMap.get(client).writeInt(code);
      outMap.get(client).writeObject(message);
      outMap.get(client).flush();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void broadcastDataJoueur(Joueur joueur, Socket client) {
    try {
      outMap.get(client).writeObject(joueur);
      outMap.get(client).flush();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void exec() {
    int index = (int) (Math.random() * 2);
    int nbTours = 0;

    while (true) {

      Socket client = clientsArrayList.get(index);
      Joueur joueur = joueursMap.get(client);
      Socket clientAdversaire = clientsArrayList.get((index + 1) % 2);
      Joueur joueurAdversaire = joueursMap.get(clientAdversaire);

      broadcastJoueur(9, "Vos PV: " + joueur.getPointsVie() + ", PV adversaire: " + joueurAdversaire.getPointsVie(), client);
      broadcastJoueur(9, "Vos PV: " + joueurAdversaire.getPointsVie() + ", PV adversaire: " + joueur.getPointsVie(), clientAdversaire);

      broadcastJoueur(1, "C'est à vous de jouer !", client);
      broadcastJoueur(9, "C'est à " + joueur.getNom() + " de jouer !", clientAdversaire);

      broadcastDataJoueur(joueur, client);

      try {
        joueur = (Joueur) inMap.get(client).readObject();
        Serveur.modifJoueurMap(client, joueur);
        System.out.println("Données bien mises à jour !");
      } catch (ClassNotFoundException | IOException e) {
        e.printStackTrace();
      }

      TempsAttente.attendre(700);

      int degatsPoint = joueur.getPointsAttaque();
      int degatsArme = (joueur.getArme() != null ? joueur.getArme().getBonusAttaque() : 0);

      joueurAdversaire.recevoirDegats(degatsPoint + degatsArme);

      broadcastJoueur(9, "Vous avez infligé " + (degatsPoint + degatsArme) + " points de dégâts à "
          + joueurAdversaire.getNom() + " ! Il lui reste " + joueurAdversaire.getPointsVie() + " points de vie.", client);
      broadcastJoueur(9, joueur.getNom() + " vous a infligé " + (degatsPoint + degatsArme) + " points de dégâts ! Il vous reste "
          + joueurAdversaire.getPointsVie() + " points de vie.", clientAdversaire);

      TempsAttente.attendre(1000);

      nbTours++;

      if (nbTours == 10) {
        broadcast(9, "Fin du temps imparti ! Egalité !");
        break;
      }

      if (joueurAdversaire.getPointsVie() <= 0) {
        broadcastJoueur(9, "Vous avez gagné !", client);
        broadcastJoueur(9, joueur.getNom() + " a gagné !", clientAdversaire);
        joueurAdversaire.setPointsVie(20);
        TempsAttente.attendre(1000);
        break;
      }

      index = (index + 1) % 2;
    }

    broadcast(9, "Fin de la partie !");
    // Envoyer à chacun son joueur final
    for (Socket client : clientsArrayList) {
      broadcastDataJoueur(joueursMap.get(client), client);
    }
  }
}

// CODES :
// 1 : Code début de tour
// 9 : Information only
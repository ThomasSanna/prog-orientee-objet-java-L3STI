package Multijoueur.ActionServeur;

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

  private static ArrayList<Socket> clientsArrayList = new ArrayList<Socket>();
  private static Map<Socket, Joueur> joueursMap = new HashMap<Socket, Joueur>();
  private static Map<Socket, ObjectOutputStream> outMap = new HashMap<Socket, ObjectOutputStream>();

  public BoucleJeu(ArrayList<Socket> clientsArrayList, Map<Socket, Joueur> joueursMap,
      Map<Socket, ObjectOutputStream> outMap) {
    this.clientsArrayList = clientsArrayList;
    this.joueursMap = joueursMap;
    this.outMap = outMap;
  }

  public void broadcast(String message) {
    for (Socket client : clientsArrayList) {
      try {
        outMap.get(client).writeObject(message);
        outMap.get(client).flush();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }

  public void exec() {
    int index = (int) (Math.random() * 2);

    while (true) {
      Socket client = clientsArrayList.get(index);
      Joueur joueur = joueursMap.get(client);
      broadcast("C'est à " + joueur.getNom() + " de jouer !");

      TempsAttente.attendre(1000);

      int degatsPoint = joueur.getPointsAttaque();
      int degatsArme = (joueur.getArme() != null ? joueur.getArme().getBonusAttaque() : 0);

      Socket clientAdversaire = clientsArrayList.get((index + 1) % 2);
      Joueur joueurAdversaire = joueursMap.get(clientAdversaire);

      joueurAdversaire.recevoirDegats(degatsPoint + degatsArme);

      broadcast(joueur.getNom() + " a infligé " + (degatsPoint + degatsArme) + " points de dégâts à "
          + joueurAdversaire.getNom() + " ! Il lui reste " + joueurAdversaire.getPointsVie() + " points de vie.");

      TempsAttente.attendre(1000);

      if (joueurAdversaire.getPointsVie() <= 0) {
        broadcast(joueurAdversaire.getNom() + " est mort !");
        joueurAdversaire.setPointsVie(20);
        joueur.setPointsVie(20);
        TempsAttente.attendre(1000);
        break;
      }

      index = (index + 1) % 2;
    }

    broadcast("Fin de la partie !");
  }
}

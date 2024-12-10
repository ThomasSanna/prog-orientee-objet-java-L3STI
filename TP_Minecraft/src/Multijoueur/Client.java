package Multijoueur;

import java.io.*;
import java.net.*;
import java.util.Scanner;

import Local.*;
import Utils.*;

public class Client implements Serializable {
  private Joueur joueur;
  private Socket socket;

  public Client(Joueur joueur, Socket socket) {
    this.joueur = joueur;
    this.socket = socket;
  }

  public int demanderActionTour(){
    System.out.println("\nQue voulez-vous faire ?");
    System.out.println("1 - Attaquer");
    System.out.println("2 - Manger Nourriture");
    System.out.println("3 - Crafter");
    System.out.println("4 - Afficher Inventaire");
    System.out.print("Choisissez une option: ");
    int choix = joueur.getScanner().nextInt();
    joueur.getScanner().nextLine();

    return choix;
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

        int code = in.readInt();
        String message = (String) in.readObject();
        System.out.println(message);


        if (code == 1){

          Joueur joueurJoue = (Joueur) in.readObject();
          joueurJoue.setScanner(new Scanner(System.in));

          int choix = 0;
          while (choix != 1) {
            choix = demanderActionTour();

            switch (choix) {
              case 1:
                System.out.println("\nVous attaquez !");
                break;
              case 2:
                joueurJoue.consommerNourriture();
                break;
              case 3:
                joueurJoue.crafter();
                break;
              case 4:
                joueurJoue.afficherInventaire();
              default:
                System.out.println("\nProblème lors de la saisie. Veuillez rééssayer.");
                break;
            }
          }
          out.writeObject(joueurJoue);
        }

        if (message.equals("Fin de la partie !")) {
          Joueur vous = (Joueur) in.readObject();
          this.joueur.setPointsVie(vous.getPointsVie());
          this.joueur.setArme(vous.getArme());
          this.joueur.setArmure(vous.getArmure());
          this.joueur.setInventaire(vous.getInventaire());
        break;
        }
      }

      TempsAttente.attendre(700);
  
    } catch (IOException | ClassNotFoundException e) {
      System.out.println("Erreur lors de la connexion au serveur.");
    }

  }
}

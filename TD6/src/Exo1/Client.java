package Exo1;

import java.io.*;
import java.net.*;
import java.util.Random;


public class Client {

  public static void main(String[] args) {
    int port = 2000;
    String serverName = "localhost";

    try{
      
      System.out.println("Connexion à " + serverName + ":" + port + "."); //////
      Socket client = new Socket(serverName, port);
      System.out.println("Connexion réussie."); //////

      Random rand = new Random();
      int randomAge = rand.nextInt(100);

      Personne maPersonne = new Personne("Marie", "Mon", randomAge);

      ObjectOutputStream oos = new ObjectOutputStream(client.getOutputStream());
      oos.writeObject(maPersonne);

      System.out.println("Votre personne " + maPersonne + " a été envoyé au serveur.");
      
      client.close();
    } catch (IOException e){
      e.printStackTrace();
    }
 
  }
}
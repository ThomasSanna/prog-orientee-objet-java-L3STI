package Exo1.ActionServeur;

import java.io.*;
import java.net.*;
import Exo1.Personne;

public class ReceivePersonne implements Runnable, Serializable {

  private Socket client;

  public ReceivePersonne (Socket client){
    this.client = client;
  }

  public void run(){
    try{
      ObjectInputStream ois = new ObjectInputStream(client.getInputStream());

      while (true){
        Personne p = (Personne) ois.readObject();
        System.out.println("Nouvelle personne envoyée par " + client.getPort());
        System.out.println(p);
      }
    } catch (IOException e){
      System.out.println("L'utilisateur est parti.");
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
  }
  
}

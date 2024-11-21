package Exo1.Serialiseur;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import Exo1.Personne;

public class Serialiser implements Serializable{

  public static void serialiser(Personne p, String fichierString) {
    try {
      FileOutputStream fos = new FileOutputStream(fichierString);
      ObjectOutputStream oos = new ObjectOutputStream(fos);
      oos.writeObject(p);
      oos.close();
      fos.close();
      System.out.println("Les données ont bien été sérialisées dans " + fichierString);
    } catch (IOException i) {
      i.printStackTrace();
    }
  }

}
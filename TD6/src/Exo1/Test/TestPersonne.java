package Exo1.Test;

import Exo1.Personne;
import Exo1.Serialiseur.Deserialiser;
import Exo1.Serialiseur.Serialiser;

public class TestPersonne {
  public static void main(String[] args) {
    Personne p1 = new Personne("Monsieur", "Madame", 15);
    System.out.println(p1);
    Serialiser.serialiser(p1, "personne.ser");
    Personne p11 = Deserialiser.deserialiser("personne.ser");
    System.out.println(p11);
  }
}

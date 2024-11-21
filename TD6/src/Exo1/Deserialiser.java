package Exo1;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class Deserialiser implements Serializable{

  public static Personne deserialiser(String fichierString){
    try{
      FileInputStream fis = new FileInputStream(fichierString);
      ObjectInputStream ois = new ObjectInputStream(fis);
      Personne p = (Personne) ois.readObject();
      fis.close();
      ois.close();
      return p;
    } catch(IOException i){
      i.printStackTrace();
      return null;
    } catch(ClassNotFoundException e){
      e.printStackTrace();
      return null;
    }
  }

}
package exo11;

import java.time.LocalDate;

public class Personne {

  protected String nom;
  protected LocalDate dateNaissance;
  protected String groupeSanguin;

  public Personne(String nom, LocalDate dateNaissance, String groupeSanguin){
    this.nom = nom;
    this.dateNaissance = dateNaissance;
    this.groupeSanguin = groupeSanguin;
  }

  public int getAge(){
    return LocalDate.now().getYear() - dateNaissance.getYear();
  }

  public String getNom(){
    return nom;
  }

}

package exo11;

import java.time.LocalDate;

public class Pilote extends Personne {
  private Voiture voitureConduite;

  public Pilote(Personne p, Voiture voitureConduite){
    super(p.nom, p.dateNaissance, p.groupeSanguin);
    this.voitureConduite = voitureConduite;
  }

  public Pilote(String nom, LocalDate dateNaissance, String groupeSanguin, Voiture voitureConduite){
    super(nom, dateNaissance, groupeSanguin);
    this.voitureConduite = voitureConduite;
  }

  public Voiture getVoitureConduite(){
    return voitureConduite;
  }

}
package exo11;

import java.time.LocalDate;

public class Copilote extends Pilote {

  public Copilote(Personne p, Voiture voitureCoconduite){
    super(p, voitureCoconduite);
  }

  public Copilote(String nom, LocalDate dateNaissance, String groupeSanguin, Voiture voitureCoconduite){
    super(nom, dateNaissance, groupeSanguin, voitureCoconduite);
  }

  public Voiture getVoitureCoconduite(){
    return this.voitureConduite;
  }

}
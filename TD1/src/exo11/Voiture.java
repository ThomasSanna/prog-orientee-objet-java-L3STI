package exo11;

public class Voiture {
  private char typeVoiture;
  private Pilote monPilote;
  private Copilote monCopilote;

  public Voiture(char typeVoiture, Pilote monPilote, Copilote monCopilote){
    this.typeVoiture = typeVoiture;
    this.monPilote = monPilote;
    this.monCopilote = monCopilote;
  }

  public Pilote getMonPilote() {
    return monPilote;
  }

  public Copilote getMonCopilote() {
    return monCopilote;
  }

  public char getTypeVoiture() {
    return typeVoiture;
  }
}
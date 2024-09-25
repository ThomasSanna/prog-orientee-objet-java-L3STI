package exo11;

public class Voiture {
  private char typeVoiture;
  private Pilote monPilote;
  private Copilote monCopilote;

  public Voiture(char typeVoiture){
    this.typeVoiture = typeVoiture;
    this.monPilote = null;
    this.monCopilote = null;
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

package exo2;

public class ScooterElectrique extends Scooter {

  private int autonomie;

  public ScooterElectrique(String modele, int puissance, String couleur, int autonomie) {
    super(modele, puissance, couleur);
    this.autonomie = autonomie;
  }

  public void afficherCaracteristiques() {
    super.afficherCaracteristiques();
    System.out.println("Autonomie : " + autonomie);
  }


  public static void main(String[] args) {
    ScooterElectrique scooter = new ScooterElectrique("Peugeot", 200, "bleu", 10);
    scooter.afficherCaracteristiques();
  }

}

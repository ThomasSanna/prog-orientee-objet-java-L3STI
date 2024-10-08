package exo2;

public class AutomobileElectrique extends Automobile {

  private int autonomie;

  public AutomobileElectrique(String modele, int puissance, String couleur, double espace, int autonomie) {
    super(modele, puissance, couleur, espace);
    this.autonomie = autonomie;
  }

  public void afficherCaracteristiques() {
    super.afficherCaracteristiques();
    System.out.println("Autonomie : " + autonomie);
  }

  public static void main(String[] args) {
    AutomobileElectrique auto = new AutomobileElectrique("Tesla", 1000, "rouge", 5.0, 500);
    auto.afficherCaracteristiques();
  }

}

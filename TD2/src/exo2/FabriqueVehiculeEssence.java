package exo2;

public class FabriqueVehiculeEssence implements FabriqueVehicule {

  @Override
  public ScooterEssence creerScooter(String modele, int puissance, String couleur) {
    return new ScooterEssence(modele, puissance, couleur, 5); // Autonomie par défaut
  }

  @Override
  public AutomobileEssence creerVoiture(String modele, int puissance, String couleur, double espace) {
    return new AutomobileEssence(modele, puissance, couleur, espace, 10); // Autonomie par défaut
  }

  public static void main(String[] args) {
    FabriqueVehicule fabrique = new FabriqueVehiculeEssence();
    ScooterEssence scooter = (ScooterEssence) fabrique.creerScooter("Peugeot", 200, "bleu");
    scooter.afficherCaracteristiques();
    AutomobileElectrique auto = (AutomobileElectrique) fabrique.creerVoiture("Tesla", 1000, "rouge", 5.0);
    auto.afficherCaracteristiques();
  }

}

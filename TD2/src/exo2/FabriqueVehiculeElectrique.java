package exo2;

public class FabriqueVehiculeElectrique implements FabriqueVehicule {

  @Override
  public ScooterElectrique creerScooter(String modele, int puissance, String couleur) {
    return new ScooterElectrique(modele, puissance, couleur, 100); // Autonomie par défaut
  }

  @Override
  public AutomobileElectrique creerVoiture(String modele, int puissance, String couleur, double espace) {
    return new AutomobileElectrique(modele, puissance, couleur, espace, 300); // Autonomie par défaut
  }

  public static void main(String[] args) {
    FabriqueVehicule fabrique = new FabriqueVehiculeElectrique();
    ScooterElectrique scooter = (ScooterElectrique) fabrique.creerScooter("Peugeot", 200, "bleu");
    scooter.afficherCaracteristiques();
    AutomobileElectrique auto = (AutomobileElectrique) fabrique.creerVoiture("Tesla", 1000, "rouge", 5.0);
    auto.afficherCaracteristiques();
  }

}

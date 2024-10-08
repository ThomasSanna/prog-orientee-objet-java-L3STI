package exo2;

public interface FabriqueVehicule {

  Scooter creerScooter(String modele, int puissance, String couleur);

  Automobile creerVoiture(String modele, int puissance, String couleur, double espace);

}
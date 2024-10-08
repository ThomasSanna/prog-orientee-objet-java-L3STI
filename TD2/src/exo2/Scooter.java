package exo2;

public abstract class Scooter {

  private String modele;
  private int puissance;
  private String couleur;

  public Scooter(String modele, int puissance, String couleur) {
    this.modele = modele;
    this.puissance = puissance;
    this.couleur = couleur;
  }

  public void afficherCaracteristiques() {
    System.out.println("Modèle : " + modele);
    System.out.println("Puissance : " + puissance);
    System.out.println("Couleur : " + couleur);
  }

}

package exo2;

public abstract class Automobile {

  private String modele;
  private int puissance;
  private String couleur;
  private double espace;

  public Automobile(String modele, int puissance, String couleur, double espace) {
    this.modele = modele;
    this.puissance = puissance;
    this.couleur = couleur;
    this.espace = espace;
  }

  public void afficherCaracteristiques() {
    System.out.println("Modèle : " + modele);
    System.out.println("Puissance : " + puissance);
    System.out.println("Couleur : " + couleur);
    System.out.println("Espace : " + espace);
  }

}

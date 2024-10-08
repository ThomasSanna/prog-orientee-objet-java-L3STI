package exo4;
class Film extends Video {
  private double duree;

  public Film(int id, String titre, String synopsis, double duree, SocieteDeProduction producteur) {
      super(id, titre, synopsis, producteur);
      this.duree = duree;
  }

  @Override
  public void afficherDetails() {
      System.out.println("Film: " + getTitre() + " (" + duree + " heures)");
      System.out.println("Synopsis: " + getSynopsis());
      System.out.println("Producteur: " + getProducteur().getNom());
  }

  // Getters and Setters
  public double getDuree() {
    return duree;
  }

  public void setDuree(double duree) {
      this.duree = duree;
  }
}
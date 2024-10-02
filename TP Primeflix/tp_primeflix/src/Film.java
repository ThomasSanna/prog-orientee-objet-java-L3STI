class Film {
  private int id;
  private String titre;
  private String synopsis;
  private double duree;
  private SocieteDeProduction producteur;

  public Film(int id, String titre, String synopsis, double duree, SocieteDeProduction producteur) {
      this.id = id;
      this.titre = titre;
      this.synopsis = synopsis;
      this.duree = duree;
      this.producteur = producteur;
  }

  public void afficherDetails() {
      System.out.println("Film: " + titre + " (" + duree + " heures)");
      System.out.println("Synopsis: " + synopsis);
      System.out.println("Producteur: " + producteur.getNom());
  }

  // Getters and Setters
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getTitre() {
    return titre;
  }

  public void setTitre(String titre) {
    this.titre = titre;
  }

  public String getSynopsis() {
    return synopsis;
  }

  public void setSynopsis(String synopsis) {
    this.synopsis = synopsis;
  }

  public double getDuree() {
    return duree;
  }

  public void setDuree(double duree) {
    this.duree = duree;
  }

  public SocieteDeProduction getProducteur() {
    return producteur;
  }

  public void setProducteur(SocieteDeProduction producteur) {
    this.producteur = producteur;
  }
}
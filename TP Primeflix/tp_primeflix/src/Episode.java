class Episode {
  private int id;
  private String titre;
  private double duree;

  public Episode(int id, String titre, double duree) {
      this.id = id;
      this.titre = titre;
      this.duree = duree;
  }

  public void afficherDetails() {
      System.out.println("Episode " + id + ": " + titre + " (" + duree + " heures)");
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

  public double getDuree() {
    return duree;
  }

  public void setDuree(double duree) {
    this.duree = duree;
  }
}
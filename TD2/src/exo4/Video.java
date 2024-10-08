package exo4;
public abstract class Video {
  private int id;
  private String titre;
  private String synopsis;
  private SocieteDeProduction producteur;

  public Video(int id, String titre, String synopsis, SocieteDeProduction producteur) {
      this.id = id;
      this.titre = titre;
      this.synopsis = synopsis;
      this.producteur = producteur;
  }

  public abstract void afficherDetails();

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

  public SocieteDeProduction getProducteur() {
      return producteur;
  }

  public void setProducteur(SocieteDeProduction producteur) {
      this.producteur = producteur;
  }
}
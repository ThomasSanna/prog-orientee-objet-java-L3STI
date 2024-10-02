import java.util.ArrayList;
import java.util.List;

class Serie {
  private int id;
  private String titre;
  private String synopsis;
  private List<Saison> saisons = new ArrayList<>();
  private SocieteDeProduction producteur;

  public Serie(int id, String titre, String synopsis, SocieteDeProduction producteur) {
      this.id = id;
      this.titre = titre;
      this.synopsis = synopsis;
      this.producteur = producteur;
  }

  public void ajouterSaison(Saison saison) {
      saisons.add(saison);
  }

  public void afficherDetails() {
      System.out.println("Série: " + titre);
      System.out.println("Synopsis: " + synopsis);
      System.out.println("Producteur: " + producteur.getNom());
      System.out.println("Saisons:");
      for (Saison saison : saisons) {
          saison.afficherDetails();
      }
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

  public List<Saison> getSaisons() {
    return saisons;
  }

  public void setSaisons(List<Saison> saisons) {
    this.saisons = saisons;
  }

  public SocieteDeProduction getProducteur() {
    return producteur;
  }

  public void setProducteur(SocieteDeProduction producteur) {
    this.producteur = producteur;
  }
}
import java.util.ArrayList;
import java.util.List;

class SocieteDeProduction {
  private int id;
  private String nom;
  private List<Film> catalogue = new ArrayList<>();
  private List<Serie> catalogueSeries = new ArrayList<>();
  private double revenus = 0.0;

  public SocieteDeProduction(int id, String nom) {
      this.id = id;
      this.nom = nom;
  }

  public void ajouterFilm(Film film) {
      catalogue.add(film);
  }

  public void ajouterSerie(Serie serie) {
      catalogueSeries.add(serie);
  }

  public double calculerRevenus() {
      return revenus;
  }

  public void ajouterRevenus(double montant) {
      revenus += montant;
  }

  // Getters and Setters
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public List<Film> getCatalogue() {
    return catalogue;
  }

  public void setCatalogue(List<Film> catalogue) {
    this.catalogue = catalogue;
  }

  public List<Serie> getCatalogueSeries() {
    return catalogueSeries;
  }

  public void setCatalogueSeries(List<Serie> catalogueSeries) {
    this.catalogueSeries = catalogueSeries;
  }

  public double getRevenus() {
    return revenus;
  }

  public void setRevenus(double revenus) {
    this.revenus = revenus;
  }
}
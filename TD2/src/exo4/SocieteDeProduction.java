package exo4;

import java.util.ArrayList;
import java.util.List;

class SocieteDeProduction implements UtilisateurPlateforme {
  private int id;
  private String nom;
  private List<Film> catalogue = new ArrayList<>();
  private List<Serie> catalogueSeries = new ArrayList<>();
  private double revenus = 0.0;
  private String email;

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
  @Override
  public int getId() {
    return id;
  }

  @Override
  public void setId(int id) {
    this.id = id;
  }

  @Override
  public String getNom() {
    return nom;
  }

  @Override
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

  @Override
  public String getEmail() {
    return email;
  }

  @Override
  public void setEmail(String email) {
    this.email = email;
  }
}
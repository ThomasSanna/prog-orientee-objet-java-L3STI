class Utilisateur {
  private int id;
  private String nom;
  private String email;
  private boolean premium;
  private double solde;
  private Primeflix primeflix;

  public Utilisateur(int id, String nom, String email, boolean premium, double solde, Primeflix primeflix) {
      this.id = id;
      this.nom = nom;
      this.email = email;
      this.premium = premium;
      this.solde = solde;
      this.primeflix = primeflix;
  }

  public void regarderFilm(Film film, double duree) {
      double frais = primeflix.calculerFraisVisionnage(this, duree, this.premium);
      if (this.solde >= frais) {
          this.solde -= frais;
          primeflix.redistribuerRevenus(film, duree);
          System.out.println("Vous avez regardé le film: " + film.getTitre());
      } else {
          System.out.println("Solde insuffisant pour regarder ce film.");
      }
  }

  public void regarderSerie(Serie serie, double duree) {
      double frais = primeflix.calculerFraisVisionnage(this, duree, this.premium);
      if (this.solde >= frais) {
          this.solde -= frais;
          primeflix.redistribuerRevenus(serie, duree);
          System.out.println("Vous avez regardé la série: " + serie.getTitre());
      } else {
          System.out.println("Solde insuffisant pour regarder cette série.");
      }
  }

  public void ajouterSolde(double montant) {
      this.solde += montant;
  }

  public Playlist creerPlaylist(String nom) {
      return new Playlist(nom);
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

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public boolean isPremium() {
    return premium;
  }

  public void setPremium(boolean premium) {
    this.premium = premium;
  }

  public double getSolde() {
    return solde;
  }

  public void setSolde(double solde) {
    this.solde = solde;
  }

  public Primeflix getPrimeflix() {
    return primeflix;
  }

  public void setPrimeflix(Primeflix primeflix) {
    this.primeflix = primeflix;
  }
}
public class TestPrimeflix {
  public static void main(String[] args) {
      Primeflix primeflix = new Primeflix();

      SocieteDeProduction prod1 = new SocieteDeProduction(1, "Prod1");
      Film film1 = new Film(1, "Film1", "Synopsis1", 2.0, prod1);
      Serie serie1 = new Serie(1, "Serie1", "Synopsis1", prod1);
      Saison saison1 = new Saison(1, 1);
      Episode episode1 = new Episode(1, "Episode1", 1.0);
      saison1.ajouterEpisode(episode1);
      serie1.ajouterSaison(saison1);

      prod1.ajouterFilm(film1);
      prod1.ajouterSerie(serie1);

      Utilisateur user1 = new Utilisateur(1, "User1", "user1@example.com", false, 10.0, primeflix);
      primeflix.ajouterUtilisateur(user1);

      System.out.println("Solde initial: " + user1.getSolde());

      user1.regarderFilm(film1, 2.0);
      System.out.println("Solde après avoir regardé un film: " + user1.getSolde());

      user1.regarderSerie(serie1, 1.0);
      System.out.println("Solde après avoir regardé une série: " + user1.getSolde());

      Playlist playlist1 = user1.creerPlaylist("Ma Playlist");
      playlist1.ajouterVideo(film1);
      playlist1.ajouterVideo(serie1);
      playlist1.afficherPlaylist();
  }
}
package exo4;

public class TestPrimeflix {
    public static void main(String[] args) {
        // Initialiser les données (sdp, films, séries, utilisateurs)
        SocieteDeProduction prod1 = new SocieteDeProduction(1, "Prod1");
        SocieteDeProduction prod2 = new SocieteDeProduction(2, "Prod2");

        Film film1 = new Film(1, "Film1", "Synopsis de Film1", 2.0, prod1);
        Film film2 = new Film(2, "Film2", "Synopsis de Film2", 1.5, prod2);

        Serie serie1 = new Serie(1, "Serie1", "Synopsis de Serie1", prod1);
        Saison saison1 = new Saison(1, "Saison 1", "Synopsis de Saison 1", prod1, 1);
        Episode episode1 = new Episode(1, "Episode1", 0.5);
        Episode episode2 = new Episode(2, "Episode2", 0.6);
        saison1.ajouterEpisode(episode1);
        saison1.ajouterEpisode(episode2);
        serie1.ajouterSaison(saison1);

        // Créer Primeflix
        Primeflix primeflix = new Primeflix();
        primeflix.films.add(film1);
        primeflix.films.add(film2);
        primeflix.series.add(serie1);

        // Créer des utilisateurs
        Utilisateur user1 = new Utilisateur(1, "User1", "user1@example.com", false, 10.0, primeflix);
        Utilisateur user2 = new Utilisateur(2, "User2", "user2@example.com", true, 15.0, primeflix);
        primeflix.ajouterUtilisateur(user1);
        primeflix.ajouterUtilisateur(user2);

        // User1 regarde film1
        System.out.println("User1 regarde Film1:");
        user1.regarderFilm(film1, film1.getDuree());
        System.out.println("Solde de User1: " + user1.getSolde());

        // User2 regarde serie1
        System.out.println("User2 regarde Serie1:");
        user2.regarderSerie(serie1, episode1.getDuree() + episode2.getDuree());
        System.out.println("Solde de User2: " + user2.getSolde());

        // Afficher les détails
        System.out.println("\nDétails de Film1:");
        film1.afficherDetails();

        System.out.println("\nDétails de Serie1:");
        serie1.afficherDetails();
    }
}
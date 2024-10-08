package exo4;

import java.util.ArrayList;
import java.util.List;

class Saison extends Video {
    private int numero;
    private List<Episode> episodes = new ArrayList<>();

    public Saison(int id, String titre, String synopsis, SocieteDeProduction producteur, int numero) {
        super(id, titre, synopsis, producteur);
        this.numero = numero;
    }

    public void ajouterEpisode(Episode episode) {
        episodes.add(episode);
    }

    public void afficherDetails() {
        System.out.println("Saison " + numero + ":");
        for (Episode episode : episodes) {
            episode.afficherDetails();
        }
    }

    // Getters and Setters
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public List<Episode> getEpisodes() {
        return episodes;
    }

    public void setEpisodes(List<Episode> episodes) {
        this.episodes = episodes;
    }
}
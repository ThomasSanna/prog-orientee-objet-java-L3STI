import java.util.ArrayList;
import java.util.List;

class Saison {
    private int id;
    private int numero;
    private List<Episode> episodes = new ArrayList<>();

    public Saison(int id, int numero) {
        this.id = id;
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
    public int getId() {
      return id;
    }

    public void setId(int id) {
      this.id = id;
    }

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
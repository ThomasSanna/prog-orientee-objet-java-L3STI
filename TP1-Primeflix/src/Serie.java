import java.util.ArrayList;
import java.util.List;

class Serie extends Video {
    private List<Saison> saisons = new ArrayList<>();

    public Serie(int id, String titre, String synopsis, SocieteDeProduction producteur) {
        super(id, titre, synopsis, producteur);
    }

    public void ajouterSaison(Saison saison) {
        saisons.add(saison);
    }

    @Override
    public void afficherDetails() {
        System.out.println("Série: " + getTitre());
        System.out.println("Synopsis: " + getSynopsis());
        System.out.println("Producteur: " + getProducteur().getNom());
        System.out.println("Saisons:");
        for (Saison saison : saisons) {
            saison.afficherDetails();
        }
    }

    // Getters and Setters
    public List<Saison> getSaisons() {
        return saisons;
    }

    public void setSaisons(List<Saison> saisons) {
        this.saisons = saisons;
    }
}
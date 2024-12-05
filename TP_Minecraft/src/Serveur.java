import java.util.ArrayList;
import java.util.List;

public class Serveur {
    private List<Joueur> joueurs;

    public Serveur() {
        this.joueurs = new ArrayList<>();
    }

    public void lancerCombat(Joueur joueur1, Joueur joueur2) {
        System.out.println("Combat entre " + joueur1.getNom() + " et " + joueur2.getNom());
        // Ajouter la logique du combat ici
    }

    public void ajouterJoueur(Joueur joueur) {
        joueurs.add(joueur);
        System.out.println(joueur.getNom() + " a rejoint le serveur.");
    }
}

package Local;
import Utils.TempsAttente;

public class Monstre implements Cloneable {
    private String nom;
    private int pointsVie;
    private int pointsAttaque;
    private Item drop;
    private double tauxApparition;

    public Monstre(String nom, int pointsVie, int pointsAttaque, Item drop, double tauxApparition) {
        this.nom = nom;
        this.pointsVie = pointsVie;
        this.pointsAttaque = pointsAttaque;
        this.drop = drop;
        this.tauxApparition = tauxApparition;
    }

    public void attaquer(Joueur joueur) {
        System.out.println(nom + " attaque " + joueur.getNom());
        TempsAttente.attendre(1000);
        joueur.recevoirDegats(pointsAttaque);
    }

    public void recevoirDegats(int degats) {
        pointsVie -= degats;
        System.out.println(nom + " a reçu " + degats + " dégâts. PV restants : " + pointsVie);
    }

    public Item getDrop() {
        return drop;
    }

    public double getTauxApparition() {
        return tauxApparition;
    }

    public String getNom() {
        return nom;
    }

    public int getPointsVie() {
        return pointsVie;
    }

    public int getPointsAttaque() {
        return pointsAttaque;
    }

    @Override
    public Monstre clone() {
        try {
            return (Monstre) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Erreur lors du clonage du monstre", e);
        }
    }

    @Override
    public String toString() {
        return nom + " : PV " + pointsVie + ", Attaque " + pointsAttaque;
    }
}
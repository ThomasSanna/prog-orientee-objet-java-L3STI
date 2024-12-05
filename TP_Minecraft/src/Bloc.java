public class Bloc {
    private String nom;
    private String type;
    private String proprietes;
    private Item drop;
    private double tauxApparition;
    private int tempsCasse;

    public Bloc(String nom, String type, String proprietes, Item drop, double tauxApparition, int tempsCasse) {
        this.nom = nom;
        this.type = type;
        this.proprietes = proprietes;
        this.drop = drop;
        this.tauxApparition = tauxApparition;
        this.tempsCasse = tempsCasse;
    }

    public Bloc(String nom, String type, String proprietes, Item drop, double tauxApparition) {
        this(nom, type, proprietes, drop, tauxApparition, 2000);
    }

    public Item recuperer() {
        System.out.println(drop.getNom() + " a ete ajoute a votre inventaire.");
        drop.addQuantite(1);
        return drop;
    }

    public String getNom() {
        return nom;
    }

    public double getTauxApparition() {
        return tauxApparition;
    }

    public Item getDrop() {
        return drop;
    }

    public String getType() {
        return type;
    }

    public String getProprietes() {
        return proprietes;
    }

    public int getTempsCasse() {
        return tempsCasse;
    }

    public String toString() {
        return nom + " (" + type + ") : " + proprietes + " [Taux d'apparition: " + tauxApparition + "]";
    }
}

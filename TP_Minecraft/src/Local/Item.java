package Local;
public class Item implements java.io.Serializable {
    private String nom;
    private String type;
    private int quantite;

    public Item(String nom, String type, int quantite) {
        this.nom = nom;
        this.type = type;
        this.quantite = quantite;
    }

    public void utiliser() {
        System.out.println("Utilisation de l'item : " + nom);
    }

    public int getQuantite() {
        return quantite;
    }
    
    public void addQuantite(int quantite) {
        this.quantite += quantite;
    }

    public void removeQuantite(int quantite) {
        this.quantite -= this.quantite - quantite >= 0 ? quantite : this.quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public String getNom() {
        return nom;
    }

    public String getType() {
        return type;
    }


}

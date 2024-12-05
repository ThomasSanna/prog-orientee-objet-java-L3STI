package Local;
public class Arme extends Equipement implements java.io.Serializable {
    public Arme(String nom, int bonusAttaque, int rarete) {
        super(nom, 0, bonusAttaque, rarete);
    }
}
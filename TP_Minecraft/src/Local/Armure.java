package Local;
public class Armure extends Equipement implements java.io.Serializable {
    public Armure(String nom, int bonusDefense, int rarete) {
        super(nom, bonusDefense, 0, rarete);
    }
}
public class Equipement extends Item {
    private int bonusDefense;
    private int bonusAttaque;
    private int rarete; // 0: Pierre, 1: Fer, 2: Or, 3: Diamant

    public Equipement(String nom, int bonusDefense, int bonusAttaque, int rarete) {
        super(nom, "Equipement", 1);
        this.bonusDefense = bonusDefense;
        this.bonusAttaque = bonusAttaque;
        this.rarete = rarete;
    }

    public int getBonusDefense() {
        return bonusDefense;
    }

    public int getBonusAttaque() {
        return bonusAttaque;
    }

    public int getRarete() {
        return rarete;
    }
}

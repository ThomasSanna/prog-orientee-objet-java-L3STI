package exo2;

public class ScooterEssence extends Scooter {
  
    private int consommation;
  
    public ScooterEssence(String modele, int puissance, String couleur, int consommation) {
      super(modele, puissance, couleur);
      this.consommation = consommation;
    }
  
    public void afficherCaracteristiques() {
      super.afficherCaracteristiques();
      System.out.println("Consommation : " + consommation);
    }
  
    public static void main(String[] args) {
      ScooterEssence scooter = new ScooterEssence("Peugeot", 200, "bleu", 10);
      scooter.afficherCaracteristiques();
    }

}

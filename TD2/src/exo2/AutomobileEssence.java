package exo2;

public class AutomobileEssence extends Automobile {
  
    private int consommation;
  
    public AutomobileEssence(String modele, int puissance, String couleur, double espace, int consommation) {
      super(modele, puissance, couleur, espace);
      this.consommation = consommation;
    }
  
    public void afficherCaracteristiques() {
      super.afficherCaracteristiques();
      System.out.println("Consommation : " + consommation);
    }
  
    public static void main(String[] args) {
      AutomobileEssence auto = new AutomobileEssence("Peugeot", 200, "bleu", 4.0, 10);
      auto.afficherCaracteristiques();
    }

}

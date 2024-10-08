package exo3;

public class Banque {

  private int solde; // Somme d'argent possible

  public Banque(int solde) {
    this.solde = solde;
  }

  public void retrait(int somme) throws RetraitException{
    if (solde < somme){
      throw new RetraitException("Votre solde (" + solde + ") est trop bas pour retirer " + somme + ".");
    }
    solde -= somme;
    System.out.println("Retrait effectué. Solde restant: " + solde);
  }

  public static void main(String[] args) throws RetraitException {
    Banque banque = new Banque(1000);
    banque.retrait(500);
    banque.retrait(600);
  }

}

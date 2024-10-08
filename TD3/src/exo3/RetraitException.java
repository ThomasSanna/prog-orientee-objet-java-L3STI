package exo3;

public class RetraitException extends Exception {

  private static final String MESSAGE_ERREUR = "Erreur: Problème lors du retrait.\n";

  public RetraitException (String message) {
    super(MESSAGE_ERREUR + message);
  }

  public RetraitException(){
    super(MESSAGE_ERREUR);
    this.printStackTrace();
  }
}

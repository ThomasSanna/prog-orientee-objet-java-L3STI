package exo2;

public class ValeurNegativeException extends Exception {
  private static final String MESSAGE_ERREUR = "Erreur: La valeur est négative.\n";

  public ValeurNegativeException(String message) {
    super(MESSAGE_ERREUR + message);
  }

  public ValeurNegativeException() {
    super(MESSAGE_ERREUR);
  }

}

package exo2;


public class Racine {

  public static double calculer(double a) throws ValeurNegativeException {
    if (a < 0) {
      throw new ValeurNegativeException("La racine carrée d'un nombre négatif n'est pas définie.");
    }
    return Math.sqrt(a);
  }

  public static void main(String[] args) {
    try {
      double a = -1;
      double racine = calculer(a);
      System.out.println("La racine carrée de " + a + " est " + racine);
    } catch (ValeurNegativeException e) {
      System.out.println(e.getMessage());
    }

    try {
      double a = 5;
      double racine = calculer(a);
      System.out.println("La racine carrée de " + a + " est " + racine);
    } catch (ValeurNegativeException e) {
      System.out.println(e.getMessage());
    }
  }

}

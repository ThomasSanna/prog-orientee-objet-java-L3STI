package exo3;

public class CalculatriceReel extends Affichage implements Operation {

  @Override
  public Object addition(Object a, Object b) {
    return (double) a + (double) b;
  }

  @Override
  public Object soustraction(Object a, Object b) {
    return (double) a - (double) b;
  }

  @Override
  public Object multiplication(Object a, Object b) {
    return (double) a * (double) b;
  }

  @Override
  public Object division(Object a, Object b) {
    return (double) a / (double) b;
  }

  @Override
  public void afficher(Object obj) {
    System.out.println(obj);
  }

  public static void main(String[] args) {
    CalculatriceReel calcReel = new CalculatriceReel();
    calcReel.afficher(calcReel.addition(1.05, 2.2));
    calcReel.afficher(calcReel.soustraction(1.3, 2.5));
    calcReel.afficher(calcReel.multiplication(1.2, 2.2));
    calcReel.afficher(calcReel.division(1.0, 2.0));
  }

}

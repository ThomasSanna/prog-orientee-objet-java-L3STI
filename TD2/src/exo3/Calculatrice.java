package exo3;

public class Calculatrice extends Affichage implements Operation {

  @Override
  public Object addition(Object a, Object b) {
    return (int) a + (int) b;
  }

  @Override
  public Object soustraction(Object a, Object b) {
    return (int) a - (int) b;
  }

  @Override
  public Object multiplication(Object a, Object b) {
    return (int) a * (int) b;
  }

  @Override
  public Object division(Object a, Object b) {
    return (int) a / (int) b;
  }

  @Override
  public void afficher(Object obj) {
    System.out.println(obj);
  }

  public static void main(String[] args) {
    Calculatrice calc = new Calculatrice();
    calc.afficher(calc.addition(1, 2));
    calc.afficher(calc.soustraction(1, 2));
    calc.afficher(calc.multiplication(1, 2));
    calc.afficher(calc.division(1, 2));
  }

}

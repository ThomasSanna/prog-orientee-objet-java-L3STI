package exo4;

public class Ducks {

  private Object riri;
  private Object fifi;
  private Object loulou; // NB : riri fifi et loulou doivent être de même type !!!!

  public Ducks(Object riri, Object fifi, Object loulou) throws IllegalArgumentException {
    if (riri.getClass() != fifi.getClass() || riri.getClass() != loulou.getClass()) {
      throw new IllegalArgumentException("Les objets doivent être du même type.");
    }
    this.riri = riri;
    this.fifi = fifi;
    this.loulou = loulou;
  }

  public Object getRiri(){
    return riri;
  }

  public Object getFifi() {
    return fifi;
  }

  public Object getLoulou() {
    return loulou;
  }

public void affiche() {
  System.out.println("Riri: " + riri + ", Fifi: " + fifi + ", Loulou: " + loulou);
}

public static void main(String[] args) {
  Ducks ducks1 = new Ducks(1, 2, 3);
  ducks1.affiche();

  Ducks ducks2 = new Ducks("Riri", "Fifi", "Loulou");
  ducks2.affiche();

  Ducks ducks3 = new Ducks(1, "Fifi", 3.14);
  ducks3.affiche();
}

}
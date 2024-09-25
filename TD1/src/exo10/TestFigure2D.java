package exo10;

public class TestFigure2D {
  public static void main(String[] args) {
    Rectangle r1 = new Rectangle(1.0, 2.0);
    Carre car1 = new Carre(5.0);
    Cercle ce1 = new Cercle(1);

    System.out.println("Rectangle Aire : " + r1.getAire() + ", Perimetre : " + r1.getPerimetre());
    System.out.println("Carre Aire : " + car1.getAire() + ", Perimetre : " + car1.getPerimetre());
    System.out.println("Cercle Aire : " + ce1.getAire() + ", Perimetre : " + ce1.getPerimetre());

  }
}

package exo3;

public class Cercle {
  private double rayon;

  public Cercle(double rayon){
    this.rayon = rayon;
  }

  public double getPerimetre(){
    return 2 * Math.PI * this.rayon;
  }

  public double getAire(){
    return Math.PI * Math.pow(this.rayon, 2);
  }
}

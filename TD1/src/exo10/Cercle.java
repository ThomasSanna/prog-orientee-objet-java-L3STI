package exo10;

public class Cercle extends Figure2D{

  private double rayon;

  public Cercle(double rayon){
    this.rayon = rayon;
  }

  public double getPerimetre(){
    return 2*Math.PI*rayon;
  }

  public double getAire(){
    return Math.PI * Math.pow(rayon, 2);
  }

}

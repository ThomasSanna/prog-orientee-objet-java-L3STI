package exo10;

public class Rectangle extends Figure2D {

  private double longueur;
  private double largeur;

  public Rectangle(double longueur, double largeur){
    this.longueur = longueur;
    this.largeur = largeur;
  }

  public double getPerimetre(){
    return this.longueur * 2 +  this.largeur * 2;
  }

  public double getAire(){
    return this.longueur * this.largeur;
  }

}

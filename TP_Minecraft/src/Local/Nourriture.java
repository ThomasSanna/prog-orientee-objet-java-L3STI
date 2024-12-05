package Local;
public class Nourriture extends Item {
  private int restaurationPV;

  public Nourriture(String nom, int restaurationPV) {
    super(nom, "Nourriture", 0);
    this.restaurationPV = restaurationPV;
  }

  public int getRestaurationPV() {
    return restaurationPV;
  }
}

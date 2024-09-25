package exo7;

public class ConvertisseurTemperature {

  public static double farToCel(double tempFar){
    return (tempFar - 32) * ((double) 5 / 9);
  }

  public static double celToFar(double tempCel){
    return ((double) 9 / 5) * tempCel + 32;
  }

  public static void main(String[] args) {
    System.out.println(ConvertisseurTemperature.farToCel(120.02));
    System.out.println(ConvertisseurTemperature.celToFar(48.9));
  }

}

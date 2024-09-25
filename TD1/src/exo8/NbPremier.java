package exo8;

public class NbPremier {

  public static boolean estPremier(int n) {
    if (n < 2) {
      return false;
    }
    for (int i = 2; i <= n / 2; i++) {
      if (n % i == 0) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    for (int i = 0; i < 100; i++) {
      if (estPremier(i)) {
        System.out.println(i + " est un nombre premier");
      }
    }
  }

}

package exo1;


public class Additionner {

  public static int addition(int a, int b) {
      return a + b;
  }

  public static int addition2(int[] tab) {
    int res = 0;
    for (int i = 0; i < tab.length; i++) {
      res += tab[i];
    } 
    return res;
  }

}

package exo5;

public class InverserChaine {

  public static String inverserChaineCar(String ch){
    String resCh = "";
    for(int i = ch.length()-1; i>=0; i--){
      resCh += ch.charAt(i);
    }
    return resCh;
  }

  public static void main(String[] args) {
    System.out.println(InverserChaine.inverserChaineCar("Bonjour comment va-t-on ?"));
  }
}

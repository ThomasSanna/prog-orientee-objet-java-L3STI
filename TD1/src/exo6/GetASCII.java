package exo6;

public class GetASCII {

  public static int getAscii(char caractere){
    return (int) caractere; // convertis automatiquement le caractere à sa valeure ASCII 
  }

  public static void main(String[] args) {
    System.out.println("La valeur ASCII de 'e' est : " + GetASCII.getAscii('e'));
  }
}

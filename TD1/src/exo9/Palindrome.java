package exo9;

public class Palindrome {

  public static boolean estPalindrome(String str){
    if (str.length() % 2 == 0){
      return false;
    } else {
      int longueurStr = str.length();
      for(int i = 0 ; i < longueurStr/2 ; i++){
        if(str.charAt(i) != str.charAt(longueurStr-i-1)){
          return false;
        }
      }
      return true;
    }
  }

  public static void main(String[] args) {
    System.out.println(Palindrome.estPalindrome("kayak")); // true
    System.out.println(Palindrome.estPalindrome("jdfhri")); // false
  }

}

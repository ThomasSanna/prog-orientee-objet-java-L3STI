package exo4;

public class Moyenne {

  public static double moyenneTab(int[] tab){
    int somme = 0;
    int longueurTab = tab.length;
    for (int i = 0; i<longueurTab; i++){
      somme += tab[i];
    }
    return (double) somme / longueurTab;
  }


  public static void main(String[] args) {
    System.out.println(Moyenne.moyenneTab(new int[] {2, 1}));

  }

}

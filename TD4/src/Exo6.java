import java.util.*;

public class Exo6 {
  public static void main(String[] args) {
    String phrase = "C'est une époque de guerre civile. A bord de vaisseaux spatiaux opérant à partir d'une base cachée, les Rebelles ont emporté leur première victoire sur le maléfique Empire Galactique";
    List<String> words = Arrays.asList(phrase.split(" "));

    // Sort alphabetically
    Collections.sort(words, new AlphabeticalComparator());
    System.out.println("Alphabetical Order: " + words);

    // Sort by military order
    Collections.sort(words, new MilitaryComparator());
    System.out.println("Military Order: " + words);

    // Sort in reverse alphabetical order
    Collections.sort(words, new ReverseAlphabeticalComparator());
    System.out.println("Reverse Alphabetical Order: " + words);
  }

  static class AlphabeticalComparator implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
      return o1.compareTo(o2);
    }
  }

  static class MilitaryComparator implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
      int lengthComparison = Integer.compare(o1.length(), o2.length());
      if (lengthComparison != 0) {
        return lengthComparison;
      }
      return o1.compareTo(o2);
    }
  }

  static class ReverseAlphabeticalComparator implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
      return o2.compareTo(o1);
    }
  }
}

import java.util.TreeSet;

public class Exo4 {
  
  public static void main(String[] args) {
    TreeSet<Integer> treeSet = new TreeSet<>();
    while (treeSet.size() < 1000) {
      int randomInt = (int) (Math.random() * 10);
      treeSet.add(randomInt);
    }
    System.out.println(treeSet);
    // the TreeSet will not reach a size of 1000 because it only stores unique elements, and the random integers generated are between 0 and 9.
  }

}

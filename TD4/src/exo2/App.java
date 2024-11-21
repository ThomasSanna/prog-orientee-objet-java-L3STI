package exo2;

import java.util.ArrayList;

public class App {

  public static ArrayList<Integer> createArray() {
    ArrayList<Integer> lst = new ArrayList<Integer>();
    for (int i = 0; i < 100; i++) {
      lst.add((int) (Math.random() * 1000));
    }
    return lst;
  }

  public static ArrayList<Integer> quickSort(ArrayList<Integer> lst) {
    if (lst.size() <= 1) {
      return lst;
    }
    int pivot = lst.get(0);
    ArrayList<Integer> less = new ArrayList<Integer>();
    ArrayList<Integer> greater = new ArrayList<Integer>();
    for (int i = 1; i < lst.size(); i++) {
      if (lst.get(i) <= pivot) {
        less.add(lst.get(i));
      } else {
        greater.add(lst.get(i));
      }
    }
    ArrayList<Integer> sorted = new ArrayList<Integer>();
    sorted.addAll(quickSort(less));
    sorted.add(pivot);
    sorted.addAll(quickSort(greater));
    return sorted;
    
  }

  public static void main(String[] args) {
    ArrayList<Integer> lst = createArray();
    System.out.println(lst);
    System.out.println(quickSort(lst));
  }

}

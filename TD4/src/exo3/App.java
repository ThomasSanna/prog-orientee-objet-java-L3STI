
package exo3;

import java.util.PriorityQueue;
import java.util.Random;

public class App {

  public static void main(String[] args) {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    Random rand = new Random();

    for (int i = 0; i < 100; i++) {
      pq.add(rand.nextInt(1001));
    }

    System.out.println("PriorityQueue:");
    System.out.println(pq);

    while (!pq.isEmpty()) {
      System.out.println(pq.poll());
    }
  }
  
}

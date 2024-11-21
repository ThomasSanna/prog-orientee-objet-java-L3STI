public class exo6 extends Thread {

  public void run() {
    try {
      int sleepTime = (int) (Math.random() * 10000);
      Thread.sleep(sleepTime); 
      System.out.println("Processus " + Thread.currentThread().getName() + " executé en " + sleepTime + " millisecondes.");
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    for (int i = 0; i < 10; i++) {
      exo6 processus = new exo6();
      processus.start();
    }
  }
}

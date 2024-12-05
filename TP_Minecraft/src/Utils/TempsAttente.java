package Utils;

public class TempsAttente {
    public static void attendre(int temps) {
        try {
            Thread.sleep(temps);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

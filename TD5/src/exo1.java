import java.io.FileReader;
import java.io.IOException;

public class exo1 {
  public static void main(String[] args) {
    String filePath = "texte.txt";
    try (FileReader fr = new FileReader(filePath)) {
      int i;
      while ((i = fr.read()) != -1) {
        System.out.print((char) i);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

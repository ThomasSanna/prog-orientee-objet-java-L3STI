import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class exo3 {
  public static void main(String[] args) {
    String filePath = "longtext.txt";

    // Measure time for java.io
    long startTimeIO = System.currentTimeMillis();

    try (FileReader fr = new FileReader(filePath)) {
      int i;
      while ((i = fr.read()) != -1) {
        // Rien à faire
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

    long endTimeIO = System.currentTimeMillis();
    System.out.println("Temps java.io: " + (endTimeIO - startTimeIO) + " ms");

    // Measure time for java.nio
    long startTimeNIO = System.currentTimeMillis();

    try {
      Files.lines(Paths.get(filePath)).forEach(line -> {
        // Rien à faire
      });
    } catch (IOException e) {
      e.printStackTrace();
    }

    long endTimeNIO = System.currentTimeMillis();
    System.out.println("Temps java.nio: " + (endTimeNIO - startTimeNIO) + " ms");
  }
}
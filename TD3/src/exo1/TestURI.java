package exo1;

import java.net.URI;
import java.net.URISyntaxException;

public class TestURI {

  public static void main(String[] args) {
    String uriStr = "https://www.baeldung.com/ java-%%$^&& iuyi";
    try {
      URI uri = new URI(uriStr);
      System.out.println("URI: " + uri + " est valide.");
    } catch (URISyntaxException e) {
      System.out.println("URI: " + uriStr + " n'est pas valide.");
    }
  }

}

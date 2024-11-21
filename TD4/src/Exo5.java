import java.util.HashMap;

public class Exo5 {
  public static void main(String[] args) {
    HashMap<String, Integer> etudiants = new HashMap<>();

    etudiants.put("BUTEAU LUCIA", 20191218);
    etudiants.put("CASTELLI SERENA", 20190628);
    etudiants.put("JOND JEAN", 20190556);
    etudiants.put("LEFEVRE JULIEN", 20192688);
    etudiants.put("MARIACCIA MARIE-DOMINIQUE", 20190628);
    etudiants.put("MORETTI PIERRE-FRANCOIS", 20190707);

    System.out.println(etudiants);

    // Une HashMap en Java ne maintient aucun ordre de ses entrées. 
    // Elle utilise une table de hachage pour stocker les entrées de la carte, 
    // ce qui signifie que l'ordre des clés est déterminé par les 
    // codes de hachage des clés et la structure interne de la table de hachage. 
    // Cela peut entraîner l'apparition des entrées dans un ordre apparemment aléatoire
    // lors de l'impression.
  }
}
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Exo7 {
  public static void main(String[] args) {
    List<Personne> personnes = new ArrayList<>();
    personnes.add(new Personne("Dupont", "Jean", 25));
    personnes.add(new Personne("Martin", "Alice", 30));
    personnes.add(new Personne("Dupont", "Marie", 25));
    personnes.add(new Personne("Martin", "Bob", 20));

    Collections.sort(personnes);

    for (Personne p : personnes) {
      System.out.println(p);
    }
  }
}

class Personne implements Comparable<Personne> {
  private String nom;
  private String prenom;
  private int age;

  public Personne(String nom, String prenom, int age) {
    this.nom = nom;
    this.prenom = prenom;
    this.age = age;
  }

  public String getNom() {
    return nom;
  }

  public String getPrenom() {
    return prenom;
  }

  public int getAge() {
    return age;
  }

  @Override
  public int compareTo(Personne other) {
    if (this.age != other.age) {
      return Integer.compare(this.age, other.age);
    }
    int nomComparison = this.nom.compareTo(other.nom);
    if (nomComparison != 0) {
      return nomComparison;
    }
    return this.prenom.compareTo(other.prenom);
  }

  @Override
  public String toString() {
    return "Personne{" +
        "nom='" + nom + '\'' +
        ", prenom='" + prenom + '\'' +
        ", age=" + age +
        '}';
  }
}
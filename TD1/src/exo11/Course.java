package exo11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Course {

  private String nomCourse;
  private char typeCourse;
  private ArrayList<Voiture> listeParticipants;
  private Map<Voiture, Integer> classementGeneral;
  private static final char[] typeCourseAcceptes = {'a', 'n', 'r'};

  public Course(String nomCourse, char typeCourse) throws Exception {
    boolean typeValide = false;
    for(char type : typeCourseAcceptes){
      if(type == typeCourse){
        typeValide = true;
        break;
      }
    }
    if(!typeValide){
      throw new Exception("Erreur : le type de course indiqué est invalide.");
    }
    this.nomCourse = nomCourse;
    this.typeCourse = typeCourse;
    this.listeParticipants = new ArrayList<Voiture>();
    this.classementGeneral = new HashMap<>();
  }

  public void addParticipant(Voiture participant){
    if(participant.getTypeVoiture() != typeCourse){
      System.out.println("Erreur : La voiture n'est pas du type " + typeCourse + ".");
    } else if(listeParticipants.contains(participant)) {
      System.out.println("Erreur : La voiture participe déjà à la course " + nomCourse + ".");
    } else {
      listeParticipants.add(participant);
      classementGeneral.put(participant, 0);
      System.out.println("Le participant a bien été enregistré dans la course " + nomCourse + ".");
    }
  }

  public void enregistrerTemps(Voiture participant, int temps){
    if(classementGeneral.containsKey(participant)){
      int tempsTotal = classementGeneral.get(participant) + temps;
      classementGeneral.put(participant, tempsTotal);
    } else {
      System.out.println("Erreur : La voiture ne participe pas à la course " + nomCourse + ".");
    }
  }

  public void afficherClassement(){
    System.out.println("Classement général de la course " + nomCourse + " :");
    classementGeneral.entrySet().stream()
      .sorted(Map.Entry.comparingByValue())
      .forEach(entry -> System.out.println(entry.getKey().getMonPilote().getNom() + " - " + entry.getValue() + " secondes"));
  }
}
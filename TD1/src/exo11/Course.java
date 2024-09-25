package exo11;

import java.util.ArrayList;

public class Course {

  private String nomCourse;
  private char typeCourse;
  private ArrayList<Voiture> listeParticipants;
  private static final char[] typeCourseAcceptes = {'a', 'n', 'r'};

  public Course(String nomCourse, char typeCourse){
    for(char type : typeCourseAcceptes){
      if(type != typeCourse){
        throw new Exception("Erreur : le type de course indiqué est invalide.")
      }
    }
    this.nomCourse = nomCourse;
    this.typeCourse = typeCourse;
    this.listeParticipants = new ArrayList<Voiture>();
  }

  public void addParticipant(Voiture participant){
    if(participant.getTypeVoiture() != typeCourse){
      System.out.println("Erreur : La voiture n'est pas du type " + typeCourse + ".");
    } else if(listeParticipants.contains(participant)) {
      System.out.println("Erreur : La voiture participe déjà à la course " + nomCourse + ".");
    } else {
      listeParticipants.add(participant);
      System.out.println("Le participant a bien été enregistré dans la course " + nomCourse + ".");
    }
  }


}

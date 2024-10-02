package exo11;

import java.time.LocalDate;

public class TestCourse {
  public static void main(String[] args) {
    try {
      // Create instances of Voiture, Pilote, and Copilote
      Pilote pilote1 = new Pilote("Jean", LocalDate.of(1985, 5, 20), "A+", null);
      Copilote copilote1 = new Copilote("Pierre", LocalDate.of(1987, 8, 15), "B+", null);
      Voiture voiture1 = new Voiture('a', pilote1, copilote1);

      Pilote pilote2 = new Pilote("Marie", LocalDate.of(1990, 3, 10), "O-", null);
      Copilote copilote2 = new Copilote("Luc", LocalDate.of(1992, 11, 25), "AB+", null);
      Voiture voiture2 = new Voiture('a', pilote2, copilote2);

      // Create a Course
      Course course = new Course("Grand Prix", 'a');

      // Add participants
      course.addParticipant(voiture1);
      course.addParticipant(voiture2);

      // Record times
      course.enregistrerTemps(voiture1, 120);
      course.enregistrerTemps(voiture2, 130);
      course.enregistrerTemps(voiture1, 110);
      course.enregistrerTemps(voiture2, 115);

      // Display rankings
      course.afficherClassement();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
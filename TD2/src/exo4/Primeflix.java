package exo4;
import java.util.ArrayList;
import java.util.List;

class Primeflix {
  List<Utilisateur> utilisateurs = new ArrayList<>();
  List<Film> films = new ArrayList<>();
  List<Serie> series = new ArrayList<>();
  double tarifVisionnage = 0.50;
  double tarifPremium = 0.90;

  public void ajouterUtilisateur(Utilisateur utilisateur) {
      utilisateurs.add(utilisateur);
  }

  public double calculerFraisVisionnage(Utilisateur utilisateur, double duree, boolean premium) {
      return premium ? duree * tarifPremium : duree * tarifVisionnage;
  }

  public void redistribuerRevenus(Film film, double duree) {
      // Implementation here
  }

  public void redistribuerRevenus(Serie serie, double duree) {
      // Implementation here
  }
}
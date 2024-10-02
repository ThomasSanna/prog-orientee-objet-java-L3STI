import java.util.List;
import java.util.ArrayList;

class Playlist {
  private int id;
  private String nom;
  private List<Object> videos = new ArrayList<>();

  public Playlist(String nom) {
      this.nom = nom;
  }

  public void ajouterVideo(Object video) {
      videos.add(video);
  }

  public void afficherPlaylist() {
      System.out.println("Playlist: " + nom);
      for (Object video : videos) {
          if (video instanceof Film) {
              ((Film) video).afficherDetails();
          } else if (video instanceof Serie) {
              ((Serie) video).afficherDetails();
          }
      }
  }

  // Getters and Setters
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public List<Object> getVideos() {
    return videos;
  }

  public void setVideos(List<Object> videos) {
    this.videos = videos;
  }
}
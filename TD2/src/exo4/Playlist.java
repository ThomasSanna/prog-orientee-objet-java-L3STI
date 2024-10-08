package exo4;

import java.util.ArrayList;
import java.util.List;

class Playlist implements CollectionDeVideos {
  private int id;
  private String nom;
  private List<Video> videos = new ArrayList<>();

  public Playlist(String nom) {
      this.nom = nom;
  }

  @Override
  public void ajouterVideo(Video video) {
      videos.add(video);
  }

  @Override
  public void afficherDetails() {
      System.out.println("Playlist: " + nom);
      for (Video video : videos) {
          video.afficherDetails();
      }
  }

  @Override
  public List<Video> getVideos() {
      return videos;
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

  public void setVideos(List<Video> videos) {
    this.videos = videos;
  }
}
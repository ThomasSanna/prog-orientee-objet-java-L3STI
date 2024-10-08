package exo4;

import java.util.List;

public interface CollectionDeVideos {
    void ajouterVideo(Video video);
    void afficherDetails();
    List<Video> getVideos();
}
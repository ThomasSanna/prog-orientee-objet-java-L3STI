package Local;
import java.io.Serializable;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import Utils.*;
import java.util.Scanner;
import Multijoueur.*;

public class Joueur implements Serializable{
    private String nom;
    private int pointsVie;
    private int pointsDefense;
    private int pointsAttaque;
    protected List<Item> inventaire;
    protected Arme arme;
    protected Armure armure;
    private transient Scanner scanner;
    private static final double TAUX_RENCONTRE_MONSTRE = 0.05;
    private static final double TAUX_RENCONTRE_MONSTRE_AVANCE = 0.3;

    public Joueur(String nom, int pointsVie, int pointsDefense, int pointsAttaque) {
        this.nom = nom;
        this.pointsVie = pointsVie;
        this.pointsDefense = pointsDefense;
        this.pointsAttaque = pointsAttaque;
        this.inventaire = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public void afficherMenu() {
        while (true) {
            EffacerConsole.clear();
            System.out.println("\nMenu:");
            System.out.println("1. Rejoindre la ferme");
            System.out.println("2. Crafter");
            System.out.println("3. Rejoindre un serveur PvP");
            System.out.println("4. Consommer de la nourriture");
            System.out.println("5. Afficher l'inventaire");
            System.out.println("6. Quitter le jeu");
            System.out.print("Choisissez une option: ");
            int choix = scanner.nextInt();
            scanner.nextLine();
    
            switch (choix) {
                case 6:
                    System.out.println("Vous avez quitté le jeu.");
                    return;
                case 1:
                    rejoindreFarm();
                    break;
                case 2:
                    crafter();
                    break;
                case 3:
                    rejoindrePVP();
                    break;
                case 4:
                    consommerNourriture();
                    break;
                case 5:
                    afficherInventaire();
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
            }
        }
    }

    public void rejoindreFarm() {
        EffacerConsole.clear();
        System.out.println(nom + " rejoint la ferme !");
        TempsAttente.attendre(700);
        while (true) {
            EffacerConsole.clear();
            double rand = Math.random();
            Boolean armeEtArmureEquipe = this.armure != null && this.arme != null;
            if ((!armeEtArmureEquipe && rand < TAUX_RENCONTRE_MONSTRE) || (armeEtArmureEquipe && rand < TAUX_RENCONTRE_MONSTRE_AVANCE)) { // P
                // RENCONTRE MONSTRE (5% ou 30% selon l'avancé du personnage) ----------------
                Monstre monstre = choisirMonstreAleatoire(GameData.getMonstres()).clone(); // on clone le monstre pour éviter de modifier l'original
                System.out.println("Vous rencontrez un " + monstre.getNom() + " !");
                System.out.println(monstre);
                int numSortie = combattre(monstre);
                if (numSortie == 0) {
                    return;
                }
            } else {
                // RENCONTRE BLOC (95% ou 70% selon l'avancé du personnage) ----------------
                Bloc bloc = choisirBlocAleatoire(GameData.getBlocs());
                System.out.println("Vous trouvez un bloc de " + bloc.getNom() + ".");
                TempsAttente.attendre(700);
                int tempsCasse = bloc.getTempsCasse();
                for (int i = 0; i < tempsCasse; i += 1000) {
                    System.out.println("Cassage du bloc... (" + (tempsCasse - i) / 1000 + " secondes restantes)");
                    TempsAttente.attendre(100); // RECHANGER A 500
                }
                ajouterItemInventaire(bloc.recuperer());
                TempsAttente.attendre(700);
                System.out.print("Voulez-vous continuer ? (1: Oui, 2: Non): ");
                int choix = scanner.nextInt();
                scanner.nextLine();
                if (choix == 2) {
                    return;
                }
            }
        }
    }

    private Monstre choisirMonstreAleatoire(List<Monstre> monstres) {
        double sommePoids = 0.0;
        for (Monstre monstre : monstres) {
            sommePoids += monstre.getTauxApparition();
        }

        double valeurAleatoire = Math.random() * sommePoids;
        double sommeCumulative = 0.0;
        for (Monstre monstre : monstres) {
            sommeCumulative += monstre.getTauxApparition();
            if (valeurAleatoire <= sommeCumulative) {
                return monstre;
            }
        }

        throw new RuntimeException("Erreur dans la sélection aléatoire pondérée.");
    }

    private Bloc choisirBlocAleatoire(List<Bloc> blocs) {
        double sommePoids = 0.0;
        for (Bloc bloc : blocs) {
            sommePoids += bloc.getTauxApparition();
        }

        double valeurAleatoire = Math.random() * sommePoids;
        double sommeCumulative = 0.0;
        for (Bloc bloc : blocs) {
            sommeCumulative += bloc.getTauxApparition();
            if (valeurAleatoire <= sommeCumulative) {
                return bloc;
            }
        }

        throw new RuntimeException("Erreur dans la sélection aléatoire pondérée.");
    }

    public void afficherRecettes() {
        EffacerConsole.clear();
        System.out.println("Recettes disponibles :");
        int index = 1;
        for (Map.Entry<List<Item>, Item> recette : GameData.getRecettes().entrySet()) {
            System.out.print(index + ". ");
            System.out.print(recette.getValue().getNom() + "-> ");
            for (Item item : recette.getKey()) {
                System.out.print(item.getNom() + " ");
            }
            System.out.println();
            index++;
        }
    }
    

    public void crafter() {
        afficherRecettes();
        TempsAttente.attendre(700);
        System.out.print("Choisissez une recette à crafter (0 pour annuler) : ");
        int choix = scanner.nextInt();
        scanner.nextLine();
    
        if (choix == 0) {
            return;
        }
    
        List<Map.Entry<List<Item>, Item>> recettes = new ArrayList<>(GameData.getRecettes().entrySet());
        if (choix > 0 && choix <= recettes.size()) {
            Map.Entry<List<Item>, Item> recetteChoisie = recettes.get(choix - 1);
            if (possedeItemsPourRecette(recetteChoisie.getKey())) {
                consommerItemsPourRecette(recetteChoisie.getKey());
                Item itemCrafted = recetteChoisie.getValue();                
                System.out.println("Vous avez crafté un(e) " + recetteChoisie.getValue().getNom() + " !");
                TempsAttente.attendre(700);
                if (itemCrafted instanceof Arme) {
                    equiperArme((Arme) itemCrafted);
                } else if (itemCrafted instanceof Armure) {
                    equiperArmure((Armure) itemCrafted);
                } else {
                    ajouterItemInventaire(itemCrafted);
                }
                TempsAttente.attendre(1200);
            } else {
                System.out.println("Vous n'avez pas les items nécessaires pour cette recette.");
                TempsAttente.attendre(1200);
            }
        } else {
            System.out.println("Choix invalide.");
            TempsAttente.attendre(1000);
        }
    }
    
    private boolean possedeItemsPourRecette(List<Item> itemsRecette) {
        for (Item itemRecette : itemsRecette) {
            boolean trouve = false;
            for (Item itemInventaire : inventaire) {
                if (itemInventaire.getNom().equals(itemRecette.getNom()) && itemInventaire.getQuantite() >= itemRecette.getQuantite()) {
                    trouve = true;
                    break;
                }
            }
            if (!trouve) {
                return false;
            }
        }
        return true;
    }
    
    private void consommerItemsPourRecette(List<Item> itemsRecette) {
        for (Item itemRecette : itemsRecette) {
            itemRecette.removeQuantite(1);
        }
    }

    public void manger(Nourriture nourriture) {
        pointsVie += nourriture.getRestaurationPV();
        System.out.println(
                nom + " mange " + nourriture.getNom() + " et restaure " + nourriture.getRestaurationPV() + " PV.");
    }

    public void consommerNourriture() {
        EffacerConsole.clear();
        System.out.println("Nourritures possédées :");
        List<Nourriture> nourritures = new ArrayList<>();
        for (Item item : inventaire) {
            if (item instanceof Nourriture) {
                nourritures.add((Nourriture) item);
            }
        }

        for (int i = 0; i < nourritures.size(); i++) {
            Nourriture nourriture = nourritures.get(i);
            System.out.println((i + 1) + ". " + nourriture.getNom() + " (Quantité : " + nourriture.getQuantite() + ")");
        }

        TempsAttente.attendre(700);

        System.out.print("Choisissez un item à manger (0 pour annuler): ");
        int choix = scanner.nextInt();
        scanner.nextLine();

        if (choix > 0 && choix <= nourritures.size()) {
            Nourriture nourriture = nourritures.get(choix - 1);
            manger(nourriture);
            inventaire.remove(nourriture);
        } else if (choix != 0) {
            System.out.println("Choix invalide.");
        }
    }

    public void equiperArme(Arme arme) {
        if (this.arme != null && this.arme.getRarete() > arme.getRarete()) {
            System.out.println("Vous avez déjà une arme de meilleure qualité.");
        } else {
            this.arme = arme;
            System.out.println("Vous avez équipé " + arme.getNom() + ".");
        }
    }

    public void equiperArmure(Armure armure) {
        if (this.armure != null && this.armure.getRarete() > armure.getRarete()) {
            System.out.println("Vous avez déjà une armure de meilleure qualité.");
        } else {
            this.armure = armure;
            System.out.println("Vous avez équipé " + armure.getNom() + ".");
        }
    }

    public int combattre(Monstre monstre) {
        while (pointsVie > 0 && monstre.getPointsVie() > 0) {
            System.out.println("\nQue voulez-vous faire ?");
            System.out.println("1. Attaquer");
            System.out.println("2. Fuir");
            System.out.print("Choisissez une option: ");
            int choix = scanner.nextInt();
            scanner.nextLine();
            EffacerConsole.clear();

            if (choix == 1) {
                // Attaque du joueur
                System.out.println("Vous attaquez le " + monstre.getNom() + " !");
                TempsAttente.attendre(700);
                int degatsJoueur = pointsAttaque + (arme != null ? arme.getBonusAttaque() : 0);
                monstre.recevoirDegats(degatsJoueur);
                TempsAttente.attendre(700);

                // Attaque du monstre
                if (monstre.getPointsVie() > 0) {
                    monstre.attaquer(this);
                    TempsAttente.attendre(700);
                }
            } else if (choix == 2) {
                System.out.println("Vous avez fui le combat.");
                return 0;
            } else {
                System.out.println("Choix invalide. Veuillez réessayer.");
            }
        }

        if (pointsVie <= 0) {
            System.out.println("Vous êtes mort.");
            pointsVie = 20;
            return 1;
        } else if (monstre.getPointsVie() <= 0) {
            System.out.println("Vous avez vaincu le " + monstre.getNom() + " !");
            ajouterItemInventaire(monstre.getDrop());
            return 1;
        }
        return 0;
    }

    public void attaquer(Joueur autreJoueur) {
        int degats = pointsAttaque + (arme != null ? arme.getBonusAttaque() : 0);
        autreJoueur.recevoirDegats(degats);
        System.out.println(nom + " attaque " + autreJoueur.getNom() + " et inflige " + degats + " dégâts.");
    }

    public void afficherInventaire() {
        EffacerConsole.clear();
        System.out.println("\nInventaire de " + nom + " :");
        TempsAttente.attendre(700);
        for (Item item : inventaire) {
            if (item.getQuantite() <= 0) {
                continue;
            }
            System.out.println(item.getNom() + " (Quantité : " + item.getQuantite() + ")");
            TempsAttente.attendre(200);
        }
        TempsAttente.attendre(700);
        System.out.println("\nVos infos : ");
        TempsAttente.attendre(700);
        System.out.println("PV : " + pointsVie);
        TempsAttente.attendre(200);
        System.out.println("Attaque : " + pointsAttaque + " + " + (arme != null ? arme.getBonusAttaque() : 0));
        TempsAttente.attendre(200);
        System.out.println("Défense : " + (armure != null ? armure.getBonusDefense() : 0));
        TempsAttente.attendre(200);
        System.out.println("Arme équipée : " + (arme != null ? arme.getNom() : "Aucune"));
        TempsAttente.attendre(200);
        System.out.println("Armure équipée : " + (armure != null ? armure.getNom() : "Aucune"));
        TempsAttente.attendre(300);
        System.out.print("\nAppuyez sur Entrée pour continuer...");
        scanner.nextLine();
    }

    public void ajouterItemInventaire(Item item) {
        if (!inventaire.contains(item)) {
            inventaire.add(item);
        }
        System.out.println(nom + " a obtenu un(e) " + item.getNom() + ".");
    }

    public void recevoirDegats(int degats) {
        int degatsReels = Math.max(0, degats - (armure != null ? armure.getBonusDefense() : 0)); // si on a plus de défense que les dégâts, on ne prend pas de dégâts
        pointsVie -= (pointsVie - degatsReels < 0 ? pointsVie : degatsReels);
        if (degatsReels == 0) {
            System.out.println(nom + " a bloqué l'attaque avec ses beaux muscles rigides !");
        } else {
            System.out.println(nom + " a reçu " + degatsReels + " dégâts. PV restants : " + pointsVie);
        }
    }

    public void rejoindrePVP(){
        String serverName = "localhost";
        int port = 1234;
        try {
            Socket socket = new Socket(serverName, port);
            System.out.println("Connecté au serveur PvP !");
            Client client = new Client(this, socket);
            client.exec();
        } catch (Exception e) {
            System.out.println("Erreur lors de la connexion au serveur PvP.");
            e.printStackTrace();
        }
    }

    public int getPointsVie() {
        return pointsVie;
    }

    public String getNom() {
        return nom;
    }

    public int getPointsAttaque() {
        return pointsAttaque;
    }

    public int getPointsDefense() {
        return pointsDefense;
    }

    public Arme getArme() {
        return arme;
    }

    public void setArme(Arme arme) {
        this.arme = arme;
    }

    public Armure getArmure() {
        return armure;
    }

    public void setArmure(Armure armure) {
        this.armure = armure;
    }

    public List<Item> getInventaire() {
        return inventaire;
    }

    public void setInventaire(List<Item> inventaire) {
        this.inventaire = inventaire;
    }

    public Scanner getScanner(){
        return scanner;
    }

    public void setPointsVie(int pointsVie) {
        this.pointsVie = pointsVie;
    }

    public void setScanner(Scanner scanner){
        this.scanner = scanner;
    }

}
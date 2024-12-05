import java.util.ArrayList;
import java.util.List;
import Utils.*;
import java.util.Scanner;

public class Joueur {
    private String nom;
    private int pointsVie;
    private int pointsDefense;
    private int pointsAttaque;
    private List<Item> inventaire;
    private Arme arme;
    private Armure armure;
    private Scanner scanner;

    public Joueur(String nom, int pointsVie, int pointsDefense, int pointsAttaque) {
        this.nom = nom;
        this.pointsVie = pointsVie;
        this.pointsDefense = pointsDefense;
        this.pointsAttaque = pointsAttaque;
        this.inventaire = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public void rejoindreFarm() {
        EffacerConsole.clear();
        System.out.println(nom + " rejoint la ferme !");
        TempsAttente.attendre(1000);
        while (true) {
            double rand = Math.random();
            if (rand < 0.53) { // CHANCE A CHANGER POUR TESTER
                // RENCONTRE MONSTRE ----------------
                Monstre monstre = choisirMonstreAleatoire(GameData.getMonstres()).clone(); // on clone le monstre pour éviter de modifier l'original
                System.out.println("Vous rencontrez un " + monstre.getNom() + " !");
                System.out.println(monstre);
                int numSortie = combattre(monstre);
                if (numSortie == 0) {
                    return;
                }
            } else {
                // RENCONTRE BLOC ----------------
                Bloc bloc = choisirBlocAleatoire(GameData.getBlocs());
                System.out.println("Vous trouvez un bloc de " + bloc.getNom() + ".");
                TempsAttente.attendre(1000);
                int tempsCasse = bloc.getTempsCasse();
                for (int i = 0; i < tempsCasse; i += 1000) {
                    System.out.println("Cassage du bloc... (" + (tempsCasse - i) / 1000 + " secondes restantes)");
                    TempsAttente.attendre(1000);
                }
                ajouterItemInventaire(bloc.recuperer());
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

        // En théorie, ce point ne devrait jamais être atteint
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

        // En théorie, ce point ne devrait jamais être atteint
        throw new RuntimeException("Erreur dans la sélection aléatoire pondérée.");
    }

    public void rejoindrePVP() {
        System.out.println(nom + " rejoint un combat PvP !");
    }

    public void ajouterItemInventaire(Item item) {
        inventaire.add(item);
        System.out.println(nom + " a obtenu un(e) " + item.getNom() + ".");
    }

    public void recevoirDegats(int degats) {
        int degatsReels = Math.max(0, degats - pointsDefense);
        pointsVie -= degatsReels;
        System.out.println(nom + " a reçu " + degatsReels + " dégâts. PV restants : " + pointsVie);
    }

    public Item crafter(List<Item> items) {
        System.out.println(nom + " essaie de crafter un objet...");
        // Ajout de la logique de crafting ici
        return null;
    }

    public void manger(Nourriture nourriture) {
        pointsVie += nourriture.getRestaurationPV();
        System.out.println(
                nom + " mange " + nourriture.getNom() + " et restaure " + nourriture.getRestaurationPV() + " PV.");
    }

    public String getNom() {
        return nom;
    }

    public void afficherMenu() {
        EffacerConsole.clear();
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Quitter le jeu");
            System.out.println("2. Rejoindre la ferme");
            System.out.println("3. Crafter");
            System.out.println("4. Rejoindre un serveur PvP");
            System.out.println("5. Interagir avec l'inventaire (manger)");
            System.out.print("Choisissez une option: ");
            int choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                case 1:
                    System.out.println("Vous avez quitté le jeu.");
                    return;
                case 2:
                    rejoindreFarm();
                    break;
                case 3:
                    // Logique de crafting
                    System.out.println("Fonction de crafting non implémentée.");
                    break;
                case 4:
                    rejoindrePVP();
                    break;
                case 5:
                    interagirInventaire(scanner);
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
            }
        }
    }

    private void interagirInventaire(Scanner scanner) {
        System.out.println("Inventaire (Nourriture uniquement):");
        List<Nourriture> nourritures = new ArrayList<>();
        for (Item item : inventaire) {
            if (item instanceof Nourriture) {
                nourritures.add((Nourriture) item);
            }
        }

        for (int i = 0; i < nourritures.size(); i++) {
            Nourriture nourriture = nourritures.get(i);
            System.out.println((i + 1) + ". " + nourriture.getNom() + " (" + nourriture.getType() + ")");
        }

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
            System.out.println(" Vous avez équipé " + arme.getNom() + ".");
        }
    }

    public void equiperArmure(Armure armure) {
        if (this.armure != null && this.armure.getRarete() > armure.getRarete()) {
            System.out.println("Vous avez déjà une armure de meilleure qualité.");
        } else {
            this.armure = armure;
            System.out.println(" Vous avez équipé " + armure.getNom() + ".");
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
                TempsAttente.attendre(1000);
                int degatsJoueur = pointsAttaque + (arme != null ? arme.getBonusAttaque() : 0);
                monstre.recevoirDegats(degatsJoueur);
                TempsAttente.attendre(1000);

                // Attaque du monstre
                if (monstre.getPointsVie() > 0) {
                    monstre.attaquer(this);
                    TempsAttente.attendre(1000);
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
}
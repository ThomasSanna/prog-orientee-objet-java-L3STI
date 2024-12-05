package Local;
import java.util.*;

public class GameData {
    public static List<Item> items;
    public static List<Bloc> blocs;
    public static List<Monstre> monstres;
    public static Map<List<Item>, Item> recettes;

    static {
        initialiserItems();
        initialiserBlocs();
        initialiserMonstres();
        initialiserRecettes();
    }

    private static void initialiserItems() {
        items = new ArrayList<>();
        items.add(new Item("Bois", "Matériau", 0));
        items.add(new Item("Pierre", "Matériau", 0));
        items.add(new Item("Fer", "Matériau", 0));
        items.add(new Item("Or", "Matériau", 0));
        items.add(new Item("Diamant", "Matériau", 0));
        items.add(new Nourriture("Pomme", 5)); // Restaure 5 PV
        items.add(new Arme("Epée en pierre", 5, 0)); // Rarete 0: Pierre
        items.add(new Arme("Epée en fer", 10, 1));   // Rarete 1: Fer
        items.add(new Arme("Epée en or", 15, 2));    // Rarete 2: Or
        items.add(new Arme("Epée en diamant", 20, 3)); // Rarete 3: Diamant
        items.add(new Armure("Armure en fer", 5, 1));
        items.add(new Armure("Armure en or", 10, 2));
        items.add(new Armure("Armure en diamant", 15, 3));
    }

    private static void initialiserBlocs() {
        blocs = new ArrayList<>();
        blocs.add(new Bloc("Bloc de bois", "Matériau", "Cassable", getItemParNom("Bois"), 0.5));
        blocs.add(new Bloc("Bloc de pierre", "Matériau", "Cassable", getItemParNom("Pierre"), 0.5));
        blocs.add(new Bloc("Branche d'arbre", "Chance", "Cassable", getItemParNom("Bois"), 0.5));
        blocs.add(new Bloc("Bloc de fer", "Matériau", "Cassable", getItemParNom("Fer"), 0.3, 5000));
        blocs.add(new Bloc("Bloc d'or", "Matériau", "Cassable", getItemParNom("Or"), 0.2, 7000));
        blocs.add(new Bloc("Bloc de diamant", "Matériau", "Cassable", getItemParNom("Diamant"), 0.1, 10000));
    }

    private static void initialiserMonstres() {
        monstres = new ArrayList<>();
        monstres.add(new Monstre("Zombie", 20, 5, getItemParNom("Fer"), 0.4));
        monstres.add(new Monstre("Squelette", 15, 7, getItemParNom("Fer"), 0.3));
        monstres.add(new Monstre("Creeper", 10, 30, getItemParNom("Or"), 0.2));
        monstres.add(new Monstre("Enderman", 40, 15, getItemParNom("Diamant"), 0.1));
    }

    private static void initialiserRecettes() {
        recettes = new HashMap<>();
        // Recette pour une épée en pierre : 2 pierres + 1 bois
        recettes.put(
            Arrays.asList(getItemParNom("Pierre"), getItemParNom("Pierre"), getItemParNom("Bois")),
            new Arme("Epée en pierre", 5, 0)
        );

        // Recette pour une épée en fer : 2 fers + 1 bois
        recettes.put(
            Arrays.asList(getItemParNom("Fer"), getItemParNom("Fer"), getItemParNom("Bois")),
            new Arme("Epée en fer", 10, 1)
        );

        // Recette pour une épée en or : 2 ors + 1 bois
        recettes.put(
            Arrays.asList(getItemParNom("Or"), getItemParNom("Or"), getItemParNom("Bois")),
            new Arme("Epée en or", 15, 2)
        );

        // Recette pour une épée en diamant : 2 diamants + 1 bois
        recettes.put(
            Arrays.asList(getItemParNom("Diamant"), getItemParNom("Diamant"), getItemParNom("Bois")),
            new Arme("Epée en diamant", 20, 3)
        );

        // Recette pour une armure en fer : 4 fers
        recettes.put(
            Arrays.asList(getItemParNom("Fer"), getItemParNom("Fer"), getItemParNom("Fer"),
                          getItemParNom("Fer")),
            new Armure("Armure en fer", 15, 1)
        );

        // Recette pour une armure en or : 4 ors
        recettes.put(
            Arrays.asList(getItemParNom("Or"), getItemParNom("Or"), getItemParNom("Or"),
              getItemParNom("Or")),
            new Armure("Armure en or", 10, 2)
        );

        // Recette pour une armure en diamant : 4 diamants
        recettes.put(
            Arrays.asList(getItemParNom("Diamant"), getItemParNom("Diamant"), getItemParNom("Diamant"),
              getItemParNom("Diamant")),
            new Armure("Armure en diamant", 15, 3)
        );

    }

    public static Item getItemParNom(String nom) {
        return items.stream().filter(item -> item.getNom().equals(nom)).findFirst().orElse(null);
    }

    public static Map<List<Item>, Item> getRecettes() {
        return recettes;
    }

    public static List<Item> getItems() {
        return items;
    }

    public static List<Bloc> getBlocs() {
        return blocs;
    }

    public static List<Monstre> getMonstres() {
        return monstres;
    }
}
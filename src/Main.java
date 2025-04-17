import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            // Charger la carte
            Carte carte = new Carte(
                    "Aventurier\\ressources\\carte.txt");
            carte.afficher(); // Optionnel : afficher la carte

            // Lire les déplacements
            String[] donnees = ProcesseurDeplacements.lireFichier(
                    "Aventurier\\ressources\\deplacements.txt");
            String[] coordonnees = donnees[0].split(",");
            int xDepart = Integer.parseInt(coordonnees[0]);
            int yDepart = Integer.parseInt(coordonnees[1]);
            String sequence = donnees[1];

            // Initialiser l'aventurier
            Aventurier aventurier = new Aventurier(xDepart, yDepart);

            // Exécuter les déplacements
            for (char direction : sequence.toCharArray()) {
                aventurier.deplacer(direction, carte);
            }

            // Afficher le résultat
            System.out.println("Position finale : " + aventurier.getPosition());

        } catch (IOException e) {
            System.err.println("Erreur de lecture des fichiers : " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Erreur : " + e.getMessage());
        }
    }
}
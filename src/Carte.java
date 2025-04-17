import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.io.IOException;
import java.util.List;

public class Carte {
    private char[][] grille;
    private int largeur;
    private int hauteur;

    public Carte(String cheminFichier) throws IOException {
        List<String> lignes = Files.readAllLines(Paths.get(cheminFichier), StandardCharsets.UTF_8);
        this.hauteur = lignes.size();
        this.largeur = lignes.stream().mapToInt(String::length).max().orElse(0);
        this.grille = new char[hauteur][largeur];

        for (int y = 0; y < hauteur; y++) {
            String ligne = lignes.get(y);
            for (int x = 0; x < largeur; x++) {
                grille[y][x] = (x < ligne.length()) ? ligne.charAt(x) : '#';
            }
        }
    }

    public boolean estPracticable(int x, int y) {
        return x >= 0 && x < largeur && y >= 0 && y < hauteur && grille[y][x] == ' ';
    }

    public void afficher() {
        for (char[] ligne : grille) {
            System.out.println(new String(ligne));
        }
    }
}
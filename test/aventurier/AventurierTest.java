package aventurier;



import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

public class AventurierTest {

  
    private void testerScenario(int x, int y, String mouvements, String attendu) throws IOException {
        Carte carte = new Carte("ressources/carte.txt");
        Aventurier aventurier = new Aventurier(x, y);

        for (char dir : mouvements.toCharArray()) {
            aventurier.deplacer(dir, carte);
        }

        String resultat = aventurier.getPosition();
        System.out.printf("Start: (%d,%d), Moves: %s -> End: %s\n", x, y, mouvements, resultat);
        assertEquals(attendu, resultat);
    }

    @Test
    public void testPremierExemple() throws IOException {
        testerScenario(3, 0, "SSSSEEEEEENN", "9,2");
    }

    @Test
    public void testDeuxiemeExemple() throws IOException {
        testerScenario(6, 7, "OONOOOSSO", "1,9");
    }

    @Test
    public void testDeplacementInvalideIgnore() throws IOException {
        testerScenario(3, 0, "SSSXEEEENNN", "6,0"); // 'X' est ignoré
    }

    @Test
    public void testSortieDeCarteIgnoree() throws IOException {
        testerScenario(0, 0, "NNNNNOOOOO", "0,0"); // bloqué au bord
    }

    @Test
    public void testMurBloquant() throws IOException {
         // Ce test échoue volontairement : il montre que l'aventurier ne traverse pas les murs.
         // Le déplacement vers la droite ('E') est bloqué dès le départ par un obstacle.
        testerScenario(0, 0, "SE", "0,1"); // ne va pas à droite car mur
    }
}


import java.io.*;
import java.nio.charset.StandardCharsets;

public class ProcesseurDeplacements {
    public static String[] lireFichier(String chemin) throws IOException {
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(new FileInputStream(chemin), StandardCharsets.UTF_8))) {
            String coordonnees = br.readLine();
            String deplacements = br.readLine();
            return new String[] { coordonnees, deplacements };
        }
    }
}
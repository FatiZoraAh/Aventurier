package aventurier;

public class Aventurier {
    private int x;
    private int y;

    public Aventurier(int xDepart, int yDepart) {
        this.x = xDepart;
        this.y = yDepart;
    }

    public void deplacer(char direction, Carte carte) {
        int newX = x, newY = y;

        switch (direction) {
            case 'N':
                newY--;
                break;
            case 'S':
                newY++;
                break;
            case 'E':
                newX++;
                break;
            case 'O':
                newX--;
                break;
            default:
                return; // Ignore les directions invalides
        }

        if (carte.estPracticable(newX, newY)) {
            x = newX;
            y = newY;
        }
    }

    public String getPosition() {
        return x + "," + y;
    }
}

public class Indice_violet extends Carte {

    public Indice_violet(Position position, int color) {
        // Initialise les attributs et choisit la bonne image pour la pièce
        super(position, color == 0 ? "img/indice_violet.png" : "img/indice_violet.png");
    }

    @Override
    public boolean isValidMove(Position position, Cell[][] board) {
        return true;
    }

    @Override
    public String toString() {
        return "K";
    }
}



public class Indice_rouge extends Carte {

    public Indice_rouge(Position position, int color) {
        // Initialise les attributs et choisit la bonne image pour la pièce
        super(position, color == 0 ? "img/indice_rouge.png" : "img/indice_rouge.png");
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


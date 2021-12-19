
public class Indice_vert extends Carte {

    public Indice_vert(Position position, int color) {
        // Initialise les attributs et choisit la bonne image pour la pièce
        super(position, color == 0 ? "img/indice_vert.png" : "img/indice_vert.png");
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


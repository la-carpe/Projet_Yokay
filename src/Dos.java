public class Dos extends Carte {

    public Dos(Position position, int color) {
        // Initialise les attributs et choisit la bonne image pour la pièce
        super(position, color == 0 ? "img/dos_carte.png" : "img/dos_carte.png");
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
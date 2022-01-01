
public class Dos_indices extends Carte {

    public Dos_indices(Position position, String pictureFile) {
        // Initialise les attributs et choisit la bonne image pour la pièce
        super(position, pictureFile =  "img/dos_indices.png");
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


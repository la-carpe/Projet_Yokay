
public class Indice_vert_violet_rouge extends Carte {

    public Indice_vert_violet_rouge(Position position, String pictureFile) {
        // Initialise les attributs et choisit la bonne image pour la pièce
        super(position, pictureFile =  "img/indice_vert_violet_rouge.png");
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


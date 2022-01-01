
public class Indice_bleu_violet extends Carte {

    public Indice_bleu_violet(Position position, String pictureFile) {
        // Initialise les attributs et choisit la bonne image pour la pièce
        super(position, pictureFile = "img/indice_bleu_violet.png");
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


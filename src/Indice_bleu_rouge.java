

public class Indice_bleu_rouge extends Carte {

    public Indice_bleu_rouge(Position position, String pictureFile) {
        // Initialise les attributs et choisit la bonne image pour la pièce
        super(position, pictureFile = "img/indice_bleu_rouge.png");
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


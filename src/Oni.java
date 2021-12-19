
    public class Oni extends Carte {

        public Oni(Position position, String pictureFile) {
            // Initialise les attributs et choisit la bonne image pour la pièce
            super(position,  pictureFile = "img/oni_carte.png");
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


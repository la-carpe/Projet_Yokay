
    public class oni extends Carte {

        public oni(Position position, int color) {
            // Initialise les attributs et choisit la bonne image pour la pièce
            super(position, color == 0 ? "img/Rb.png" : "img/Rb.png");
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



public class Cell {
        private final Position position;
        private boolean isEmpty;
        private Carte currentCarte;
        // Getters et Setters
        public Carte getCurrentCarte() {
            return currentCarte;
        }
        public boolean isEmpty() {
            return isEmpty;
        }

        // Constructeur initialisant les attributs
        public Cell(Position position, Carte currentCarte) {
            this.position = position;
            this.isEmpty = (currentCarte == null);
            this.currentCarte = currentCarte;
        }
    }


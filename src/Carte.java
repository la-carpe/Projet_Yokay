public abstract class Carte {
    // On note la visibilite des attributs definies a protected
    protected Position position;;
    public abstract String toString();
    public abstract boolean isValidMove(Position position, Cell[][] board);
    // Constructeur initialisant les attributs
    public Carte(Position position, String pictureFile) {
        this.position = position;
        this.pictureFile = pictureFile;
    }
    // Affichage des pièces
    protected String pictureFile;
    public void draw() {
        double x = this.position.getX() + 0.5;
        double y = this.position.getY() + 0.5;
        StdDraw.picture(x, y, this.pictureFile, 1, 1);
    }
}
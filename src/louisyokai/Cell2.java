package louisyokai;

public class Cell2 {

    public final Position position;
    private boolean isEmpty;
    public Carte currentCarte;
    // Getters et Setters
    public Carte getCurrentCarte() {
        return currentCarte;
    }
    public boolean isEmpty() {
        return isEmpty;
    }

    // Constructeur initialisant les attributs
    public Cell2(Position position, Carte currentCarte) {
        this.position = position;
        this.isEmpty = (currentCarte == null);
        this.currentCarte = currentCarte;
    }


}
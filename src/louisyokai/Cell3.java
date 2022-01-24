package louisyokai;

public class Cell3 {

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
    public Cell3(Position position, Carte currentCarte) {
        this.position = position;
        this.isEmpty = (currentCarte == null);
        this.currentCarte = currentCarte;
    }


}
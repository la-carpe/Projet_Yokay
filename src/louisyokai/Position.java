package louisyokai;

public class Position {

    private char column;
    private int row;
    public Position(char column, int row) {
        this.column = column;
        this.row = row;
    }

    @Override
    public String toString() {
        return "" + column + row;
    }

    // Conversion vers une abscisse louisyokai.StdDraw :
    // - si column vaut 'a' alors (column - 'a') vaut 0
    // - si column vaut 'b' alors (column - 'a') vaut 1
    // - si column vaut 'c' alors (column - 'a') vaut 2
    // - ...
    public int getX() {
        return this.column - 'a';
    }

    // Conversion vers une ordonnée louisyokai.StdDraw :
    public int getY() {
        return this.row - 1;
    }
}


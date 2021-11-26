public class Plateau {

    private Cell[][] board;
    private Player[] players;
    private Player currentPlayer;

    // On decrit brievement la logique du jeu
    public void play() {
        while (true) {
            createPlayers();
            initialiseBoard();
            while (!isCheckMate()) {
                printBoard();
            }
        }
    }


    private void createPlayers() {
        System.out.println("createPlayers");
    }

    private void initialiseBoard() {
        Position position;
        this.board = new Cell[16][16];

        position = new Position('a',8);
        this.board[7][0] = new Cell( position, new oni(position, 1) );
    }

    private boolean isCheckMate() {
        System.out.println("isCheckMate");
        return false;
    }


    private void printBoard() {
        for (int lig = 0; lig < 16; lig++) {
            for (int col = 0; col < 16; col++) {
                if ((lig + col) % 2 == 0) {
                    StdDraw.setPenColor(StdDraw.DARK_GRAY);
                } else {
                    StdDraw.setPenColor(StdDraw.BOOK_RED);
                }
                StdDraw.filledSquare(col + 0.5, lig + 0.5, 0.5);
                if ( ! this.board[lig][col].isEmpty()) {
                    this.board[lig][col].getCurrentCarte().draw();
                }
            }
        }
    }

}
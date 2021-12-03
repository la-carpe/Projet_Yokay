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

        // Cases vides haut
        for (int lig = 0; lig < 7; lig++) {
            for (int col = 0; col < 16; col++) {
                position = new Position((char) ('a' + col), lig);
                this.board[lig][col] = new Cell(null, null);
            }
        }
        // Cases vides bas
        for (int lig = 11; lig < 16; lig++) {
            for (int col = 0; col < 16; col++) {
                position = new Position((char) ('a' + col), lig);
                this.board[lig][col] = new Cell(null, null);
            }
        }
        // Cases vides gauche
        for (int col = 0; col < 6; col++) {
            for (int lig = 0; lig < 16; lig++) {
                position = new Position((char) ('a' + col), lig);
                this.board[lig][col] = new Cell(null, null);
            }
        }

        // Cases vides droite
        for (int col = 10; col < 16; col++) {
            for (int lig = 0; lig < 16; lig++) {
                position = new Position((char) ('a' + col), lig);
                this.board[lig][col] = new Cell(null, null);
            }
        }

        // Cases pleines au milieu


        for (int col = 6; col < 10; col++) {
            for (int lig = 7; lig < 11; lig++) {
                position = new Position((char) ('a' + col), lig);
                this.board[lig][col] = new Cell(position, new oni(position, 1));
            }
        }


        // Initialise la fenêtre d'affichage de l'échiquier
        StdDraw.setCanvasSize(600, 600);
        StdDraw.setXscale(0, 16);
        StdDraw.setYscale(0, 16);

    }

    private boolean isCheckMate() {
        System.out.println("isCheckMate");
        return false;
    }


    private void printBoard() {
        for (int lig = 0; lig < 16; lig++) {
            for (int col = 0; col < 16; col++) {
                StdDraw.setPenColor(StdDraw.GRAY);
                if ((lig + col) % 2 == 0) {
                    StdDraw.setPenColor(StdDraw.DARK_GRAY);
                } else {
                    StdDraw.setPenColor(StdDraw.GRAY);
                }
                StdDraw.filledSquare(col + 0.5, lig + 0.5, 0.5);
                if (!this.board[lig][col].isEmpty()) {
                    this.board[lig][col].getCurrentCarte().draw();
                }
            }
        }


        for (int lig = 0; lig < 1; lig++) {
            for (int col = 0; col < 1; col++) {
                StdDraw.setPenColor(StdDraw.RED);

            }
        }
        StdDraw.filledSquare( 1, + 1, 1);
        if (!this.board[0][0].isEmpty()) {
            this.board[0][0].getCurrentCarte().draw();
        }

    }
}
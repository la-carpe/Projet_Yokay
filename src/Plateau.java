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
        this.board = new Cell[13][12];

        // Cases vides haut
        for (int lig = 0; lig < 5; lig++) {
            for (int col = 0; col < 12; col++) {
                position = new Position((char) ('a' + col),lig);
                this.board[lig][col] = new Cell( null, null );
            }
        }
        // Cases vides bas
        for (int lig = 9; lig < 13; lig++) {
            for (int col = 0; col < 12; col++) {
                position = new Position((char) ('a' + col),lig);
                this.board[lig][col] = new Cell( null, null );
            }
        }
        // Cases vides gauche
        for (int col = 0; col < 4; col++) {
            for (int lig = 0; lig < 12; lig++) {
                position = new Position((char) ('a' + col),lig);
                this.board[lig][col] = new Cell( null, null );
            }
        }

        // Cases vides droite
        for (int col = 8; col < 12; col++) {
            for (int lig = 0; lig < 12; lig++) {
                position = new Position((char) ('a' + col),lig);
                this.board[lig][col] = new Cell( null, null );
            }
        }

        // Cases pleines au milieu


        for (int col = 4; col < 8; col++) {
            for (int lig = 5; lig <= 8; lig++) {
                position = new Position((char) ('a' + col),lig);
                this.board[lig][col] = new Cell( position,new oni(position,1) );
            }
        }



        // Initialise la fenêtre d'affichage de l'échiquier
        StdDraw.setCanvasSize(600, 600);
        StdDraw.setXscale(0, 12);
        StdDraw.setYscale(0, 12);

    }

    private boolean isCheckMate() {
        System.out.println("isCheckMate");
        return false;
    }


    private void printBoard() {
        for (int lig = 0; lig < 12; lig++) {
            for (int col = 0; col < 12; col++) {
                if ((lig + col) % 2 == 0) {
                    StdDraw.setPenColor(StdDraw.GRAY);
                } else {
                    StdDraw.setPenColor(StdDraw.DARK_GRAY);
                }
                StdDraw.filledSquare(col + 0.5, lig + 0.5, 0.5);
                if ( ! this.board[lig][col].isEmpty()) {
                    this.board[lig][col].getCurrentCarte().draw();
                }
            }
        }
    }

}
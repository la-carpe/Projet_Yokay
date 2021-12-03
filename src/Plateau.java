

public class Plateau {

    private Cell[][] board;
    private Player[] players;
    private Player currentPlayer;
    private boolean change = true;

    // On decrit brievement la logique du jeu
    public void play() {
        createPlayers();
        initialiseBoard();
        System.out.println("print");
        while (true) {
            while (change) {
                change = false;
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
        while (true) {

            if (StdDraw.isMousePressed()) {

                for (int lig = 15; lig < 16; lig++) {
                    for (int col = 3; col < 4; col++) {
                        StdDraw.setPenColor(StdDraw.RED);
                        StdDraw.filledSquare(0.5+ col, lig + 0.5, 0.5);
                        System.out.println((StdDraw.mouseX() +"," + StdDraw.mouseY()));

                    }
                }
            }
        }

        }


    }


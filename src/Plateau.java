import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Plateau {

    private Cell[][] board;
    private Player[] players;
    private Player currentPlayer;
    private boolean change = true;
    private String pictureFile;


    // On decrit brievement la logique du jeu
    public void play() {
        createPlayers();
        initialiseBoard();
        System.out.println("print");

        while (change) {

            printBoard();
        }
    }

    private void createPlayers() {
        System.out.println("createPlayers");
    }

    private void initialiseBoard() {
        Position position;
        this.board = new Cell[16][16];



        // Cases vides haut
        for (int col = 0; col < 16; col++) {
            for (int lig = 10; lig < 16; lig++) {
                position = new Position((char) ('a' + col), lig+1);
                this.board[col][lig] = new Cell(null, null);


            }
        }
        // Cases vides bas
        for (int col = 0; col < 16; col++) {
            for (int lig = 0; lig < 6; lig++) {
                position = new Position((char) ('a' + col), lig+1);
                this.board[col][lig] = new Cell(null,null);


            }
        }
        // Cases vides droite
        for (int col = 0; col < 6; col++) {
            for (int lig = 0; lig < 16; lig++) {
                position = new Position((char) ('a' + col), lig+1);
                this.board[col][lig] = new Cell(null,null);

            }
        }

        // Cases vides gauche
        for (int col = 10; col < 16; col++) {
            for (int lig = 0; lig < 16; lig++) {
                position = new Position((char) ('a' + col), lig+1 );
                this.board[col][lig] = new Cell(null,null);
            }
        }

        // Cases pleines au milieu

        for (int col = 6; col < 10; col++) {
            for (int lig = 6; lig < 10; lig++) {
                position = new Position((char) ('a' + col), lig +1);
                this.board[col][lig] = new Cell(null, null);

            }
        }








        for (int col = 3; col < 4; col++) {
            for (int lig = 15; lig < 16; lig++) {
                position = new Position((char) ('a' + col), lig + 1);
                this.board[lig][col] = new Cell(position, new Dos_indices(position, 1));


            }
        }


        // Initialise la fenêtre d'affichage de l'échiquier
        StdDraw.setCanvasSize(600, 600);
        StdDraw.setXscale(0, 16);
        StdDraw.setYscale(0, 16);


    }

    private void printBoard() {
        Position position;



        // plateau début
        ArrayList<Integer> listX = new ArrayList<Integer>();
        for (int i=6; i<10; i++) {
            listX.add(i);
        }
        Collections.shuffle(listX);
        System.out.println(listX);


        ArrayList<Integer> listY = new ArrayList<Integer>();
        for (int i=7; i<11; i++) {
            listY.add(i);
        }
        Collections.shuffle(listY);
        System.out.println(listY);


// Oni initialisation random

        position = new Position((char) ('a' + listX.get(0)), listY.get(0));
        pictureFile = "img/oni_carte.png";
        this.board[listX.get(0)][listY.get(0)] = new Cell(position, new Oni(position, pictureFile));

        position = new Position((char) ('a' + listX.get(2)), listY.get(1));
        pictureFile = "img/oni_carte.png";
        this.board[listX.get(2)][listY.get(1)] = new Cell(position, new Oni(position, pictureFile));

        position = new Position((char) ('a' + listX.get(3)), listY.get(2));
        pictureFile = "img/oni_carte.png";
        this.board[listX.get(3)][listY.get(2)] = new Cell(position, new Oni(position, pictureFile));

        position = new Position((char) ('a' + listX.get(1)), listY.get(3));
        pictureFile = "img/oni_carte.png";
        this.board[listX.get(1)][listY.get(3)] = new Cell(position, new Oni(position, pictureFile));





// Kitsune initialisaton random


        position = new Position((char) ('a' + listX.get(1)), listY.get(1));
        pictureFile ="img/kitsune_carte.png";
        this.board[listX.get(1)][listY.get(1)] = new Cell(position, new Kitsune(position, pictureFile));

        position = new Position((char) ('a' + listX.get(2)), listY.get(3));
        pictureFile ="img/kitsune_carte.png";
        this.board[listX.get(2)][listY.get(3)] = new Cell(position, new Kitsune(position, pictureFile));

        position = new Position((char) ('a' + listX.get(3)), listY.get(0));
        pictureFile ="img/kitsune_carte.png";
        this.board[listX.get(3)][listY.get(0)] = new Cell(position, new Kitsune(position, pictureFile));

        position = new Position((char) ('a' + listX.get(0)), listY.get(2));
        pictureFile ="img/kitsune_carte.png";
        this.board[listX.get(0)][listY.get(2)] = new Cell(position, new Kitsune(position, pictureFile));


        // Kappa initialisation

        position = new Position((char) ('a' + listX.get(2)), listY.get(2));
        pictureFile =  "img/kappa_carte.png";
        this.board[listX.get(2)][listY.get(2)] = new Cell(position, new Kappa(position, pictureFile));

        position = new Position((char) ('a' + listX.get(0)), listY.get(1));
        pictureFile =  "img/kappa_carte.png";
        this.board[listX.get(0)][listY.get(1)] = new Cell(position, new Kappa(position, pictureFile));

        position = new Position((char) ('a' + listX.get(3)), listY.get(1));
        pictureFile =  "img/kappa_carte.png";
        this.board[listX.get(3)][listY.get(1)] = new Cell(position, new Kappa(position, pictureFile));

        position = new Position((char) ('a' + listX.get(1)), listY.get(2));
        pictureFile =  "img/kappa_carte.png";
        this.board[listX.get(1)][listY.get(2)] = new Cell(position, new Kappa(position, pictureFile));

// initialisation rokurokubi

        position = new Position((char) ('a' + listX.get(3)), listY.get(3));
        pictureFile =  "img/rokurokubi_carte.png";
        this.board[listX.get(3)][listY.get(3)] = new Cell(position, new Rokurokubi(position, pictureFile));

        position = new Position((char) ('a' + listX.get(2)), listY.get(0));
        pictureFile =  "img/rokurokubi_carte.png";
        this.board[listX.get(2)][listY.get(0)] = new Cell(position, new Rokurokubi(position, pictureFile));

        position = new Position((char) ('a' + listX.get(1)), listY.get(0));
        pictureFile =  "img/rokurokubi_carte.png";
        this.board[listX.get(1)][listY.get(0)] = new Cell(position, new Rokurokubi(position, pictureFile));

        position = new Position((char) ('a' + listX.get(0)), listY.get(3));
        pictureFile =  "img/rokurokubi_carte.png";
        this.board[listX.get(0)][listY.get(3)] = new Cell(position, new Rokurokubi(position, pictureFile));






        //background du plateau

        for (int col = 0; col < 16; col++) {
            for (int lig = 0; lig < 16; lig++) {
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

        // plateau milieu
        for ( int col = 6; col < 10; col++) {
            for (int lig = 6; lig < 10; lig++) {

                    StdDraw.setPenColor(StdDraw.WHITE);
               // StdDraw.filledSquare(col + 0.5, lig + 0.5, 0.5);
                if (!this.board[lig][col].isEmpty()) {
                    this.board[lig][col].getCurrentCarte().draw();
                }


            }
        }
















        while (change) {

            if (StdDraw.isMousePressed()){

                int a = (int) Math.abs((StdDraw.mouseX()));
                int b = (int) Math.abs((StdDraw.mouseY()));

                System.out.println(a);
                System.out.println(b);

            }




//            if (StdDraw.isMousePressed() & StdDraw.mouseX() >= 6 & StdDraw.mouseX() <= 9 & StdDraw.mouseY() >= 7 & StdDraw.mouseY() <= 10) {
//
//                int a = (int) Math.abs((StdDraw.mouseX()));
//                int b = (int) Math.abs((StdDraw.mouseY()));
//
//                for (int col = 6; col < 10; col++) {
//                    for (int lig = 7; lig < 11; lig++) {
//                        Position position = new Position((char) ('a' + col), lig);
//                        this.board[lig][col] = new Cell(position, null);
//                        this.board[lig][col].getCurrentCarte().draw();
//
//                    }
//                }
//
//                    }
//
//                }
//
//            }


//                if (StdDraw.isMousePressed() & StdDraw.mouseX() >= 3 & StdDraw.mouseX() <= 4 & StdDraw.mouseY() >= 15 & StdDraw.mouseY() < 16) {
//                    int posX = (int) Math.abs(StdDraw.mouseX());
//                    int posY = (int) Math.abs(StdDraw.mouseY());
//
//                    Position position = new Position((char) ('a' + posX + 1), posY + 1);
//                    String picturefile = "img/oni_carte.png";
//                    this.board[posX + 1][posY] = new Cell(position, new Oni(position,picturefile ));
//                    this.board[posX + 1][posY].getCurrentCarte().draw();
//                    System.out.println(posX);
//                    System.out.println(posY);
//
//                }


//                if (StdDraw.isMousePressed()) {
//
//                    for (int col = 15; col < 16; col++) {
//                        for (int lig = 15; lig < 16; col++) {
//
//                            Position position = new Position((char) ('a' + col), lig);
//                            String picturefile = "img/oni_carte.png";
//                            this.board[lig][col] = new Cell(position, new Oni(position, picturefile));
//                            this.board[lig][col].getCurrentCarte().draw();
//
//                            int c = position.getX();
//                            int d = position.getY();
//
//
//                            if (StdDraw.isMousePressed() & StdDraw.mouseX() >= c & StdDraw.mouseX() <= c + 1 & StdDraw.mouseY() >= d & StdDraw.mouseY() <= d + 1) {
//                                position = new Position((char) ('a' + col), lig);
//                                System.out.println("oni disparait");
//                                this.board[lig][col] = new Cell(position, null);
//
//
//                            }
//                        }
//                    }
//                }
            }
        }

    }









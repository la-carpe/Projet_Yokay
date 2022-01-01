import java.awt.*;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Plateau {

    private Cell[][] board;
    private Cell2[][] board2;
    private Cell3[][] board3;
    private Player[] players;
    private Player currentPlayer;
    private boolean change = true;
    private boolean change2 = true;
    private boolean change3 = true;
    private boolean fin = true;
    private String pictureFile;
    private String pictureFile2;
    int compt = 0;
    int compt2 = 0;
    int compt3 = 0;


    // On decrit brievement la logique du jeu
    public void play() {
        initialiseBoard();

        while (fin){
            printBoard();
            System.out.println("change = " + change);
            System.out.println("change2 = " + change2);
            System.out.println("change3 = " +change3);

             change = true;
              change2 = true;
              change3 = true;
             compt = 0;
             compt2 = 0;
             compt3 = 0;

    }

            System.out.println("fin1");


    }

    private void initialiseBoard() {
        Position position;
        this.board = new Cell[16][16];
        this.board2 = new Cell2[16][16];
        this.board3 = new Cell3[16][16];


        // Cases vides haut
        for (int col = 6; col < 10; col++) {
            for (int lig = 10; lig < 16; lig++) {
                position = new Position((char) ('a' + col), lig + 1);
                this.board[col][lig] = new Cell(null, null);
                this.board2[col][lig] = new Cell2(null, null);

            }
        }
        // Cases vides bas
        for (int col = 6; col < 10; col++) {
            for (int lig = 0; lig < 6; lig++) {
                position = new Position((char) ('a' + col), lig + 1);
                this.board[col][lig] = new Cell(null, null);
                this.board2[col][lig] = new Cell2(null, null);


            }
        }
        // Cases vides droite
        for (int col = 10; col < 16; col++) {
            for (int lig = 0; lig < 16; lig++) {
                position = new Position((char) ('a' + col), lig + 1);
                this.board[col][lig] = new Cell(null, null);
                this.board2[col][lig] = new Cell2(null, null);

            }
        }

        // Cases vides gauche
        for (int col = 0; col < 6; col++) {
            for (int lig = 0; lig < 16; lig++) {
                position = new Position((char) ('a' + col), lig + 1);
                this.board[col][lig] = new Cell(null, null);
                this.board2[col][lig] = new Cell2(null, null);
            }
        }


        //carte dos indice

        for (int col = 3; col < 4; col++) {
            for (int lig = 14; lig < 15; lig++) {
                position = new Position((char) ('a' + col), lig + 1);
                this.board[lig][col] = new Cell(position, new Dos_indices(position, pictureFile));
            }
        }

        //plateau indices null partout

        for (int col = 0; col < 16; col++) {
            for (int lig = 0; lig < 16; lig++) {
                position = new Position((char) ('a' + col), lig + 1);
                this.board3[col][lig] = new Cell3(null, null);

            }
        }


        ArrayList<Integer> listX = new ArrayList<Integer>();
        for (int i = 6; i < 10; i++) {
            listX.add(i);
        }
        Collections.shuffle(listX);
        System.out.println(listX);


        ArrayList<Integer> listY = new ArrayList<Integer>();
        for (int i = 6; i < 10; i++) {
            listY.add(i);
        }
        Collections.shuffle(listY);
        System.out.println(listY);


        // Oni initialisation random


        position = new Position((char) ('a' + listX.get(0)), listY.get(0) + 1);
        pictureFile = "img/oni_carte.png";
        this.board[listX.get(0)][listY.get(0)] = new Cell(position, new Oni(position, pictureFile));
        if (!this.board[listX.get(0)][listY.get(0)].isEmpty()) {
            this.board[listX.get(0)][listY.get(0)].getCurrentCarte().draw();

        }

        position = new Position((char) ('a' + listX.get(2)), listY.get(1) + 1);
        this.board[listX.get(2)][listY.get(1)] = new Cell(position, new Oni(position, pictureFile));
        if (!this.board[listX.get(2)][listY.get(1)].isEmpty()) {
            this.board[listX.get(2)][listY.get(1)].getCurrentCarte().draw();
        }


        position = new Position((char) ('a' + listX.get(3)), listY.get(2) + 1);
        this.board[listX.get(3)][listY.get(2)] = new Cell(position, new Oni(position, pictureFile));
        if (!this.board[listX.get(3)][listY.get(2)].isEmpty()) {
            this.board[listX.get(3)][listY.get(2)].getCurrentCarte().draw();
        }

        position = new Position((char) ('a' + listX.get(1)), listY.get(3) + 1);
        this.board[listX.get(1)][listY.get(3)] = new Cell(position, new Oni(position, pictureFile));
        if (!this.board[listX.get(1)][listY.get(3)].isEmpty()) {
            this.board[listX.get(1)][listY.get(3)].getCurrentCarte().draw();
        }


        // Kitsune initialisaton random


        position = new Position((char) ('a' + listX.get(1)), listY.get(1) + 1);
        pictureFile = "img/kitsune_carte.png";
        this.board[listX.get(1)][listY.get(1)] = new Cell(position, new Kitsune(position, pictureFile));
        if (!this.board[listX.get(1)][listY.get(1)].isEmpty()) {
            this.board[listX.get(1)][listY.get(1)].getCurrentCarte().draw();
        }

        position = new Position((char) ('a' + listX.get(2)), listY.get(3) + 1);
        pictureFile = "img/kitsune_carte.png";
        this.board[listX.get(2)][listY.get(3)] = new Cell(position, new Kitsune(position, pictureFile));
        if (!this.board[listX.get(2)][listY.get(3)].isEmpty()) {
            this.board[listX.get(2)][listY.get(3)].getCurrentCarte().draw();
        }


        position = new Position((char) ('a' + listX.get(3)), listY.get(0) + 1);
        pictureFile = "img/kitsune_carte.png";
        this.board[listX.get(3)][listY.get(0)] = new Cell(position, new Kitsune(position, pictureFile));
        if (!this.board[listX.get(3)][listY.get(0)].isEmpty()) {
            this.board[listX.get(3)][listY.get(0)].getCurrentCarte().draw();
        }

        position = new Position((char) ('a' + listX.get(0)), listY.get(2) + 1);
        pictureFile = "img/kitsune_carte.png";
        this.board[listX.get(0)][listY.get(2)] = new Cell(position, new Kitsune(position, pictureFile));
        if (!this.board[listX.get(0)][listY.get(2)].isEmpty()) {
            this.board[listX.get(0)][listY.get(2)].getCurrentCarte().draw();
        }


        // Kappa initialisation

        position = new Position((char) ('a' + listX.get(2)), listY.get(2) + 1);
        pictureFile = "img/kappa_carte.png";
        this.board[listX.get(2)][listY.get(2)] = new Cell(position, new Kappa(position, pictureFile));
        if (!this.board[listX.get(2)][listY.get(2)].isEmpty()) {
            this.board[listX.get(2)][listY.get(2)].getCurrentCarte().draw();
        }


        position = new Position((char) ('a' + listX.get(0)), listY.get(1) + 1);
        pictureFile = "img/kappa_carte.png";
        this.board[listX.get(0)][listY.get(1)] = new Cell(position, new Kappa(position, pictureFile));
        if (!this.board[listX.get(0)][listY.get(1)].isEmpty()) {
            this.board[listX.get(0)][listY.get(1)].getCurrentCarte().draw();
        }

        position = new Position((char) ('a' + listX.get(3)), listY.get(1) + 1);
        pictureFile = "img/kappa_carte.png";
        this.board[listX.get(3)][listY.get(1)] = new Cell(position, new Kappa(position, pictureFile));
        if (!this.board[listX.get(3)][listY.get(1)].isEmpty()) {
            this.board[listX.get(3)][listY.get(1)].getCurrentCarte().draw();
        }

        position = new Position((char) ('a' + listX.get(1)), listY.get(2) + 1);
        pictureFile = "img/kappa_carte.png";
        this.board[listX.get(1)][listY.get(2)] = new Cell(position, new Kappa(position, pictureFile));
        if (!this.board[listX.get(1)][listY.get(2)].isEmpty()) {
            this.board[listX.get(1)][listY.get(2)].getCurrentCarte().draw();
        }


        //// initialisation rokurokubi

        position = new Position((char) ('a' + listX.get(3)), listY.get(3) + 1);
        pictureFile = "img/rokurokubi_carte.png";
        this.board[listX.get(3)][listY.get(3)] = new Cell(position, new Rokurokubi(position, pictureFile));
        if (!this.board[listX.get(3)][listY.get(3)].isEmpty()) {
            this.board[listX.get(3)][listY.get(3)].getCurrentCarte().draw();
        }

        position = new Position((char) ('a' + listX.get(2)), listY.get(0) + 1);
        pictureFile = "img/rokurokubi_carte.png";
        this.board[listX.get(2)][listY.get(0)] = new Cell(position, new Rokurokubi(position, pictureFile));
        if (!this.board[listX.get(2)][listY.get(0)].isEmpty()) {
            this.board[listX.get(2)][listY.get(0)].getCurrentCarte().draw();
        }


        position = new Position((char) ('a' + listX.get(1)), listY.get(0) + 1);
        pictureFile = "img/rokurokubi_carte.png";
        this.board[listX.get(1)][listY.get(0)] = new Cell(position, new Rokurokubi(position, pictureFile));
        if (!this.board[listX.get(1)][listY.get(0)].isEmpty()) {
            this.board[listX.get(1)][listY.get(0)].getCurrentCarte().draw();
        }

        position = new Position((char) ('a' + listX.get(0)), listY.get(3) + 1);
        pictureFile = "img/rokurokubi_carte.png";
        this.board[listX.get(0)][listY.get(3)] = new Cell(position, new Rokurokubi(position, pictureFile));
        if (!this.board[listX.get(0)][listY.get(3)].isEmpty()) {
            this.board[listX.get(0)][listY.get(3)].getCurrentCarte().draw();
        }

        // Cases pleines milieu
        for (int col = 6; col < 10; col++) {
            for (int lig = 6; lig < 10; lig++) {
                position = new Position((char) ('a' + col), lig + 1);
                pictureFile = "img/dos_carte.png";
                this.board2[col][lig] = new Cell2(position, new Dos(position, pictureFile));
                if (!this.board2[col][lig].isEmpty()) {
                    this.board2[col][lig].getCurrentCarte().draw();
                }

            }
        }


        // Initialise la fenêtre d'affichage de l'échiquier
        StdDraw.setCanvasSize(600, 600);
        StdDraw.setXscale(0, 16);
        StdDraw.setYscale(0, 16);


    }

    private void printBoard() {
        Position position;
        Carte currentCarte;

        StdDraw.setPenColor(StdDraw.GRAY);
        StdDraw.filledSquare(16, 16, 16);


        for (int col = 0; col < 16; col++) {
            for (int lig = 0; lig < 16; lig++) {


                if (!this.board[lig][col].isEmpty()) {
                    this.board[lig][col].getCurrentCarte().draw();
                }

                if (!this.board2[lig][col].isEmpty()) {
                    this.board2[lig][col].getCurrentCarte().draw();
                }
                if (!this.board3[lig][col].isEmpty()) {
                    this.board3[lig][col].getCurrentCarte().draw();
                }


            }
        }


        // emplacements indices

        for (int col = 5; col < 11; col++) {
            for (int lig = 14; lig < 15; lig++) {


                StdDraw.setPenColor(StdDraw.BLACK);
                StdDraw.filledSquare(col + 0.5, lig + 0.5, 0.5);

                if (!this.board3[lig][col].isEmpty()) {
                    this.board3[lig][col].getCurrentCarte().draw();
                }
            }
        }


        while (change) {
            StdDraw.setPenColor(StdDraw.RED);
            StdDraw.text(7, 0.5, "Regardez 2 cartes Yokai");


            if (StdDraw.isMousePressed() & StdDraw.mouseX() >= 0 & StdDraw.mouseX() < 16 & StdDraw.mouseY() >= 0 & StdDraw.mouseY() < 16) {

                int c = (int) Math.abs((StdDraw.mouseX()));
                int d = (int) Math.abs((StdDraw.mouseY()));

                if (!this.board2[c][d].isEmpty()) {

                    compt = compt + 1;


                    position = new Position((char) ('a' + c), d + 1);
                    this.board2[c][d] = new Cell2(null, null);
                    if (!this.board2[c][d].isEmpty()) {
                        this.board2[c][d].getCurrentCarte().draw();
                    }
                    printBoard();


                }
            }
            if (compt >= 2) {

                change = false;
                printBoard();


            }
        }

        while (change2) {
            StdDraw.setPenColor(StdDraw.BLUE);


            StdDraw.text(7, 0.5, "deplacez une carte Yokai");


            if (StdDraw.isMousePressed() & StdDraw.mouseX() >= 0 & StdDraw.mouseX() < 16 & StdDraw.mouseY() >= 0 & StdDraw.mouseY() < 16) {

                int a = (int) Math.abs((StdDraw.mouseX()));
                int b = (int) Math.abs((StdDraw.mouseY()));


                if (!this.board[a][b].isEmpty()) {

                    compt2 = compt2 + 1;
                    System.out.println(compt2);

                    pictureFile2 = this.board[a][b].currentCarte.getPictureFile();
                    System.out.println(pictureFile2);

                    position = new Position((char) ('a' + a), b + 1);
                    this.board[a][b] = new Cell(null, null);
                    this.board2[a][b] = new Cell2(null, null);
                    printBoard();

                }

            }


            if (pictureFile2 == "img/rokurokubi_carte.png" & StdDraw.isMousePressed() & StdDraw.mouseX() >= 0 & StdDraw.mouseX() < 16 & StdDraw.mouseY() >= 0 & StdDraw.mouseY() < 16) {

                int c = (int) Math.abs((StdDraw.mouseX()));
                int d = (int) Math.abs((StdDraw.mouseY()));
                System.out.println("c =" + c);
                System.out.println("d =" + d);

                position = new Position((char) ('a' + c), d + 1);
                this.board[c][d] = new Cell(position, new Rokurokubi(position, pictureFile2));
                this.board2[c][d] = new Cell2(position, new Dos(position, pictureFile2));
                if (!this.board[c][d].isEmpty()) {
                    this.board[c][d].getCurrentCarte().draw();
                }
                if (!this.board2[c][d].isEmpty()) {
                    this.board2[c][d].getCurrentCarte().draw();
                }

                compt2 = compt2 + 1;
                System.out.println(compt2);
                printBoard();

            }


            if (pictureFile2 == "img/kitsune_carte.png" & StdDraw.isMousePressed() & StdDraw.mouseX() >= 0 & StdDraw.mouseX() < 16 & StdDraw.mouseY() >= 0 & StdDraw.mouseY() < 16) {

                int c = (int) Math.abs((StdDraw.mouseX()));
                int d = (int) Math.abs((StdDraw.mouseY()));
                System.out.println("c =" + c);
                System.out.println("d =" + d);

                position = new Position((char) ('a' + c), d + 1);
                this.board[c][d] = new Cell(position, new Kitsune(position, pictureFile2));
                this.board2[c][d] = new Cell2(position, new Dos(position, pictureFile2));
                if (!this.board[c][d].isEmpty()) {
                    this.board[c][d].getCurrentCarte().draw();
                }
                if (!this.board2[c][d].isEmpty()) {
                    this.board2[c][d].getCurrentCarte().draw();
                }

                compt2 = compt2 + 1;
                System.out.println(compt2);
                printBoard();
            }


            if (pictureFile2 == "img/oni_carte.png" & StdDraw.isMousePressed() & StdDraw.mouseX() >= 0 & StdDraw.mouseX() < 16 & StdDraw.mouseY() >= 0 & StdDraw.mouseY() < 16) {

                int c = (int) Math.abs((StdDraw.mouseX()));
                int d = (int) Math.abs((StdDraw.mouseY()));
                System.out.println("c =" + c);
                System.out.println("d =" + d);

                position = new Position((char) ('a' + c), d + 1);
                this.board[c][d] = new Cell(position, new Oni(position, pictureFile2));
                this.board2[c][d] = new Cell2(position, new Dos(position, pictureFile2));
                if (!this.board[c][d].isEmpty()) {
                    this.board[c][d].getCurrentCarte().draw();
                }
                if (!this.board2[c][d].isEmpty()) {
                    this.board2[c][d].getCurrentCarte().draw();
                }

                compt2 = compt2 + 1;
                System.out.println(compt2);
                printBoard();
            }

            if (pictureFile2 == "img/kappa_carte.png" & StdDraw.isMousePressed() & StdDraw.mouseX() >= 0 & StdDraw.mouseX() < 16 & StdDraw.mouseY() >= 0 & StdDraw.mouseY() < 16) {

                int c = (int) Math.abs((StdDraw.mouseX()));
                int d = (int) Math.abs((StdDraw.mouseY()));
                System.out.println("c =" + c);
                System.out.println("d =" + d);

                position = new Position((char) ('a' + c), d + 1);
                this.board[c][d] = new Cell(position, new Kappa(position, pictureFile2));
                this.board2[c][d] = new Cell2(position, new Dos(position, pictureFile2));
                if (!this.board[c][d].isEmpty()) {
                    this.board[c][d].getCurrentCarte().draw();
                }
                if (!this.board2[c][d].isEmpty()) {
                    this.board2[c][d].getCurrentCarte().draw();
                }

                compt2 = compt2 + 1;
                System.out.println(compt2);
                printBoard();
            }

            if (compt2 > 1) {
                change2 = false;
                printBoard();

            }
        }

        while (change3) {
            StdDraw.text(7, 0.5, "Revelez ou deplacez une carte indice");


            int i = 1;


            if (StdDraw.isMousePressed() & StdDraw.mouseX() >= 3 & StdDraw.mouseX() < 4 & StdDraw.mouseY() >= 14 & StdDraw.mouseY() < 15) {

                i = i + 1;
                int a = (int) Math.abs((StdDraw.mouseX()));
                int b = (int) Math.abs((StdDraw.mouseY()));

                int random = (int) (Math.random() * 12);
                System.out.println(random);


                position = new Position((char) ('a' + a + i), b + 1);
                if (random == 0) {
                    this.board3[a + 2][b] = new Cell3(position, new Indice_bleu(position, pictureFile));
                }
                 if (random == 1) {
                    this.board3[a + 2][b] = new Cell3(position, new Indice_bleu_vert_rouge(position, pictureFile));
                }
                 if (random == 2) {
                    this.board3[a + 2][b] = new Cell3(position, new Indice_bleu_vert_violet(position, pictureFile));
                }
                 if (random == 3) {
                    this.board3[a + 2][b] = new Cell3(position, new Indice_bleu_violet(position, pictureFile));
                }
                 if (random == 4) {
                    this.board3[a + 2][b] = new Cell3(position, new Indice_bleu_violet_rouge(position, pictureFile));
                }
                 if (random == 5) {
                    this.board3[a + 2][b] = new Cell3(position, new Indice_rouge(position, pictureFile));
                }
                 if (random == 6) {
                    this.board3[a + 2][b] = new Cell3(position, new Indice_rouge_violet(position, pictureFile));
                }
                if (random == 7) {
                    this.board3[a + 2][b] = new Cell3(position, new Indice_vert(position, pictureFile));
                }
                if (random == 8) {
                    this.board3[a + 2][b] = new Cell3(position, new Indice_vert_bleu(position, pictureFile));
                }
                if (random == 9) {
                    this.board3[a + 2][b] = new Cell3(position, new Indice_vert_rouge(position, pictureFile));
                }
                if (random == 10) {
                    this.board3[a + 2][b] = new Cell3(position, new Indice_vert_violet(position, pictureFile));
                }
                if (random == 11) {
                    this.board3[a + 2][b] = new Cell3(position, new Indice_vert_violet_rouge(position, pictureFile));
                }
                if (random == 12) {
                    this.board3[a + 2][b] = new Cell3(position, new Indice_violet(position, pictureFile));
                }


                if (!this.board3[a + 2][b].isEmpty()) {
                    this.board3[a + 2][b].getCurrentCarte().draw();
                }


            }


            if (StdDraw.isMousePressed() & StdDraw.mouseX() >= 5 & StdDraw.mouseX() < 11 & StdDraw.mouseY() >= 14 & StdDraw.mouseY() < 15) {

                int x = (int) Math.abs((StdDraw.mouseX()));
                int y = (int) Math.abs((StdDraw.mouseY()));
                System.out.println("x = " + x);
                System.out.println("y = " + y);

                if (!this.board3[x][y].isEmpty()) {

                    pictureFile2 = this.board3[x][y].currentCarte.getPictureFile();
                    System.out.println(pictureFile2);
                }
                this.board3[x][y] = new Cell3(null, null);
                printBoard();
            }




            if (pictureFile2 == "img/indice_vert_bleu.png" & StdDraw.isMousePressed() & StdDraw.mouseX() >= 0 & StdDraw.mouseX() < 16 & StdDraw.mouseY() >= 0 & StdDraw.mouseY() < 16) {

                int c = (int) Math.abs((StdDraw.mouseX()));
                int d = (int) Math.abs((StdDraw.mouseY()));
                System.out.println("c =" + c);
                System.out.println("d =" + d);

                if (!this.board[c][d].isEmpty()) {

                    position = new Position((char) ('a' + c), d + 1);
                    this.board3[c][d] = new Cell3(position, new Indice_vert_bleu(position, pictureFile2));
                    if (!this.board3[c][d].isEmpty()) {
                        this.board3[c][d].getCurrentCarte().draw();
                    }
                    compt3 = compt3 + 1;
                    System.out.println("compt3 = " + compt3);
                    printBoard();

                }

            }


            if (pictureFile2 == "img/indice_bleu.png" & StdDraw.isMousePressed() & StdDraw.mouseX() >= 0 & StdDraw.mouseX() < 16 & StdDraw.mouseY() >= 0 & StdDraw.mouseY() < 16) {

                int c = (int) Math.abs((StdDraw.mouseX()));
                int d = (int) Math.abs((StdDraw.mouseY()));
                System.out.println("c =" + c);
                System.out.println("d =" + d);

                if (!this.board[c][d].isEmpty()) {

                    position = new Position((char) ('a' + c), d + 1);
                    this.board3[c][d] = new Cell3(position, new Indice_bleu(position, pictureFile2));
                    if (!this.board3[c][d].isEmpty()) {
                        this.board3[c][d].getCurrentCarte().draw();
                    }
                    compt3 = compt3 + 1;
                    System.out.println("compt3 = " + compt3);
                    printBoard();

                }
            }


            if (pictureFile2 == "img/indice_bleu_rouge.png" & StdDraw.isMousePressed() & StdDraw.mouseX() >= 0 & StdDraw.mouseX() < 16 & StdDraw.mouseY() >= 0 & StdDraw.mouseY() < 16) {

                int c = (int) Math.abs((StdDraw.mouseX()));
                int d = (int) Math.abs((StdDraw.mouseY()));
                System.out.println("c =" + c);
                System.out.println("d =" + d);

                if (!this.board[c][d].isEmpty()) {

                    position = new Position((char) ('a' + c), d + 1);
                    this.board3[c][d] = new Cell3(position, new Indice_bleu_rouge(position, pictureFile2));
                    if (!this.board3[c][d].isEmpty()) {
                        this.board3[c][d].getCurrentCarte().draw();
                    }
                    compt3 = compt3 + 1;
                    System.out.println("compt3 = " + compt3);
                    printBoard();

                }
            }


            if (pictureFile2 == "img/indice_bleu_vert_rouge.png" & StdDraw.isMousePressed() & StdDraw.mouseX() >= 0 & StdDraw.mouseX() < 16 & StdDraw.mouseY() >= 0 & StdDraw.mouseY() < 16) {

                int c = (int) Math.abs((StdDraw.mouseX()));
                int d = (int) Math.abs((StdDraw.mouseY()));
                System.out.println("c =" + c);
                System.out.println("d =" + d);

                if (!this.board[c][d].isEmpty()) {

                    position = new Position((char) ('a' + c), d + 1);
                    this.board3[c][d] = new Cell3(position, new Indice_bleu_vert_rouge(position, pictureFile2));
                    if (!this.board3[c][d].isEmpty()) {
                        this.board3[c][d].getCurrentCarte().draw();
                    }
                    compt3 = compt3 + 1;
                    System.out.println("compt3 = " + compt3);
                    printBoard();

                }
            }


            if (pictureFile2 == "img/indice_bleu_vert_violet.png" & StdDraw.isMousePressed() & StdDraw.mouseX() >= 0 & StdDraw.mouseX() < 16 & StdDraw.mouseY() >= 0 & StdDraw.mouseY() < 16) {

                int c = (int) Math.abs((StdDraw.mouseX()));
                int d = (int) Math.abs((StdDraw.mouseY()));
                System.out.println("c =" + c);
                System.out.println("d =" + d);

                if (!this.board[c][d].isEmpty()) {

                    position = new Position((char) ('a' + c), d + 1);
                    this.board3[c][d] = new Cell3(position, new Indice_bleu_vert_violet(position, pictureFile2));
                    if (!this.board3[c][d].isEmpty()) {
                        this.board3[c][d].getCurrentCarte().draw();
                    }
                    compt3 = compt3 + 1;
                    System.out.println("compt3 = " + compt3);
                    printBoard();

                }
            }


            if (pictureFile2 == "img/indice_bleu_violet.png" & StdDraw.isMousePressed() & StdDraw.mouseX() >= 0 & StdDraw.mouseX() < 16 & StdDraw.mouseY() >= 0 & StdDraw.mouseY() < 16) {

                int c = (int) Math.abs((StdDraw.mouseX()));
                int d = (int) Math.abs((StdDraw.mouseY()));
                System.out.println("c =" + c);
                System.out.println("d =" + d);

                if (!this.board[c][d].isEmpty()) {

                    position = new Position((char) ('a' + c), d + 1);
                    this.board3[c][d] = new Cell3(position, new Indice_bleu_violet(position, pictureFile2));
                    if (!this.board3[c][d].isEmpty()) {
                        this.board3[c][d].getCurrentCarte().draw();
                    }
                    compt3 = compt3 + 1;
                    System.out.println("compt3 = " + compt3);
                    printBoard();

                }
            }


            if (pictureFile2 == "img/indice_bleu_violet_rouge.png" & StdDraw.isMousePressed() & StdDraw.mouseX() >= 0 & StdDraw.mouseX() < 16 & StdDraw.mouseY() >= 0 & StdDraw.mouseY() < 16) {

                int c = (int) Math.abs((StdDraw.mouseX()));
                int d = (int) Math.abs((StdDraw.mouseY()));
                System.out.println("c =" + c);
                System.out.println("d =" + d);

                if (!this.board[c][d].isEmpty()) {

                    position = new Position((char) ('a' + c), d + 1);
                    this.board3[c][d] = new Cell3(position, new Indice_bleu_violet_rouge(position, pictureFile2));
                    if (!this.board3[c][d].isEmpty()) {
                        this.board3[c][d].getCurrentCarte().draw();
                    }
                    compt3 = compt3 + 1;
                    System.out.println("compt3 = " + compt3);
                    printBoard();
                }

            }


            if (pictureFile2 == "img/indice_rouge.png" & StdDraw.isMousePressed() & StdDraw.mouseX() >= 0 & StdDraw.mouseX() < 16 & StdDraw.mouseY() >= 0 & StdDraw.mouseY() < 16) {

                int c = (int) Math.abs((StdDraw.mouseX()));
                int d = (int) Math.abs((StdDraw.mouseY()));
                System.out.println("c =" + c);
                System.out.println("d =" + d);

                if (!this.board[c][d].isEmpty()) {

                    position = new Position((char) ('a' + c), d + 1);
                    this.board3[c][d] = new Cell3(position, new Indice_rouge(position, pictureFile2));
                    if (!this.board3[c][d].isEmpty()) {
                        this.board3[c][d].getCurrentCarte().draw();
                    }
                    compt3 = compt3 + 1;
                    System.out.println("compt3 = " + compt3);
                    printBoard();

                }

            }

            if (pictureFile2 == "img/indice_rouge_violet.png" & StdDraw.isMousePressed() & StdDraw.mouseX() >= 0 & StdDraw.mouseX() < 16 & StdDraw.mouseY() >= 0 & StdDraw.mouseY() < 16) {

                int c = (int) Math.abs((StdDraw.mouseX()));
                int d = (int) Math.abs((StdDraw.mouseY()));
                System.out.println("c =" + c);
                System.out.println("d =" + d);

                if (!this.board[c][d].isEmpty()) {

                    position = new Position((char) ('a' + c), d + 1);
                    this.board3[c][d] = new Cell3(position, new Indice_rouge_violet(position, pictureFile2));
                    if (!this.board3[c][d].isEmpty()) {
                        this.board3[c][d].getCurrentCarte().draw();
                    }
                    compt3 = compt3 + 1;
                    System.out.println("compt3 = " + compt3);
                    printBoard();
                }
            }

            if (pictureFile2 == "img/indice_vert.png" & StdDraw.isMousePressed() & StdDraw.mouseX() >= 0 & StdDraw.mouseX() < 16 & StdDraw.mouseY() >= 0 & StdDraw.mouseY() < 16) {

                int c = (int) Math.abs((StdDraw.mouseX()));
                int d = (int) Math.abs((StdDraw.mouseY()));
                System.out.println("c =" + c);
                System.out.println("d =" + d);

                if (!this.board[c][d].isEmpty()) {

                    position = new Position((char) ('a' + c), d + 1);
                    this.board3[c][d] = new Cell3(position, new Indice_vert(position, pictureFile2));
                    if (!this.board3[c][d].isEmpty()) {
                        this.board3[c][d].getCurrentCarte().draw();
                    }
                    compt3 = compt3 + 1;
                    System.out.println("compt3 = " + compt3);
                    printBoard();
                }



            }

            if (pictureFile2 == "img/indice_vert_rouge.png" & StdDraw.isMousePressed() & StdDraw.mouseX() >= 0 & StdDraw.mouseX() < 16 & StdDraw.mouseY() >= 0 & StdDraw.mouseY() < 16) {

                int c = (int) Math.abs((StdDraw.mouseX()));
                int d = (int) Math.abs((StdDraw.mouseY()));
                System.out.println("c =" + c);
                System.out.println("d =" + d);

                if (!this.board[c][d].isEmpty()) {

                    position = new Position((char) ('a' + c), d + 1);
                    this.board3[c][d] = new Cell3(position, new Indice_vert_rouge(position, pictureFile2));
                    if (!this.board3[c][d].isEmpty()) {
                        this.board3[c][d].getCurrentCarte().draw();
                    }
                    compt3 = compt3 + 1;
                    System.out.println("compt3 = " + compt3);
                    printBoard();
                }
            }

            if (pictureFile2 == "img/indice_vert_violet.png" & StdDraw.isMousePressed() & StdDraw.mouseX() >= 0 & StdDraw.mouseX() < 16 & StdDraw.mouseY() >= 0 & StdDraw.mouseY() < 16) {

                int c = (int) Math.abs((StdDraw.mouseX()));
                int d = (int) Math.abs((StdDraw.mouseY()));
                System.out.println("c =" + c);
                System.out.println("d =" + d);

                if (!this.board[c][d].isEmpty()) {

                    position = new Position((char) ('a' + c), d + 1);
                    this.board3[c][d] = new Cell3(position, new Indice_vert_violet(position, pictureFile2));
                    if (!this.board3[c][d].isEmpty()) {
                        this.board3[c][d].getCurrentCarte().draw();
                    }
                    compt3 = compt3 + 1;
                    System.out.println("compt3 = " + compt3);
                    printBoard();
                }
            }

            if (pictureFile2 == "img/indice_vert_violet_rouge.png" & StdDraw.isMousePressed() & StdDraw.mouseX() >= 0 & StdDraw.mouseX() < 16 & StdDraw.mouseY() >= 0 & StdDraw.mouseY() < 16) {

                int c = (int) Math.abs((StdDraw.mouseX()));
                int d = (int) Math.abs((StdDraw.mouseY()));
                System.out.println("c =" + c);
                System.out.println("d =" + d);

                if (!this.board[c][d].isEmpty()) {

                    position = new Position((char) ('a' + c), d + 1);
                    this.board3[c][d] = new Cell3(position, new Indice_vert_violet_rouge(position, pictureFile2));
                    if (!this.board3[c][d].isEmpty()) {
                        this.board3[c][d].getCurrentCarte().draw();
                    }
                    compt3 = compt3 + 1;
                    System.out.println("compt3 = " + compt3);
                    printBoard();
                }

            }

            if (pictureFile2 == "img/indice_violet.png" & StdDraw.isMousePressed() & StdDraw.mouseX() >= 0 & StdDraw.mouseX() < 16 & StdDraw.mouseY() >= 0 & StdDraw.mouseY() < 16) {

                int c = (int) Math.abs((StdDraw.mouseX()));
                int d = (int) Math.abs((StdDraw.mouseY()));
                System.out.println("c =" + c);
                System.out.println("d =" + d);

                if (!this.board[c][d].isEmpty()) {

                    position = new Position((char) ('a' + c), d + 1);
                    this.board3[c][d] = new Cell3(position, new Indice_violet(position, pictureFile2));
                    if (!this.board3[c][d].isEmpty()) {
                        this.board3[c][d].getCurrentCarte().draw();
                    }
                    compt3 = compt3 + 1;
                    System.out.println("compt3 = " + compt3);
                    printBoard();
                }



            }
            if (compt3 >= 1) {
                change3 = false;

            }




        }


    }
}
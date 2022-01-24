package louisyokai;

import java.util.*;

public class Plateau {

    private Cell[][] board;
    private Cell2[][] board2;
    private Cell3[][] board3;
    private Player[] players;
    private Player currentPlayer;
    private boolean change = true;
    private boolean change2 = true;
    private boolean change3 = true;
    private boolean change4 = true;
    private boolean button = true;
    private boolean fini = true;

    private boolean fin = true;
    private String pictureFile;
    private String pictureFile2;
    int compt = 0;
    int compt2 = 0;
    int compt3 = 0;
    int i = 2;
    int test = 0;
    int test2 = 0;
    int n = 0;


    // On decrit brievement la logique du jeu
    public void play() {
        System.out.println("Bienvenue au jeu du Yokai , commencez par regarder deux cartes !");

        initialiseBoard();

        while (fin) {
            printBoard();
            change = true;
            button = true;
            change2 = true;
            change3 = true;
            change4 = true;
            compt = 0;
            test = 0;
            test2 = 0;
            compt2 = 0;
            compt3 = 0;
            fini = true;

        }
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

        ArrayList<Integer> listY = new ArrayList<Integer>();
        for (int i = 6; i < 10; i++) {
            listY.add(i);
        }
        Collections.shuffle(listY);

        // louisyokai.Oni initialisation random

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


        // louisyokai.Kitsune initialisaton random


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


        // louisyokai.Kappa initialisation

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
        StdDraw.setCanvasSize(700, 700);
        StdDraw.setXscale(0, 16);
        StdDraw.setYscale(0, 16);


    }

    private void printBoard() {
        Position position;
        Carte currentCarte;

        // background

        StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
        StdDraw.filledSquare(16, 16, 16);

        // emplacements indices

        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.filledRectangle(8, 14.5, 3, 0.5);

        // bouton retourner les cartes

        StdDraw.setPenColor(StdDraw.GREEN);
        StdDraw.filledRectangle(8, 3, 1, 0.5);

        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.text(8, 3, "CLICK");

        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.text(14, 14.5, "Jeu du Yokai");


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


        while (change) {
            StdDraw.setPenColor(StdDraw.RED);
            StdDraw.text(8, 0.5, "Regardez 2 cartes Yokai");

            boolean termine = false;


            if (StdDraw.isMousePressed() && termine != true & StdDraw.mouseX() >= 0 & StdDraw.mouseX() < 16 & StdDraw.mouseY() >= 0 & StdDraw.mouseY() < 16) {

                int c = (int) Math.abs((StdDraw.mouseX()));
                int d = (int) Math.abs((StdDraw.mouseY()));
                termine = true;

                if (!this.board2[c][d].isEmpty()) {

                    compt = compt + 1;


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

        while (button) {

            StdDraw.setPenColor(StdDraw.RED);
            StdDraw.text(8, 0.5, "Memorisez les cartes et cliquez sur le bouton (click) pour les retourner");

            boolean termine = false;
            if (StdDraw.isMousePressed() && termine != true & StdDraw.mouseX() >= 7 & StdDraw.mouseX() < 9 & StdDraw.mouseY() >= 2.5 & StdDraw.mouseY() < 3.5) {

                termine = true;
                test = test + 1;

                for (int col = 0; col < 14; col++) {
                    for (int lig = 0; lig < 16; lig++) {

                        if (!this.board[col][lig].isEmpty() && this.board2[col][lig].isEmpty()) {


                            position = new Position((char) ('a' + col), lig + 1);
                            this.board2[col][lig] = new Cell2(position, new Dos(position, pictureFile));


                        }

                    }
                }

            }

            if (test >= 1) {
                button = false;
                printBoard();
            }
        }


        while (change2) {

            StdDraw.setPenColor(StdDraw.BLACK);



            //fonction qui regarde si celle adjacente est ok
            ArrayList<Integer> listCoor = new ArrayList<Integer>();

            ArrayList<Integer> listX = new ArrayList<Integer>();
            ArrayList<Integer> listY = new ArrayList<Integer>();


            for (int col = 0; col < 15; col++) {
                for (int lig = 0; lig < 15; lig++) {

                    if (!this.board[lig][col].isEmpty()) {

                        int x = lig;
                        int y = col;
                        listCoor.add(x);
                        listCoor.add(y);
                    }
                }
            }


            for (int i = 2; i < listCoor.size(); i = i + 2) {

                if (this.board[listCoor.get(i) + 1][listCoor.get(i + 1)].isEmpty()) {

                    StdDraw.filledSquare(listCoor.get(i) + 1 + 0.5, listCoor.get(i + 1) + 0.5, 0.5);
                    listX.add(listCoor.get(i) + 1);
                    listY.add(listCoor.get(i + 1));
                }

                if (this.board[listCoor.get(i)][listCoor.get(i + 1) + 1].isEmpty()) {

                    StdDraw.filledSquare(listCoor.get(i) + 0.5, listCoor.get(i + 1) + 1 + 0.5, 0.5);
                    listX.add(listCoor.get(i));
                    listY.add(listCoor.get(i + 1) + 1);
                }

                if (this.board[listCoor.get(i) - 1][listCoor.get(i + 1)].isEmpty()) {

                    StdDraw.filledSquare(listCoor.get(i) - 1 + 0.5, listCoor.get(i + 1) + 0.5, 0.5);
                    listX.add(listCoor.get(i) - 1);
                    listY.add(listCoor.get(i + 1));
                }
                if (this.board[listCoor.get(i)][listCoor.get(i + 1) - 1].isEmpty()) {

                    StdDraw.filledSquare(listCoor.get(i) + 0.5, listCoor.get(i + 1) - 1 + 0.5, 0.5);
                    listX.add(listCoor.get(i));
                    listY.add(listCoor.get(i + 1) - 1);

                }
            }


            while (change3) {

                StdDraw.setPenColor(StdDraw.BLUE);


                StdDraw.text(8, 0.5, "Deplacez une carte Yokai");

                boolean termine = false;


                if (StdDraw.isMousePressed() && termine != true & StdDraw.mouseX() >= 0 & StdDraw.mouseX() < 16 & StdDraw.mouseY() >= 0 & StdDraw.mouseY() < 14) {

                    int a = (int) Math.abs((StdDraw.mouseX()));
                    int b = (int) Math.abs((StdDraw.mouseY()));


                    if (!this.board[a][b].isEmpty()) {

                        compt2 = compt2 + 1;
                        termine = true;

                        pictureFile2 = this.board[a][b].currentCarte.getPictureFile();

                        position = new Position((char) ('a' + a), b + 1);
                        this.board[a][b] = new Cell(null, null);
                        this.board2[a][b] = new Cell2(null, null);
                        printBoard();

                    }
                }

                for (int x = 0; x < listX.size(); x++) {
                    for (int y = 0; y < listY.size(); y++) {


                        if (pictureFile2 == "img/rokurokubi_carte.png" & StdDraw.isMousePressed() & (int) Math.abs(StdDraw.mouseX()) == listX.get(x) & (int) Math.abs(StdDraw.mouseY()) == listY.get(y)) {

                            int c = (int) Math.abs((StdDraw.mouseX()));
                            int d = (int) Math.abs((StdDraw.mouseY()));


                            if (this.board[c][d].isEmpty()) {

                                position = new Position((char) ('a' + c), d + 1);
                                this.board[c][d] = new Cell(position, new Rokurokubi(position, pictureFile2));
                                this.board2[c][d] = new Cell2(position, new Dos(position, pictureFile2));
                            }
                            if (!this.board[c][d].isEmpty()) {
                                this.board[c][d].getCurrentCarte().draw();
                            }
                            if (!this.board2[c][d].isEmpty()) {
                                this.board2[c][d].getCurrentCarte().draw();
                            }


                            compt2 = compt2 + 1;
                            printBoard();

                        }


                        if (pictureFile2 == "img/kitsune_carte.png" & StdDraw.isMousePressed() & (int) Math.abs(StdDraw.mouseX()) == listX.get(x) & (int) Math.abs(StdDraw.mouseY()) == listY.get(y)) {

                            int c = (int) Math.abs((StdDraw.mouseX()));
                            int d = (int) Math.abs((StdDraw.mouseY()));


                            if (this.board[c][d].isEmpty()) {

                                position = new Position((char) ('a' + c), d + 1);
                                this.board[c][d] = new Cell(position, new Kitsune(position, pictureFile2));
                                this.board2[c][d] = new Cell2(position, new Dos(position, pictureFile2));
                            }
                            if (!this.board[c][d].isEmpty()) {
                                this.board[c][d].getCurrentCarte().draw();
                            }
                            if (!this.board2[c][d].isEmpty()) {
                                this.board2[c][d].getCurrentCarte().draw();
                            }

                            compt2 = compt2 + 1;
                            printBoard();
                        }


                        if (pictureFile2 == "img/oni_carte.png" & StdDraw.isMousePressed() & (int) Math.abs(StdDraw.mouseX()) == listX.get(x) & (int) Math.abs(StdDraw.mouseY()) == listY.get(y)) {

                            int c = (int) Math.abs((StdDraw.mouseX()));
                            int d = (int) Math.abs((StdDraw.mouseY()));


                            if (this.board[c][d].isEmpty()) {


                                position = new Position((char) ('a' + c), d + 1);
                                this.board[c][d] = new Cell(position, new Oni(position, pictureFile2));
                                this.board2[c][d] = new Cell2(position, new Dos(position, pictureFile2));
                            }
                            if (!this.board[c][d].isEmpty()) {
                                this.board[c][d].getCurrentCarte().draw();
                            }
                            if (!this.board2[c][d].isEmpty()) {
                                this.board2[c][d].getCurrentCarte().draw();
                            }

                            compt2 = compt2 + 1;
                            printBoard();
                        }

                        if (pictureFile2 == "img/kappa_carte.png" & StdDraw.isMousePressed() & (int) Math.abs(StdDraw.mouseX()) == listX.get(x) & (int) Math.abs(StdDraw.mouseY()) == listY.get(y)) {

                            int c = (int) Math.abs((StdDraw.mouseX()));
                            int d = (int) Math.abs((StdDraw.mouseY()));


                            if (this.board[c][d].isEmpty()) {
                                position = new Position((char) ('a' + c), d + 1);
                                this.board[c][d] = new Cell(position, new Kappa(position, pictureFile2));
                                this.board2[c][d] = new Cell2(position, new Dos(position, pictureFile2));
                            }
                            if (!this.board[c][d].isEmpty()) {
                                this.board[c][d].getCurrentCarte().draw();
                            }
                            if (!this.board2[c][d].isEmpty()) {
                                this.board2[c][d].getCurrentCarte().draw();
                            }

                            compt2 = compt2 + 1;
                            printBoard();
                        }

                    }
                }

                if (compt2 > 1) {
                    change3 = false;
                    printBoard();

                }
            }
            change2 = false;
        }


        boolean termine = false;

        while (change4) {
            StdDraw.setPenColor(StdDraw.GREEN);
            StdDraw.text(7, 0.5, "Revelez ou deplacez une carte indice");


            if (StdDraw.isMousePressed() && termine != true && StdDraw.mouseX() >= 3 & StdDraw.mouseX() < 4 & StdDraw.mouseY() >= 14 & StdDraw.mouseY() < 15) {


                int a = (int) Math.abs((StdDraw.mouseX()));
                int b = (int) Math.abs((StdDraw.mouseY()));

                if (!this.board3[a + i][b].isEmpty()) {
                    i = i + 1;
                }
                termine = true;

                int random = (int) (Math.random() * 12);


                    position = new Position((char) ('a' + (a + i)), b + 1);


                    if (random == 0) {
                        this.board3[a + i][b] = new Cell3(position, new Indice_bleu(position, pictureFile));
                    }
                    if (random == 1) {
                        this.board3[a + i][b] = new Cell3(position, new Indice_bleu_vert_rouge(position, pictureFile));
                    }
                    if (random == 2) {
                        this.board3[a + i][b] = new Cell3(position, new Indice_bleu_vert_violet(position, pictureFile));
                    }
                    if (random == 3) {
                        this.board3[a + i][b] = new Cell3(position, new Indice_bleu_violet(position, pictureFile));
                    }
                    if (random == 4) {
                        this.board3[a + i][b] = new Cell3(position, new Indice_bleu_violet_rouge(position, pictureFile));
                    }
                    if (random == 5) {
                        this.board3[a + i][b] = new Cell3(position, new Indice_rouge(position, pictureFile));
                    }
                    if (random == 6) {
                        this.board3[a + i][b] = new Cell3(position, new Indice_rouge_violet(position, pictureFile));
                    }
                    if (random == 7) {
                        this.board3[a + i][b] = new Cell3(position, new Indice_vert(position, pictureFile));
                    }
                    if (random == 8) {
                        this.board3[a + i][b] = new Cell3(position, new Indice_vert_bleu(position, pictureFile));
                    }
                    if (random == 9) {
                        this.board3[a + i][b] = new Cell3(position, new Indice_vert_rouge(position, pictureFile));
                    }
                    if (random == 10) {
                        this.board3[a + i][b] = new Cell3(position, new Indice_vert_violet(position, pictureFile));
                    }
                    if (random == 11) {
                        this.board3[a + i][b] = new Cell3(position, new Indice_vert_violet_rouge(position, pictureFile));
                    }
                    if (random == 12) {
                        this.board3[a + i][b] = new Cell3(position, new Indice_violet(position, pictureFile));
                    }



                    if (!this.board3[a + 2][b].isEmpty()) {
                        this.board3[a + 2][b].getCurrentCarte().draw();

                    }



                change4 = false;
                printBoard();


            }


            for (int col = 5; col < 11; col++) {
                for (int lig = 14; lig < 15; lig++) {


                    if ((!this.board3[col][lig].isEmpty()) && StdDraw.isMousePressed() & StdDraw.mouseX() >= 5 & StdDraw.mouseX() < 11 & StdDraw.mouseY() >= 14 & StdDraw.mouseY() < 15) {

                        int x = (int) Math.abs((StdDraw.mouseX()));
                        int y = (int) Math.abs((StdDraw.mouseY()));


                        if (!this.board3[x][y].isEmpty()) {

                            pictureFile2 = this.board3[x][y].currentCarte.getPictureFile();
                        }
                        this.board3[x][y] = new Cell3(null, null);
                        printBoard();
                    }
                }
            }


            if (pictureFile2 == "img/indice_vert_bleu.png" & StdDraw.isMousePressed() & StdDraw.mouseX() >= 0 & StdDraw.mouseX() < 16 & StdDraw.mouseY() >= 0 & StdDraw.mouseY() < 16) {

                int c = (int) Math.abs((StdDraw.mouseX()));
                int d = (int) Math.abs((StdDraw.mouseY()));


                if (!this.board[c][d].isEmpty()) {

                    position = new Position((char) ('a' + c), d + 1);
                    this.board3[c][d] = new Cell3(position, new Indice_vert_bleu(position, pictureFile2));
                    if (!this.board3[c][d].isEmpty()) {
                        this.board3[c][d].getCurrentCarte().draw();
                    }
                    compt3 = compt3 + 1;
                    printBoard();

                }

            }


            if (pictureFile2 == "img/indice_bleu.png" & StdDraw.isMousePressed() & StdDraw.mouseX() >= 0 & StdDraw.mouseX() < 16 & StdDraw.mouseY() >= 0 & StdDraw.mouseY() < 16) {

                int c = (int) Math.abs((StdDraw.mouseX()));
                int d = (int) Math.abs((StdDraw.mouseY()));

                if (!this.board[c][d].isEmpty()) {

                    position = new Position((char) ('a' + c), d + 1);
                    this.board3[c][d] = new Cell3(position, new Indice_bleu(position, pictureFile2));
                    if (!this.board3[c][d].isEmpty()) {
                        this.board3[c][d].getCurrentCarte().draw();
                    }
                    compt3 = compt3 + 1;

                    printBoard();

                }
            }


            if (pictureFile2 == "img/indice_bleu_rouge.png" & StdDraw.isMousePressed() & StdDraw.mouseX() >= 0 & StdDraw.mouseX() < 16 & StdDraw.mouseY() >= 0 & StdDraw.mouseY() < 16) {

                int c = (int) Math.abs((StdDraw.mouseX()));
                int d = (int) Math.abs((StdDraw.mouseY()));

                if (!this.board[c][d].isEmpty()) {

                    position = new Position((char) ('a' + c), d + 1);
                    this.board3[c][d] = new Cell3(position, new Indice_bleu_rouge(position, pictureFile2));
                    if (!this.board3[c][d].isEmpty()) {
                        this.board3[c][d].getCurrentCarte().draw();
                    }
                    compt3 = compt3 + 1;
                    printBoard();

                }
            }


            if (pictureFile2 == "img/indice_bleu_vert_rouge.png" & StdDraw.isMousePressed() & StdDraw.mouseX() >= 0 & StdDraw.mouseX() < 16 & StdDraw.mouseY() >= 0 & StdDraw.mouseY() < 16) {

                int c = (int) Math.abs((StdDraw.mouseX()));
                int d = (int) Math.abs((StdDraw.mouseY()));


                if (!this.board[c][d].isEmpty()) {

                    position = new Position((char) ('a' + c), d + 1);
                    this.board3[c][d] = new Cell3(position, new Indice_bleu_vert_rouge(position, pictureFile2));
                    if (!this.board3[c][d].isEmpty()) {
                        this.board3[c][d].getCurrentCarte().draw();
                    }
                    compt3 = compt3 + 1;
                    printBoard();

                }
            }


            if (pictureFile2 == "img/indice_bleu_vert_violet.png" & StdDraw.isMousePressed() & StdDraw.mouseX() >= 0 & StdDraw.mouseX() < 16 & StdDraw.mouseY() >= 0 & StdDraw.mouseY() < 16) {

                int c = (int) Math.abs((StdDraw.mouseX()));
                int d = (int) Math.abs((StdDraw.mouseY()));

                if (!this.board[c][d].isEmpty()) {

                    position = new Position((char) ('a' + c), d + 1);
                    this.board3[c][d] = new Cell3(position, new Indice_bleu_vert_violet(position, pictureFile2));
                    if (!this.board3[c][d].isEmpty()) {
                        this.board3[c][d].getCurrentCarte().draw();
                    }
                    compt3 = compt3 + 1;
                    printBoard();

                }
            }


            if (pictureFile2 == "img/indice_bleu_violet.png" & StdDraw.isMousePressed() & StdDraw.mouseX() >= 0 & StdDraw.mouseX() < 16 & StdDraw.mouseY() >= 0 & StdDraw.mouseY() < 16) {

                int c = (int) Math.abs((StdDraw.mouseX()));
                int d = (int) Math.abs((StdDraw.mouseY()));

                if (!this.board[c][d].isEmpty()) {

                    position = new Position((char) ('a' + c), d + 1);
                    this.board3[c][d] = new Cell3(position, new Indice_bleu_violet(position, pictureFile2));
                    if (!this.board3[c][d].isEmpty()) {
                        this.board3[c][d].getCurrentCarte().draw();
                    }
                    compt3 = compt3 + 1;
                    printBoard();

                }
            }


            if (pictureFile2 == "img/indice_bleu_violet_rouge.png" & StdDraw.isMousePressed() & StdDraw.mouseX() >= 0 & StdDraw.mouseX() < 16 & StdDraw.mouseY() >= 0 & StdDraw.mouseY() < 16) {

                int c = (int) Math.abs((StdDraw.mouseX()));
                int d = (int) Math.abs((StdDraw.mouseY()));

                if (!this.board[c][d].isEmpty()) {

                    position = new Position((char) ('a' + c), d + 1);
                    this.board3[c][d] = new Cell3(position, new Indice_bleu_violet_rouge(position, pictureFile2));
                    if (!this.board3[c][d].isEmpty()) {
                        this.board3[c][d].getCurrentCarte().draw();
                    }
                    compt3 = compt3 + 1;
                    printBoard();
                }

            }


            if (pictureFile2 == "img/indice_rouge.png" & StdDraw.isMousePressed() & StdDraw.mouseX() >= 0 & StdDraw.mouseX() < 16 & StdDraw.mouseY() >= 0 & StdDraw.mouseY() < 16) {

                int c = (int) Math.abs((StdDraw.mouseX()));
                int d = (int) Math.abs((StdDraw.mouseY()));

                if (!this.board[c][d].isEmpty()) {

                    position = new Position((char) ('a' + c), d + 1);
                    this.board3[c][d] = new Cell3(position, new Indice_rouge(position, pictureFile2));
                    if (!this.board3[c][d].isEmpty()) {
                        this.board3[c][d].getCurrentCarte().draw();
                    }
                    compt3 = compt3 + 1;
                    printBoard();

                }

            }

            if (pictureFile2 == "img/indice_rouge_violet.png" & StdDraw.isMousePressed() & StdDraw.mouseX() >= 0 & StdDraw.mouseX() < 16 & StdDraw.mouseY() >= 0 & StdDraw.mouseY() < 16) {

                int c = (int) Math.abs((StdDraw.mouseX()));
                int d = (int) Math.abs((StdDraw.mouseY()));

                if (!this.board[c][d].isEmpty()) {

                    position = new Position((char) ('a' + c), d + 1);
                    this.board3[c][d] = new Cell3(position, new Indice_rouge_violet(position, pictureFile2));
                    if (!this.board3[c][d].isEmpty()) {
                        this.board3[c][d].getCurrentCarte().draw();
                    }
                    compt3 = compt3 + 1;
                    printBoard();
                }
            }

            if (pictureFile2 == "img/indice_vert.png" & StdDraw.isMousePressed() & StdDraw.mouseX() >= 0 & StdDraw.mouseX() < 16 & StdDraw.mouseY() >= 0 & StdDraw.mouseY() < 16) {

                int c = (int) Math.abs((StdDraw.mouseX()));
                int d = (int) Math.abs((StdDraw.mouseY()));

                if (!this.board[c][d].isEmpty()) {

                    position = new Position((char) ('a' + c), d + 1);
                    this.board3[c][d] = new Cell3(position, new Indice_vert(position, pictureFile2));
                    if (!this.board3[c][d].isEmpty()) {
                        this.board3[c][d].getCurrentCarte().draw();
                    }
                    compt3 = compt3 + 1;
                    printBoard();
                }


            }

            if (pictureFile2 == "img/indice_vert_rouge.png" & StdDraw.isMousePressed() & StdDraw.mouseX() >= 0 & StdDraw.mouseX() < 16 & StdDraw.mouseY() >= 0 & StdDraw.mouseY() < 16) {

                int c = (int) Math.abs((StdDraw.mouseX()));
                int d = (int) Math.abs((StdDraw.mouseY()));

                if (!this.board[c][d].isEmpty()) {

                    position = new Position((char) ('a' + c), d + 1);
                    this.board3[c][d] = new Cell3(position, new Indice_vert_rouge(position, pictureFile2));
                    if (!this.board3[c][d].isEmpty()) {
                        this.board3[c][d].getCurrentCarte().draw();
                    }
                    compt3 = compt3 + 1;
                    printBoard();
                }
            }

            if (pictureFile2 == "img/indice_vert_violet.png" & StdDraw.isMousePressed() & StdDraw.mouseX() >= 0 & StdDraw.mouseX() < 16 & StdDraw.mouseY() >= 0 & StdDraw.mouseY() < 16) {

                int c = (int) Math.abs((StdDraw.mouseX()));
                int d = (int) Math.abs((StdDraw.mouseY()));


                if (!this.board[c][d].isEmpty()) {

                    position = new Position((char) ('a' + c), d + 1);
                    this.board3[c][d] = new Cell3(position, new Indice_vert_violet(position, pictureFile2));
                    if (!this.board3[c][d].isEmpty()) {
                        this.board3[c][d].getCurrentCarte().draw();
                    }
                    compt3 = compt3 + 1;
                    printBoard();
                }
            }

            if (pictureFile2 == "img/indice_vert_violet_rouge.png" & StdDraw.isMousePressed() & StdDraw.mouseX() >= 0 & StdDraw.mouseX() < 16 & StdDraw.mouseY() >= 0 & StdDraw.mouseY() < 16) {

                int c = (int) Math.abs((StdDraw.mouseX()));
                int d = (int) Math.abs((StdDraw.mouseY()));

                if (!this.board[c][d].isEmpty()) {

                    position = new Position((char) ('a' + c), d + 1);
                    this.board3[c][d] = new Cell3(position, new Indice_vert_violet_rouge(position, pictureFile2));
                    if (!this.board3[c][d].isEmpty()) {
                        this.board3[c][d].getCurrentCarte().draw();
                    }
                    compt3 = compt3 + 1;
                    printBoard();
                }

            }

            if (pictureFile2 == "img/indice_violet.png" & StdDraw.isMousePressed() & StdDraw.mouseX() >= 0 & StdDraw.mouseX() < 16 & StdDraw.mouseY() >= 0 & StdDraw.mouseY() < 16) {

                int c = (int) Math.abs((StdDraw.mouseX()));
                int d = (int) Math.abs((StdDraw.mouseY()));

                if (!this.board[c][d].isEmpty()) {

                    position = new Position((char) ('a' + c), d + 1);
                    this.board3[c][d] = new Cell3(position, new Indice_violet(position, pictureFile2));
                    if (!this.board3[c][d].isEmpty()) {
                        this.board3[c][d].getCurrentCarte().draw();
                    }
                    compt3 = compt3 + 1;
                    printBoard();
                }
            }
            if (compt3 >= 1) {
                change4 = false;
                printBoard();
            }
        }

        while (fini) {

            StdDraw.setPenColor(StdDraw.RED);
            StdDraw.text(8, 0.5, "Avez vous terminé votre partie et souhaitez vous  devoiler les cartes");


            StdDraw.setPenColor(StdDraw.GREEN);
            StdDraw.filledRectangle(6, 1.5, 1, 0.5);

            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.text(6, 1.5, "OUI");

            StdDraw.setPenColor(StdDraw.RED);
            StdDraw.filledRectangle(10, 1.5, 1, 0.5);

            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.text(10, 1.5, "NON");



            termine = false;
            if (StdDraw.isMousePressed() && termine != true & StdDraw.mouseX() >= 5 & StdDraw.mouseX() < 7 & StdDraw.mouseY() >= 1 & StdDraw.mouseY() < 2) {

                termine = true;
                test2 = test2 + 1;
                for (int col = 0; col < 16; col++) {
                    for (int lig = 0; lig < 16; lig++) {

                        if (!this.board2[col][lig].isEmpty()) {




                            position = new Position((char) ('a' + col), lig + 1);
                            this.board2[col][lig] = new Cell2(null, null);
                            this.board3[col][lig] = new Cell3(null, null);

//                            pictureFile  = this.board[col][lig].currentCarte.getPictureFile();
//
//                            ArrayList<Integer> listbleu = new ArrayList<Integer>();
//
//                            if(pictureFile == "img/oni_carte.png"){
//
//                                int x = col;
//                                int y = lig;
//
//                                System.out.println("x=" + x + "y = " + y);
//
//                                ArrayList<Integer>  a =  test(x,y);
//                                System.out.println(a);
//
//                                 for (int i = 0; i< a.size(); i=i+2){
//                                     if( x == a.get(i) ){
//                                         System.out.println(a.get(i) + "test" +  a.get(i+1));
//                                     }
//                                 }
//
//                        }

                        }


                    }

                }
            }


            if (StdDraw.isMousePressed() & StdDraw.mouseX() >= 9 & StdDraw.mouseX() < 11 & StdDraw.mouseY() >= 1 & StdDraw.mouseY() < 2) {
                fini = false;

            }
            if (test2 >= 1) {
                fini = false;
                fin = false;
                printBoard();
                StdDraw.setPenColor(StdDraw.RED);
                StdDraw.text(8, 0.5, "La partie est terminée merci d'avoir joué !");
                System.out.println("La partie est terminée merci d'avoir joué !");

            }
        }
    }
}




//    public ArrayList<Integer> test(int x, int y) {
//
//        int x1 = x;
//        int y1 = y+1;
//
//        int x2 = x+1;
//        int y2 = y;
//
//        int x3 = x;
//        int y3 = y-1;
//
//        int x4 = x-1;
//        int y4 = y;
//
//        ArrayList<Integer> listXY = new ArrayList<Integer>();
//        listXY.add(x1) ;
//        listXY.add(y1) ;
//        listXY.add(x2) ;
//        listXY.add(y2) ;
//        listXY.add(x3) ;
//        listXY.add(y3) ;
//        listXY.add( x4) ;
//        listXY.add(y4) ;
//
//
//        return(listXY);
//
//
//    }



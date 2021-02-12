package GameOfLive;

import java.io.IOException;
import java.util.*;

public class Game {
    private Random random = new Random();
    Timer timer = new Timer();
    private static Cell[][] field;

    private int fieldCount = 30; //HOW BIG SHOULD YOUR FIELD BE?
    private int initStartLiveCount = 120; //CHANGE HOW MUCH CELLS SHOULD BE ALIVE AT THE BEGINNING

    private int seconds = 0;
    private int generation = 1;
    private long tempNeighbourCount = 0;

    public void run() {
        System.out.println("test");
        worldInit();
        startTimer();
    }

    private void checkNeighbour() {

        for (var x = 0; x < field.length; x++) {
            for (var y = 0; y < field[0].length; y++) {
                getNeighboursAliveCount(x,y);

                //4 rules
                if(tempNeighbourCount < 2) {
                    field[x][y].setAlive(false);
                }
                if(tempNeighbourCount > 3) {
                    field[x][y].setAlive(false);
                }
                if(tempNeighbourCount == 2 || tempNeighbourCount == 3) {
                    if(field[x][y].isAlive) {
                        field[x][y].setAlive(true);
                    }
                }
                if(tempNeighbourCount == 3) {
                    field[x][y].setAlive(true);
                }
                tempNeighbourCount = 0;
            }
        }
    }


    private void getNeighboursAliveCount(int x, int y) {
        var list = new ArrayList<Cell>();

        for (var colNum = x - 1 ; colNum <= (x + 1) ; colNum +=1  ) {

            for (var rowNum = y - 1 ; rowNum <= (y + 1) ; rowNum +=1  ) {

                if(! ((colNum == x) && (rowNum == y))) {

                    if(withinGrid (colNum, rowNum)) {
                        list.add(field[colNum][rowNum]);
                    }
                }
            }
        }

        tempNeighbourCount = list.stream()
                .filter(c -> c.isAlive)
                .count();
    }

    private boolean withinGrid(int colNum, int rowNum) {

        if((colNum < 0) || (rowNum <0) ) {
            return false;
        }
        if((colNum >= field.length) || (rowNum >= field[0].length)) {
            return false;
        }
        return true;
    }

    private void worldInit() {
        field = new Cell[fieldCount][fieldCount];
        var nonolist = randomList();

        for (int x = 0; x < field.length; x++) {
            for (int y = 0; y < field[0].length; y++) {
                if(nonolist.contains(Integer.parseInt(Integer.toString(x + 1) + Integer.toString(y + 1)))) {
                    field[x][y] = new Cell(true);
                } else {
                    field[x][y] = new Cell();
                }

            }
        }
    }

    private ArrayList<Integer> randomList() {
        var randomsCoord = new ArrayList<Integer>();

        for (var i = 0; i < initStartLiveCount; i++) {
            var x = (Integer.toString(random.nextInt(fieldCount) + 1));
            var y = (Integer.toString(random.nextInt(fieldCount) + 1));


            if (!randomsCoord.contains(Integer.parseInt(x + y))) {
                randomsCoord.add(Integer.parseInt(x + y));
            } else {
                i--;
            }
        }

        return randomsCoord;
    }

    private void update() {
        for (var x = 0; x < field.length; x++) {
            for (var y = 0; y < field[0].length; y++) {
                if(field[x][y].isAlive()) {
                    System.out.print("x ");
                } else {
                    System.out.print("- ");
                }
            }
            System.out.println();
        }
        System.out.println("Gen. " + generation);
        generation++;
    }

    private void startTimer() {
        TimerTask task;

        task = new TimerTask() {

            @Override
            public void run() {
                clearScreen();
                update();
                checkNeighbour();
                seconds++;
                clearScreen();
            }
        };
        timer.schedule(task, 0, 400);
    }

    public static void clearScreen() {
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException ex) {}
    }
}

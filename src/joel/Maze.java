package joel;

import joel.OpenSimplex2S;

import java.util.*;

public class Maze { //My own java implementation of Eller's Maze algorithm, as detailed at http://www.neocomputer.org/projects/eller.html

    OpenSimplex2S noise = new OpenSimplex2S();

    private final int width;
    private final int height;
    private long seed;

    public static int[][] cells;



    Maze(long seed, int width, int height){
        this.width = width;
        this.height = height;
        this.seed = seed;

        cells = new int[height][width];

        genMaze();

    }

    public void genMaze(){
        for (int y = 0; y < height; y++) {
            doRow(y);
        }
    }

    private void doRow(int y){
        if (y == 0) { // first row
            cells[y] = firstRow();
        } else { // y > 0
            if (y == height-1) { // final row
                finalRow(cells[y-1]);
            } else { // middle rows
                middleRow(cells[y-1]);
            }
        }
    }

    private int[] firstRow(){
        int[] workingRow = new int[width];

        // 'join any cells not members of a set to their own unique set'
        for (int i = 0; i < workingRow.length; i++) {
            workingRow[i] = i+1;
        }

        // 'create right walls'
        for (int x = 1; x < workingRow.length; x++) {
            if(noise.noise2_ImproveX(seed, x, 0) > 0) { // y value in noise gen is 0 cause first row
                workingRow[x] = workingRow[x-1]; // 'if we choose not to add a wall, unionise the sets'
            }
        }

        // 'create bottom walls'
        // my implementation describes a bottom wall as the negative version of the set number
        boolean downPassage = false;

        while(!downPassage){
            for (int x = 0; x < workingRow.length; x++) {
                if(noise.noise2_ImproveX(seed, 0-x, 0) > 0) { // y value in noise gen is 0 cause first row
                    workingRow[x] = 0 - workingRow[x];
                    downPassage = true;
                }
            }
        }

        return workingRow;
    }

    private int[] middleRow(int[] inputRow){ // 'create a new row' - step 5.A
        int[] workingRow = inputRow;

        for (int x = 1; x < workingRow.length; x++) {

        }

        return workingRow;
    }

    private int[] newRow(int[] inputRow){ // steps 2-4
        int[] workingRow = inputRow;

        return workingRow;
    }

    private int[] finalRow(int[] inputRow){ // 'complete the maze' - step 5.B
        int[] workingRow = inputRow;

        return workingRow;
    }
}

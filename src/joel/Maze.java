package joel;

import joel.OpenSimplex2S;

import java.util.Random;

public class Maze {

    OpenSimplex2S noise = new OpenSimplex2S();

    private final int width;
    private final int height;
    private long seed;

    public static boolean[][] cells;

    int[][] possibleDirections = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int[] preferredDirection = {1, 0};

    public Maze(long seed, int width, int height){
        this.width = width;
        this.height = height;
        this.seed = seed;


        cells = new boolean[height][width];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                cells[i][j] = true;
            }
        }
    }

    public void setPath(int x, int y){
        cells[y][x] = false;
    }

    public void setWall(int x, int y){
        cells[y][x] = true;
    }

    public boolean isWall(int x, int y){ //to avoid errors
        if(x >= 0 && x < width && y >= 0 && y < height){
            return cells[y][x];
        }else{
            return false;
        }
    }

    public void createMaze(long seed, int x, int y){
        //set current cell as path
        setPath(x, y);

        //this method of generation means that the same seed returns the same maze
        //while writing this, I came up with a method that randomly generates 5 possible values (opposed to the 4 directions)
        //but I realised that I could use that fifth generation to weight the maze and have a preferred direction

        int[] directionToTry = preferredDirection;

        if(Math.floor((noise.noise2_ImproveX(seed, 1, 1)*2)) != 2){
            directionToTry = possibleDirections[(int) (Math.floor((noise.noise2_ImproveX(seed, 1, 1)*2)) + 2)];
        }

        int nodeX = x + (directionToTry[1] * 2);
        int nodeY = y + (directionToTry[0] * 2);

        if(isWall(x, y)){
            int linkCellX = x + directionToTry[1];
            int linkCellY = y + directionToTry[0];

            setPath(linkCellX, linkCellY);

            createMaze(seed, nodeX, nodeY);
        }

    }


}

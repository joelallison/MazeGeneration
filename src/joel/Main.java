package joel;

import java.util.Random;

public class Main {

    public static void main(String[] args) {

        Random random = new Random();
        long seed = random.nextLong();

        Maze maze = new Maze(seed, 32, 32);

        for (boolean[] row : maze.cells) {
            for (boolean b : row) {
                if(b){
                    System.out.print("x");
                }else{
                    System.out.print(" ");
                }
            }System.out.println();
        }



    }
}

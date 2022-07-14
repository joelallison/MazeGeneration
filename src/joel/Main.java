package joel;

import java.util.Random;

public class Main {

    public static void main(String[] args) {

        Random random = new Random();
        long seed = random.nextLong();

        Maze maze = new Maze(seed, 32, 32);

        for (int[] row : maze.cells) {
            for (int i : row) {
                if(i == 1){
                    System.out.print("x");
                }else{
                    System.out.print(" ");
                }
            }System.out.println();
        }



    }
}

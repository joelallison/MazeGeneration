package joel;

public class Cell { // Cell class for my own java implementation of Eller's Maze algorithm, as detailed at http://www.neocomputer.org/projects/eller.html

    public boolean rightWall, bottomWall;
    public int x, y, setNum;

    public Cell(int cellX, int cellY) {
        x = cellX;
        y = cellY;
        rightWall = false;
        bottomWall = false;
        setNum = 0;
    }

}


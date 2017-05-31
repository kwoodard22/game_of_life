/******************************************************************************
 *  Compilation:  javac Board.java
 *  Execution:    java Board
 *  Dependencies: StdRandom
 *
 *  Creates board for Game of Life
 *
 ******************************************************************************/
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdDraw;

public class Board {
    int numAlive;
    int n;
    boolean[][] grid;
    boolean[][] gridCopy;
    
    // Create n-by-n grid with random live cells placed
    public Board(int gridSize, int liveCells) {
        int n = gridSize;
        numAlive = liveCells;
        
        grid = new boolean[n][n];
        gridCopy = new boolean[n][n];
        
        // Randomly generate live cells
        for (int i = 0; i < n;) {
            int row = StdRandom.uniform(n);
            int col = StdRandom.uniform(n);
            if (!grid[row][col]) {
                grid[row][col] = true;
                gridCopy[row][col] = true;
                numAlive++;
                i++;
            }
        }
    }
    
    public void updatePopulation() {
        Cell cell = new Cell();
        
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                boolean alive = cell.isAlive(grid[r][c], numberOfNeighbors(r, c));
                gridCopy[r][c] = alive;
            }
        }
        grid = gridCopy;
    }
    
    
    public boolean isAlive(int row, int col) {
        return grid[row][col];
    }
        
    // MAIN 
    public static void main(String[] args) {
    }
    
    // PRIVATE
    private int numberOfNeighbors(int row, int col) {
        int neighbors = 0;
        //topLeft
        if ((col > 0 && row > 0) && grid[row - 1][col - 1]) { neighbors++; }
        // top
        if ((col > 0) && grid[row][col - 1]) { neighbors++; }
        // topRight
        if ((col < (n-1) && row > 0) && grid[row - 1][col + 1]) { neighbors++; }
        // right
        if (col < (n-1) && grid[row][col + 1]) { neighbors++; }
        // bottomRight
        if ((row < (n-1) && col < (n-1)) && grid[row + 1][col]) { neighbors++; }
        // bottom
        if (row < (n-1) && grid[row + 1][col]) { neighbors++; }
        // bottomLeft
        if ((row < (n-1) && col > 0) && grid[row + 1][col - 1]) { neighbors++; }
        // left
        if (col > 0 && grid[row][col - 1]) { neighbors++; }
        return neighbors;
    }
}
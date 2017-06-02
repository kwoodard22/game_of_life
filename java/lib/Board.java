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
    int n;
    boolean[][] grid;
    boolean[][] gridCopy;
    
    // Create n-by-n grid with random live cells placed
    public Board(int gridSize, int liveCells) {
        int n = gridSize;
        
        grid = new boolean[n][n];
        gridCopy = new boolean[n][n];
        
        // Randomly generate live cells
        for (int i = 0; i < liveCells;) {
            int row = StdRandom.uniform(n);
            int col = StdRandom.uniform(n);
            if (!grid[row][col]) {
                grid[row][col] = true;
                i++;
            }
            gridCopy = grid;
        }
    }
    
    public void updatePopulation() {
        Cell cell = new Cell();
        
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                boolean alive = cell.isAlive(grid[row][col], numberOfNeighbors(row, col));
                gridCopy[row][col] = alive;
            }
        }
        grid = gridCopy;
    }
    
    
    public boolean cellAlive(int row, int col) {
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
        if ((row > 0) && grid[row -1][col]) { neighbors++; }
        
        // topRight
        if ((col < (n-2) && row > 0) && grid[row - 1][col + 1]) { neighbors++; }
        
        // right
        if (col < (n-2) && grid[row][col + 1]) { neighbors++; }
        
        // bottomRight
        if ((row < (n-2) && col < (n-2)) && grid[row + 1][col + 1]) { neighbors++; }
        
        // bottom
        if (row < (n-2) && grid[row + 1][col]) { neighbors++; }
        
        // bottomLeft
        if ((row < (n-2) && col > 0) && grid[row + 1][col - 1]) { neighbors++; }
        
        // left
        if (col > 0 && grid[row][col - 1]) { neighbors++; }
        
        return neighbors;
    }
}
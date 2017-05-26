/******************************************************************************
 *  Compilation:  javac Board.java
 *  Execution:    java Board
 *  Dependencies: StdIn, StdOut, StdRandom
 *
 *  Creates board for Game of Life
 *
 ******************************************************************************/
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdDraw;

public class Board {
    int numAlive;
    boolean[][] grid;
    boolean[][] gridCopy;
    
    // Create n-by-n grid with random live cells placed
    public Board(int gridSize, int liveCells) {
        int n = gridSize;
        numAlive = liveCells;
        
        grid = new boolean[n][n];
        cells = new boolean[n*n];
        
        // Randomly generate live cells
        for (int i = 0; i < c;) {
            int row = StdRandom.uniform(c);
            int col = StdRandom.uniform(c);
            if (!grid[row][col]) {
                grid[row][col] = true;
                gridCopy[row][col] = true;
                numAlive++;
                i++;
            }
        }
    }
    
    public void updatePopulation() {
        Cell cell = new Cell;
        
        for (r = 0; r < n; r++) {
            for (c = 0; c < n; c++) {
                boolean alive = cell.isAlive(grid[r][c], numberOfNeighbors(r, c))
                gridCopy[r][c] = alive;
                // if dead & now alive
                if (!grid[r][c] && alive) { 
            }
        }
        for (r = 0; r < n; r++) {
            for (c = 0; c < n; c++) {
                grid[r][c] = gridCopy[r][c]
            }
        }
    }
        
    // MAIN 
    public static void main(String[] args) {
        StdOut.println("Grid size (n x n):");
        int n = StdIn.readInt();
        StdOut.println("Live cell count:");
        int c = StdIn.readInt();
        Board b = new Board(n, c);
        b.printGrid();
        
    }
    
    // PRIVATE
    private numberOfNeighbors(int row, int col) {
        int neighbors = 0;
        //topLeft
        if ((col > 0 && row > 0) && grid[row - 1][col - 1]) { neighbors++; }
        // top
        if ((col > 0) && grid[row][col - 1]) { neighbors++; }
        // topRight
        if ((col < (N-1) && row > 0) && grid[row - 1][col + 1] { neighbors++; }
        // right
        if (col < (N-1) && grid[row][col + 1]) { neighbors++; }
        // bottomRight
        if ((row < (N-1) && col < (N-1)) && grid[row + 1][col]) { neighbors++; }
        // bottom
        if (row < (N-1) && grid[row + 1][col] { neighbors++; }
        // bottomLeft
        if ((row < (N-1) && col > 0) && grid[row + 1][col - 1]) { neighbors++; }
        // left
        if (col > 0 && grid[row][col - 1]) { neighbors++; }
        return neighbors;
    }
}
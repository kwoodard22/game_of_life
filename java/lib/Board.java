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

// Create board & randomly generate live cells
// Draw board
// Update board 
// Go through cells & check neighbors & update accordingly

public class Board {
    int n;
    boolean[][] grid;
    
    // Create n-by-n grid with random live cells placed
    public Board(int gridSize, int liveCells) {
        int n = gridSize;
        int c = liveCells;
        grid = new boolean[n][n];
        
        for (int i = 0; i < c;) {
            int row = StdRandom.uniform(c);
            int col = StdRandom.uniform(c);
            if (!grid[row][col]) {
                grid[row][col] = true;
                i++;
            }
        }
    }
    
    public void updatePopulation(int[] cellIndices) {
        int[] cells = cellIndices;
        
        for (i = 0; i < cells; i++) {
            
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
}
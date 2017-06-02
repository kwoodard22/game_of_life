/******************************************************************************
 *  Compilation:  javac GoLVisualizer.java
 *  Execution:    java GoLVisualizer
 *  Dependencies: Board.java Cell.java
 *
 ******************************************************************************/

import java.awt.Font;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdDraw;

public class GoLVisualizer {

    // delay in miliseconds (controls animation speed)
    private static final int DELAY = 100;

    // draw n-by-n board
    public static void draw(Board board, int n) {
        StdDraw.clear();
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.setXscale(-0.05*n, 1.05*n);
        StdDraw.setYscale(-0.05*n, 1.05*n);   // leave a border to write text
        StdDraw.filledSquare(n/2.0, n/2.0, n/2.0);

        // draw n-by-n grid
        int alive = 0;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (board.cellAlive(row, col)) {
                    StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
                    alive++;
                }
                else
                StdDraw.setPenColor(StdDraw.WHITE);
                StdDraw.filledSquare(col - 0.5, n - row + 0.5, 0.45);
            }
        }

        // write status text
        StdDraw.setFont(new Font("SansSerif", Font.PLAIN, 12));
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.text(0.25*n, -0.025*n, alive + " alive cells");
    }

    public static void main(String[] args) {
        StdOut.println("Grid size (n x n):");
        int n = StdIn.readInt();
        StdOut.println("Live cell count:");
        int c = StdIn.readInt();

        // turn on animation mode
        StdDraw.enableDoubleBuffering();      

        // repeatedly read in sites to open and draw resulting system
        Board board = new Board(n, c);
        draw(board, n);
        StdDraw.show();
        StdDraw.pause(DELAY);
        for (int i = 0; i < 10; i++) {
            board.updatePopulation();
            draw(board, n);
            StdDraw.show();
            StdDraw.pause(DELAY);
        }
    }
}
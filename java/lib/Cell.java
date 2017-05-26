public class Cell {  
    
    public void Cell () {
    }
    
    public isAlive(int numberOfNeighbors) {
        Int neighbors = numberOfNeighbors;
        
        // if currently alive
        if (population[cellIndex]) {
            if (neighbors < 2) { return false};
            if (neighbors >= 2 && neighbors <= 3) { return true; }
            if (neighbors > 3) { return false; }
        // if currently dead
        } else {
            if (neighbors == 3) { return true; }
        }
    }
    
}

/*
 * 
  if 
  1. Any live cell with fewer than two live neighbours dies, as if caused by underpopulation.
      if (neighbors < 2) { return false};
      
  1. Any live cell with two or three live neighbours lives on to the next generation.
      if (neighbors > 1 && neighbors < 4) { return true; }
      
  1. Any live cell with more than three live neighbours dies, as if by overpopulation.
      if (neighbors > 3) { return false; }
      
  1. Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.
*/

/* 
 * [ 
 *   [false, false, false, false],
 *   [true,  true,  false, false],
 *   [true,  false, false, true],
 *   [false, false, false, true]
 * ]
 * 
 * [ false, false, false, false, true, true, false, false, true, false, false, true, false, false, false, true]
 * 
 * 
 * 
 */

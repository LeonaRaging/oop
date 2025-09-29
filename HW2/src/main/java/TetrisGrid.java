package main.java;//
// TetrisGrid encapsulates a tetris board and has
// a clearRows() capability.

public class TetrisGrid {
	boolean grid[][];
	/**
	 * Constructs a new instance with the given grid.
	 * Does not make a copy.
	 * @param grid
	 */
	public TetrisGrid(boolean[][] grid) {
		this.grid = grid;
	}
	
	
	/**
	 * Does row-clearing on the grid (see handout).
	 */
	public void clearRows() {
		boolean newGrid[][] = new boolean[grid.length][grid[0].length];
		int k = 0;
		for (int j = 0; j < grid[0].length; j++) {
			boolean check = true;
			for (int i = 0; i < grid.length; i++) {
				check &= grid[i][j];
			}
			if (!check) {
				for (int i = 0; i < grid.length; i++) {
					newGrid[i][k] = grid[i][j];
				}
				k++;
			}
		}
		for (int j = k; j < grid[0].length; j++) {
			for (int i = 0; i < grid.length; i++) {
				newGrid[i][j] = false;
			}
		}
		this.grid = newGrid;
	}
	
	/**
	 * Returns the internal 2d grid array.
	 * @return 2d grid array
	 */
	boolean[][] getGrid() {
		return grid; // YOUR CODE HERE
	}
}

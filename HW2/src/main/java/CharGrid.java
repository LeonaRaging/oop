package main.java;// HW1 2-d array Problems
// CharGrid encapsulates a 2-d grid of chars and supports
// a few operations on the grid.

public class CharGrid {
	private char[][] grid;

	/**
	 * Constructs a new CharGrid with the given grid.
	 * Does not make a copy.
	 * @param grid
	 */
	public CharGrid(char[][] grid) {
		this.grid = grid;
	}
	
	/**
	 * Returns the area for the given char in the grid. (see handout).
	 * @param ch char to look for
	 * @return area for given char
	 */
	public int charArea(char ch) {
		int top = Integer.MAX_VALUE, bot = -Integer.MAX_VALUE, left = Integer.MAX_VALUE, right = -Integer.MAX_VALUE;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == ch) {
					top = Math.min(top, i);
					bot = Math.max(bot, i);
					left = Math.min(left, j);
					right = Math.max(right, j);
				}
			}
		}
		if (top == Integer.MAX_VALUE) return 0;
		return (bot - top + 1) * (right - left + 1);
	}
	
	/**
	 * Returns the count of '+' figures in the grid (see handout).
	 * @return number of + in grid
	 */
	public int countPlus() {
		int res = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				int p = 1;
				char c = grid[i][j];
				while (i - p >= 0 && i + p < grid.length && j - p >= 0 && j + p < grid[0].length) {
					if (grid[i - p][j] != c || grid[i + 1][j] != c || grid[i][j - p] != c || grid[i][j + p] != c)
						break;
					res++;
					p++;
				}
			}
		}
		return res;
	}
}

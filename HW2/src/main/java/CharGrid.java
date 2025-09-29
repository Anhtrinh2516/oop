// HW1 2-d array Problems
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
		int n = grid.length;
		int m = grid[0].length;

		int minRow = n, maxRow = -1;
		int minCol = m, maxCol = -1;
		int count = 0;

		for(int i = 0; i < n; i++){
			for(int j = 0 ; j < m; j++){
				if(grid[i][j] == ch ){
					count++;
					if (i < minRow) minRow = i;
					if (i > maxRow) maxRow = i;
					if (j < minCol) minCol = j;
					if (j > maxCol) maxCol = j;
				}
			}
		}

		if( count == 0) return 0;
		if (count == 1) return 1;
		return (maxRow - minRow + 1) * (maxCol - minCol + 1);
	}

	/**
	 * Hàm tính độ dài nhánh.
	 *
	 * @param i toạ độ x
	 * @param j toạ độ y
	 * @param di xác định là lên hoặc xuống
	 * @param dj xác định là trái hoặc phải
	 * @param ch kí tự cần kiểm tra
	 * @return
	 */
	private int branchLength(int i, int j, int di, int dj, char ch) {
		int len = 0;
		int n = grid.length;
		int m = grid[0].length;
		int x = i + di, y = j + dj;

		while (x >= 0 && x < n && y >= 0 && y < m && grid[x][y] == ch) {
			len++;
			x += di;
			y += dj;
		}
		return len;
	}
	
	/**
	 * Returns the count of '+' figures in the grid (see handout).
	 * @return number of + in grid
	 */
	public int countPlus() {
		int n = grid.length;
		int m = grid[0].length;
		int count = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				char ch = grid[i][j];
				if (ch == ' ') continue;

				int up = branchLength(i, j, -1, 0, ch);
				int down = branchLength(i, j, 1, 0, ch);
				int left = branchLength(i, j, 0, -1, ch);
				int right = branchLength(i, j, 0, 1, ch);

				int minLen = Math.min(Math.min(up, down), Math.min(left, right));

				if (minLen >= 1) {
					count++;
				}
			}
		}
		return count;
	}
	
}

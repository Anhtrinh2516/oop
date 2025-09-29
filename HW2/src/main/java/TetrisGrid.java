//
// TetrisGrid encapsulates a tetris board and has
// a clearRows() capability.

public class TetrisGrid {
	private int width;
	private int height;
	private boolean[][] grid;
	
	/**
	 * Constructs a new instance with the given grid.
	 * Does not make a copy.
	 * @param grid
	 */
	public TetrisGrid(boolean[][] grid) {

		this.grid = grid;
		this.width = grid.length;
		this.height = grid[0].length;
	}

	/**
	 * Hàm kiểm tra xem một hàng có full không.
	 *
	 * @param y hàng thứ y
	 * @return hàm có đầy không.
	 */
	private boolean isFullRow(int y){
		for(int i=0; i< width; i++){
			if(!grid[i][y]){
				return false;
			}
		}
		return true;
	}
	
	
	/**
	 * Does row-clearing on the grid (see handout).
	 */
	public void clearRows() {
		int newRow = 0;
		 for(int y=0; y < height; y++){
			 if (!isFullRow(y)) {
				 for(int x = 0; x < width ; x++){
					 grid[x][newRow] = grid[x][y];
				 }
				 newRow++;
			 }
		 }

		 for(int y = newRow; y < height; y++){
			 for(int x = 0; x < width; x++){
				 grid[x][y] = false;
			 }
		 }
	}
	
	/**
	 * Returns the internal 2d grid array.
	 * @return 2d grid array
	 */
	boolean[][] getGrid() {
		return grid;
	}
}

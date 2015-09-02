/**
 * Represents the game world.
 * Holds a two-dimensional array of cells.
 * Code sourced from Textbook
 * @author Joss Steward
 */
public class Environment {
	private int rows;
	private int cols;
	private Cell[][] theCells;
	
	public Environment(int rows, int cols){
		this.rows = rows;
		this.cols = cols;
		
		theCells = new Cell[rows][cols];
		
		/* Fill the array with empty cells */
		for(int x = 0; x < rows; x++){
			for(int y = 0; y < cols; y++){
				theCells[x][y] = new Cell();
			}
		}
	}
	
	/**
	 * Returns the LifeForm in the cell at (row, col).
	 * Null if there is no LifeForm there.
	 * @param row
	 * @param col
	 * @return The LifeForm in the cell at (row, col). Null if empty.
	 */
	public LifeForm getLifeForm(int row, int col)
	{
		return theCells[row][col].getLifeForm();
	}
	
	/**
	 * Add the passed LifeForm to the cell at (row, col)
	 * @param row
	 * @param col
	 * @param entity
	 * @return True if the LifeForm was added. False if the cell 
	 * 			was already occupied.
	 */
	public boolean addLifeForm(int row, int col, LifeForm entity)
	{
		if(getLifeForm(row, col) == null)
		{
			theCells[row][col].addLifeForm(entity);
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Remove the LifeForm at (row, col)
	 * @param row
	 * @param col
	 * @return The removed LifeForm, if any. Null otherwise.
	 */
	public LifeForm removeLifeForm(int row, int col)
	{
		return theCells[row][col].removeLifeForm();
	}
}

/**
 * Keeps track of the information associated with a simple life form.
 * Also provides the functionality related to the life form.
 * Code sourced from Textbook
 * @author Joss Steward
 */
public class LifeForm {
	private String myName;
	private int currentLifePoints;
	
	/**
	 * Create an instance
	 * @param name The name of the life form.
	 * @param points The current starting life points of the life form.
	 */
	public LifeForm(String name, int points) {
		myName = name;
		currentLifePoints = points;
	}
	
	/**
	 * @return The name of the life form.
	 */
	public String getName(){
		return myName;
	}
	
	/**
	 * @return The amount of current life points the life form has.
	 */
	public int getCurrentLifePoints(){
		return currentLifePoints;
	}
}

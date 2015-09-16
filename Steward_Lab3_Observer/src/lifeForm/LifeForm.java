package lifeForm;
/**
 * Keeps track of the information associated with a simple life form.
 * Also provides the functionality related to the life form.
 * Code sourced from Textbook
 * @author Joss Steward
 */
public abstract class LifeForm {
	private String myName;
	private int currentLifePoints;
	private int attackStrength;

	/**
	 * Create an instance with the default attack strength (5)
	 * @param name The name of the life form.
	 * @param points The current starting life points of the life form. 
	 */
	public LifeForm(String name, int points) {
		this(name, points, 5);
	}
	
	/**
	 * Create an instance
	 * @param name The name of the life form.
	 * @param points The current starting life points of the life form.
	 * @param strength The starting attack strength of this LifeForm
	 */
	public LifeForm(String name, int points, int strength) {
		myName = name;
		currentLifePoints = points;
		attackStrength = strength;
	}
	
	/**
	 * @return The attack strength of this LifeForm
	 */
	public int getAttackStrength(){
		return attackStrength;
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
	
	/**
	 * Subtracts @damage points from the currentLifePoints.
	 * @param damage The number of points of damage done.
	 * @return void
	 */
	public void takeHit(int damage)
	{
		currentLifePoints = Math.max(0, currentLifePoints - damage);
	}	

	/**
	 * Sets the current life points to the passed value.
	 * Contains no error checking, so be careful.
	 * @param life
	 */
	protected void setCurrentLifePoints(int life) {
		currentLifePoints = life;
	}
}

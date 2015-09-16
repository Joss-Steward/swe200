/**
 * 
 */
package lifeForm;

/**
 * Human is an implementation of the LifeForm class.
 * @author Joss Steward
 */
public class Human extends LifeForm {
	private int armorPoints;
	
	/**
	 * Create a new instance of the Human class.
	 * Calls the constructor or LifeForm for most of it's work.
	 * 
	 * If armorPoints is negative, this will set the armorPoints to 0.
	 * 
	 * Default attack strength of 5
	 * 
	 * @param name The Name of the new Human
	 * @param lifePoints The initial LifePoints of the new Human
	 * @param armorPoints The initial ArmorPoints of the new Human
	 */
	public Human(String name, int lifePoints, int armorPoints) 
	{
		super(name, lifePoints, 5);
		this.armorPoints = Math.max(0, armorPoints);		
	}
	
	/**
	 * Override the default takeHit behavior
	 * Now, damage is absorbed first by the armor, and only then
	 * does it hurt the human.
	 * @param damage The number of points of damage done (before armor).
	 * @return void
	 */
	public void takeHit(int damage)
	{
		int effectiveDamage = Math.max(0, damage - armorPoints);
		super.takeHit(effectiveDamage);
	}	
	
	/**
	 * @return The current number of ArmorPoints this human has
	 */
	public int getArmorPoints() {
		return armorPoints;
	}
	
	/**
	 * Sets the current armor points for this human.
	 * If passed a negative number, it will set armorPoints to 0.
	 * @param armor The new value for armorPoints
	 */
	public void setArmorPoints(int armor){
		armorPoints = Math.max(0, armor);
	}
}

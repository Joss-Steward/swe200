package lifeForm;

/**
 * This is a subclass of LifeForm.
 * It will be our primary enemy in this game.
 * @author Joss Steward
 */
public class Alien extends LifeForm {
	/**
	 * This is a simple version of the Alien constructor.
	 * @param name
	 * @param points
	 */
	public Alien(String name, int points) {
		super(name, points);	
	}
}

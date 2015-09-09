package lifeForm;

import recovery.RecoveryBehavior;
import recovery.RecoveryNone;

/**
 * This is a subclass of LifeForm.
 * It will be our primary enemy in this game.
 * @author Joss Steward
 */
public class Alien extends LifeForm {
	private int maxLifePoints;
	private RecoveryBehavior recoveryBehavior;
	
	/**
	 * This is a simple version of the Alien constructor.
	 * @param name The name of this particular alien.
	 * @param points The initial life points of this alien.
	 */
	public Alien(String name, int points) {
		this(name, points, new RecoveryNone());	
	}
	
	/**
	 * This is a more complete version of the Alien constructor.
	 * The recovery behavior passed to this will be the manner in
	 * which this alien recovers health.
	 * @param name The name of this particular alien.
	 * @param points The initial life points of this alien.
	 * @param rb The recovery behavior of this alien.
	 */
	public Alien(String name, int points, RecoveryBehavior rb) {
		super(name, points);
		maxLifePoints = points;
		recoveryBehavior = rb;
	}
	
	/**
	 * Regenerates health.
	 * How much health is regained is dependent upon the 
	 * recoveryBehavior this instance was created with.
	 */
	public void recover() {
		int newLifePoints = recoveryBehavior
				.calculateRecovery(getCurrentLifePoints(), maxLifePoints);		
		setCurrentLifePoints(newLifePoints);
	}
}

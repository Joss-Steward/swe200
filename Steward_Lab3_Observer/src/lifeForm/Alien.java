package lifeForm;

import exceptions.InvalidRecoveryRateException;
import gameplay.TimeObserver;
import recovery.RecoveryBehavior;
import recovery.RecoveryNone;

/**
 * This is a subclass of LifeForm.
 * It will be our primary enemy in this game.
 * @author Joss Steward
 */
public class Alien extends LifeForm implements TimeObserver {
	private int maxLifePoints;
	private int recoveryRate;
	private int lastTimeRecovered;
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
	 * 
	 * The default attack strength of all aliens is 10... for now
	 * 
	 * @param name The name of this particular alien.
	 * @param points The initial life points of this alien.
	 * @param rb The recovery behavior of this alien.
	 */
	public Alien(String name, int points, RecoveryBehavior rb) {
		super(name, points, 10);
		maxLifePoints = points;
		recoveryBehavior = rb;
		recoveryRate = 0;
		lastTimeRecovered = 0;
	}
	
	/**
	 * This is a more complete version of the Alien constructor.
	 * The recovery behavior passed to this will be the manner in
	 * which this alien recovers health.
	 * 
	 * The default attack strength of all aliens is 10... for now
	 * 
	 * @param name The name of this particular alien.
	 * @param points The initial life points of this alien.
	 * @param rb The recovery behavior of this alien.
	 * @param recoveryRate The rate at which the alien regains health.
	 * @throws InvalidRecoveryRateException 
	 */
	public Alien(String name, int points, RecoveryBehavior rb, int recoveryRate) throws InvalidRecoveryRateException {
		super(name, points, 10);
		
		if(recoveryRate < 0)
			throw new InvalidRecoveryRateException();
		
		maxLifePoints = points;
		recoveryBehavior = rb;
		this.recoveryRate = recoveryRate;
		lastTimeRecovered = 0;
	}
	
	/**
	 * Regenerates health.
	 * How much health is regained is dependent upon the 
	 * recoveryBehavior this instance was created with.
	 */
	protected void recover() {
		int newLifePoints = recoveryBehavior
				.calculateRecovery(getCurrentLifePoints(), maxLifePoints);		
		setCurrentLifePoints(newLifePoints);
	}

	/**
	 * This controls the recovery of the Alien
	 */
	@Override
	public void updateTime(int time) {
		if(recoveryRate != 0) {
			if((time - lastTimeRecovered) >= recoveryRate) {
				recover();
				lastTimeRecovered = time;
			}		
		}
	}
	
	/**
	 * @return The recovery rate of the alien
	 */
	public int getRecoveryRate() {
		return this.recoveryRate;
	}
}

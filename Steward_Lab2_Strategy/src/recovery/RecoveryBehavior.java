package recovery;

/**
 * Base interface for the Alien's ability to recover HP
 * @author Joss Steward
 */
public interface RecoveryBehavior {
	/**
	 * Returns the amount of LifePoints to recover.
	 * @param currentLife The current LifePoints of the Alien
	 * @param maxLife The maximum LifePoints of the Alien
	 * @return The amount of LifePoints to recover
	 */
	public int calculateRecovery(int currentLife, int maxLife);
}

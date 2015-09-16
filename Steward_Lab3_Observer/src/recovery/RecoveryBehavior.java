package recovery;

/**
 * Base interface for the Alien's ability to recover HP
 * @author Joss Steward
 */
public interface RecoveryBehavior {
	/**
	 * Returns the new amount of LifePoints (after recovering health).
	 * @param currentLife The current LifePoints of the Alien
	 * @param maxLife The maximum LifePoints of the Alien
	 * @return The new amount of LifePoints
	 */
	public int calculateRecovery(int currentLife, int maxLife);
}

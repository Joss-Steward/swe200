/**
 * 
 */
package recovery;

/**
 * A more complex recovery behavior whereby the alien regains a fixed
 * percentage of it's total remaining health each turn.
 * 
 * For example, an alien with 100 health remaining and a 10% RecoveryFractional
 * behavior would regain 10 health points when it recovers.
 * 
 * @author Joss Steward
 */
public class RecoveryFractional implements RecoveryBehavior {
	private double recoveryFraction;
	
	/**
	 * Create a new RecoveryFractional behavior
	 * @param fraction The fraction of the remaining health to recover each turn
	 */
	public RecoveryFractional(double fraction){
		recoveryFraction = fraction;
	}
	
	/**
	 * Recovers a certain percentage of the initial health
	 * each turn, up to the max health of the alien
	 */
	@Override
	public int calculateRecovery(int currentLife, int maxLife) {
		if (currentLife == 0) return 0;
		int recoverAmount = (int) Math.ceil(
				(double)currentLife * recoveryFraction);
		return Math.min(maxLife, currentLife + recoverAmount);
	}

}

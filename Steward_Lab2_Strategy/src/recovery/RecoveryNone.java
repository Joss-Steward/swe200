/**
 * 
 */
package recovery;

/**
 * An implementation of RecoveryBehavior for Aliens that
 * don't regenerate.
 * @author Joss Steward
 */
public class RecoveryNone implements RecoveryBehavior {
	/**
	 * Always returns 0.
	 */
	@Override
	public int calculateRecovery(int currentLife, int maxLife) {
		return 0;
	}

}

package recovery;

/**
 * RecoveryLinear recovers a set amount of health each turn,
 * up to the Max Health of the Alien
 * @author Joss Steward
 */
public class RecoveryLinear implements RecoveryBehavior {
	private int recoveryStep;
	
	/**
	 * Create a new RecoveryLinear behavior. 
	 * @param step The maximum amount of health to regain each turn.
	 */
	public RecoveryLinear(int step){
		recoveryStep = step;
	}

	/**
	 * Recovers a fixed amount of health each turn, up the 
	 * the max health of the alien
	 */
	@Override
	public int calculateRecovery(int currentLife, int maxLife) {
		if (currentLife == 0) return 0;		
		return Math.min(maxLife, currentLife + recoveryStep);
	}

}

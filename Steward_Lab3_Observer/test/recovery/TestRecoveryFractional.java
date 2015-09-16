/**
 * 
 */
package recovery;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Contains tests for the RecoveryFractional behavior
 * @author Joss Steward
 */
public class TestRecoveryFractional {
	/**
	 * Make sure the alien won't regain health once it's 
	 * at it's maximum health.
	 */
	@Test
	public void testNoRecoveryWhenNotHurt() {
		RecoveryFractional r1 = new RecoveryFractional(0.3);
		int maxLife = 50;
		int result = r1.calculateRecovery(maxLife, maxLife);
		assertEquals(50, result);
	}
	
	/**
	 * Test a fractional recovery to ensure the amount to
	 * recover is always rounded up.
	 */
	@Test
	public void testRoundUp(){
		RecoveryFractional r1 = new RecoveryFractional(0.1);
		int maxLife = 50;
		int result = r1.calculateRecovery(5, maxLife);
		/* The result should be 
		 * 		5 + Math.ceil(5 * 0.1)
		 * 		5 + Math.ceil(0.5)
		 * 		5 + 1
		 * 		6
		 */
		assertEquals(6, result);		
	}
	
	/**
	 * Test regeneration when the alien will recover the full 
	 * step, but not hit the maximum health value
	 */
	@Test
	public void testWhenItReallyHurts(){
		RecoveryFractional r1 = new RecoveryFractional(0.1);
		int maxLife = 150;
		int result = r1.calculateRecovery(100, maxLife);
		// The result should be 110
		assertEquals(110, result);		
	}

	/**
	 * Test regeneration when the alien will recover only part 
	 * of the step, but hit maximum health.
	 * 
	 * Ensure the alien will not wind up with more health than
	 * it started with.
	 */
	@Test
	public void testWhenItKindaHurts() {
		RecoveryFractional r1 = new RecoveryFractional(0.1);
		int maxLife = 105;
		int result = r1.calculateRecovery(100, maxLife);
		// This will try to recover 10 life points, but will be
		// capped at only recovering 5
		assertEquals(maxLife, result);
	}

	/**
	 * Test the border case where full-step recovery 
	 * results in perfect health.
	 */
	@Test
	public void testPerfectRecovery() {
		RecoveryFractional r1 = new RecoveryFractional(0.1);
		int maxLifePts = 110;
		int result = r1.calculateRecovery(100, maxLifePts);
		assertEquals(maxLifePts, result);
	}
	
	/**
	 * Ensure the Alien will not regain health when it's already
	 * dead.
	 */
	@Test
	public void testWhenDead() {
		RecoveryFractional r1 = new RecoveryFractional(0.1);
		int maxLifePts = 100;
		int result = r1.calculateRecovery(0, maxLifePts);
		assertEquals(0, result);
	}
}

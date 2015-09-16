package recovery;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Contains tests for the RecoveryLinear RecoveryBehavior
 * @author Joss Steward
 */
public class TestRecoveryLinear {
	/**
	 * Make sure the alien won't regain health once it's at
	 * it's maximum health.  
	 */
	@Test
	public void testNoRecoveryWhenNotHurt() {
		RecoveryLinear r1 = new RecoveryLinear(3);
		int maxLifePts = 30;
		int result = r1.calculateRecovery(maxLifePts, maxLifePts);
		assertEquals(30, result);
	}
	
	/**
	 * Test regeneration when the alien will recover the full 
	 * step, but not hit the maximum health
	 */
	@Test
	public void testWhenItReallyHurts() {
		RecoveryLinear r1 = new RecoveryLinear(10);
		int maxLifePts = 100;
		int result = r1.calculateRecovery(50, maxLifePts);
		assertEquals(60, result);
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
		RecoveryLinear r1 = new RecoveryLinear(10);
		int maxLifePts = 100;
		int result = r1.calculateRecovery(95, maxLifePts);
		assertEquals(maxLifePts, result);
	}

	/**
	 * Test the border case where full-step recovery 
	 * results in perfect health.
	 */
	@Test
	public void testPerfectRecovery() {
		RecoveryLinear r1 = new RecoveryLinear(10);
		int maxLifePts = 100;
		int result = r1.calculateRecovery(90, maxLifePts);
		assertEquals(maxLifePts, result);
	}
	
	/**
	 * Ensure the Alien will not regain health when it's already
	 * dead.
	 */
	@Test
	public void testWhenDead() {
		RecoveryLinear r1 = new RecoveryLinear(10);
		int maxLifePts = 100;
		int result = r1.calculateRecovery(0, maxLifePts);
		assertEquals(0, result);
	}
}

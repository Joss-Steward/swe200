package recovery;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Contains tests for the RecoveryNone class
 * @author Joss Steward
 */
public class TestRecoveryNone {
	/**
	 * Make sure that at MaxHealth an Alien will stay at MaxHealth
	 */
	@Test
	public void testAtMaxHealth() {
		RecoveryNone nope = new RecoveryNone();
		assertEquals(100, nope.calculateRecovery(100, 100));
	}
	
	/**
	 * Make sure that even when hurt the Alien won't regain health
	 */
	@Test
	public void testAtWhenHurt() {
		RecoveryNone nope = new RecoveryNone();
		assertEquals(10, nope.calculateRecovery(10, 100));
	}
}

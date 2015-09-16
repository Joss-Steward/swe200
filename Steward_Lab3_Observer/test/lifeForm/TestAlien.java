package lifeForm;

import static org.junit.Assert.*;

import org.junit.Test;

import recovery.RecoveryLinear;

/**
 * Contains tests for the Alien class
 * @author Joss Steward
 */
public class TestAlien {
	
	/**
	 * Test the default attack strength for aliens
	 */
	@Test
	public void testDefaultAttack(){
		// Aliens are weird
		// Not specifying the attack strength because I just
		// 	want to stick with the default
		Alien grebzorilian = new Alien("Grebzori'lian", 50);
		assertEquals(10, grebzorilian.getAttackStrength());
	}

	/***************************
	 * TESTS FROM STRATEGY LAB *
	 ***************************/
	
	/**
	 * Test the simple constructor for Alien
	 */
	@Test
	public void testInitialization() {
		// Has a weird name, cause it's an alien		
		Alien njeklwqfeasf = new Alien("njeklwqfeasf", 50);
				
		assertEquals("njeklwqfeasf", njeklwqfeasf.getName());
		assertEquals(50, njeklwqfeasf.getCurrentLifePoints());
	}
	
	/**
	 * Test an Alien with a simple linear recovery behavior
	 */
	@Test
	public void testAlienWithLinearRecovery() {
		RecoveryLinear linearRecovery = new RecoveryLinear(10);
		Alien lnar = new Alien("lnar", 50, linearRecovery);
		
		lnar.takeHit(20);
		assertEquals(30, lnar.getCurrentLifePoints());
		
		// With linear recovery lnar should end up with 40 life points
		lnar.recover();
		assertEquals(40, lnar.getCurrentLifePoints());
	}
}

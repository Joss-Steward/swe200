package lifeForm;

import static org.junit.Assert.*;

import org.junit.Test;

import exceptions.InvalidRecoveryRateException;
import gameplay.SimpleTimer;
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

	/**
	 * Test RecoveryRate < 0
	 * @throws InvalidRecoveryRateException 
	 */
	@Test(expected = InvalidRecoveryRateException.class)
	public void testInvalidRecoveryRate() throws InvalidRecoveryRateException{
		Alien tkilll = new Alien("t'Killl", 50, new RecoveryLinear(10), -2);
	}
	
	/**
	 * Test that the alien won't heal when it's recovery rate is 0
	 * @throws InvalidRecoveryRateException 
	 */
	@Test
	public void testNoRecoveryWhenZero() throws InvalidRecoveryRateException{
		Alien Qlark = new Alien("Qlar'k", 50, new RecoveryLinear(10), 0);
		Qlark.takeHit(20);
		assertEquals(30, Qlark.getCurrentLifePoints());
		
		for(int i = 0; i < 50; i++){
			Qlark.updateTime(i);		
		}
		
		assertEquals(30, Qlark.getCurrentLifePoints());
	}
	
	/**
	 * Test that recovery works when time passes.
	 * Simulate passing time.
	 */
	@Test
	public void testSimpleRecoveryWhenTimePasses() throws InvalidRecoveryRateException{
		Alien Qazcuran = new Alien("Qazcuran", 50, new RecoveryLinear(5), 10);
		Qazcuran.takeHit(20);
		assertEquals(30, Qazcuran.getCurrentLifePoints());
		
		// Should recover once in this time span
		// (Once at 10)
		for(int i = 0; i < 15; i++){
			Qazcuran.updateTime(i);		
		}
		
		assertEquals(35, Qazcuran.getCurrentLifePoints());		
	}

	/**
	 * Test getRecoveryRate
	 */
	@Test
	public void testGetRecoveryRate() throws InvalidRecoveryRateException {
		Alien Grephlanor = new Alien("Grephlanor", 50, new RecoveryLinear(5), 10);
		assertEquals(10, Grephlanor.getRecoveryRate());
	}
	
	/**
	 * Test recovery in combat (page 41)
	 */
	@Test
	public void testCombatRecovery() throws InvalidRecoveryRateException {
		Alien Tim = new Alien("Tim", 50, new RecoveryLinear(5), 2);
		Tim.takeHit(20);
		
		SimpleTimer t = new SimpleTimer();
		t.addTimeObserver(Tim);
		
		t.timeChanged();
		assertEquals(30, Tim.getCurrentLifePoints());
		
		t.timeChanged();
		assertEquals(35, Tim.getCurrentLifePoints());
	}

	/**
	 * Test recovery in combat (page 41)
	 */
	@Test
	public void testCombatRecoveryAtDifferentRate() throws InvalidRecoveryRateException {
		Alien Tim = new Alien("Tim", 50, new RecoveryLinear(5), 3);
		Tim.takeHit(20);
		
		SimpleTimer t = new SimpleTimer();
		t.addTimeObserver(Tim);
		
		t.timeChanged();
		assertEquals(30, Tim.getCurrentLifePoints());
		
		t.timeChanged();
		assertEquals(30, Tim.getCurrentLifePoints());
		
		t.timeChanged();
		assertEquals(35, Tim.getCurrentLifePoints());
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

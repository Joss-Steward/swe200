package lifeForm;
import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests the functionality provided by the LifeForm class
 * Copied from the book
 * @author Merlin, Joss Steward
 */
public class TestLifeForm {

	/**
	 * Make sure the LifeForm knows how strong its attack is
	 */
	@Test
	public void testDefaultAttackStrength() {
		// The default attack strength will be 5
		LifeForm entity = new MockLifeForm("Bob", 40);
		assertEquals(5, entity.getAttackStrength());		
	}

	/**
	 * Make sure the LifeForm knows how strong its attack is
	 */
	@Test
	public void testCustomAttackStrength() {
		// The attack strength will be 10
		LifeForm entity = new MockLifeForm("Bob", 40, 10);
		assertEquals(10, entity.getAttackStrength());		
	}
	
	/**
	 * Check that a LifeForm can attack another LifeForm
	 * When will the violence end? :(
	 */
	@Test
	public void testAttackAbility(){
		// The attack strength will be 10
		LifeForm attacker = new MockLifeForm("Bob", 40, 10);
		assertEquals(10, attacker.getAttackStrength());
		
		LifeForm victim = new MockLifeForm("Grabzorknork", 50);
		assertEquals(50, victim.getCurrentLifePoints());
		
		attacker.attack(victim);
		assertEquals(40, victim.getCurrentLifePoints());
	}
	
	/**
	 * Dead things can't hurt living things... yet
	 */
	@Test
	public void testAttackWhenDead(){
		// The attack strength will be 10
		LifeForm attacker = new MockLifeForm("Bob", 0, 10);
		assertEquals(10, attacker.getAttackStrength());
		
		LifeForm victim = new MockLifeForm("Grabzorknork", 50);
		assertEquals(50, victim.getCurrentLifePoints());
		
		// Because Bob is dead, he can't hurt Grabzorknork
		attacker.attack(victim);
		assertEquals(50, victim.getCurrentLifePoints());
		
	}

	
	/***************************
	 * TESTS FROM STRATEGY LAB *
	 ***************************/
	
	/**
	 * When a LifeForm is created, it should know its name and
	 * how many life points it has.
	 */
	@Test
	public void testInitialization() {
		LifeForm entity;
		entity = new MockLifeForm("Bob", 40);
		assertEquals("Bob", entity.getName());
		assertEquals(40, entity.getCurrentLifePoints());
	}
	
	/**
	 * Test the takeHit method of the LifeForm.
	 * Make sure it cannot drop below 0.
	 */
	@Test
	public void testTakeHit(){
		LifeForm entity = new MockLifeForm("Bob", 100);
		
		// Make sure the initial hit points is correct
		assertEquals(100, entity.getCurrentLifePoints());
		
		// Do 50 points of damage
		entity.takeHit(50);	
		assertEquals(50, entity.getCurrentLifePoints());
		
		// Do 10 points of damage
		entity.takeHit(10);	
		assertEquals(40, entity.getCurrentLifePoints());
		
		// Make sure the HP cannot drop below 0
		entity.takeHit(50);	
		assertEquals(0, entity.getCurrentLifePoints());
	}
	
	/**
	 * Test takeHit when the LifeForm has no health
	 */
	@Test
	public void testTakeHitAtNoHealth(){
		LifeForm entity = new MockLifeForm("Bob", 0);
		
		// Make sure the initial hit points is correct
		assertEquals(0, entity.getCurrentLifePoints());
		
		// Do 50 points of damage
		entity.takeHit(50);	
		// Make sure he's still dead
		assertEquals(0, entity.getCurrentLifePoints());
	}
	
}

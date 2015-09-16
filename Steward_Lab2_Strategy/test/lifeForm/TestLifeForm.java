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

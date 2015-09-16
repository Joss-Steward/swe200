package lifeForm;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Contains tests for the Human class
 * (A subclass of the LifeForm class)
 * @author Joss Steward
 */
public class TestHuman {

	/**
	 * Test the constructor of the Human class
	 */
	@Test
	public void testInitialization() {
		// Create a Human named Billy with 10 HP and 50 Armor Points
		Human billy = new Human("Billy", 10, 50);
		
		assertEquals("Billy", billy.getName());
		assertEquals(10, billy.getCurrentLifePoints());
		assertEquals(50, billy.getArmorPoints());
	}
	
	/**
	 * Test the bounds of the Human constructor
	 * Specifically, Armor points cannot be set to less than 0
	 */
	@Test
	public void testHumanConstructor() {
		// Create a Human named Billy with 10 HP and -50 Armor Points
		// (The Armor Points should set to 0)
		Human billy = new Human("Billy", 10, -50);
		
		assertEquals(0, billy.getArmorPoints());
	}

	/**
	 * Test the ability to set the Human's armor points
	 */
	@Test
	public void testSetArmorPoints() {
		// Create a Human named Billy with 10 HP and -50 Armor Points
		// (The Armor Points should set to 0)
		Human billy = new Human("Billy", 10, -50);
		
		assertEquals(0, billy.getArmorPoints());
		
		// Set the armor points to something positive
		billy.setArmorPoints(100);
		assertEquals(100, billy.getArmorPoints());		

		// Set the armor points to something out of bounds
		// (Should be corrected to 0 by setArmorPoints)
		billy.setArmorPoints(-20);
		assertEquals(0, billy.getArmorPoints());
	}
}

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
	 * Test the default attack strength
	 */
	@Test
	public void testDefaultAttackStrength(){
		// Create a new Human named Susan with 10 HP, 
		//  50 Armor, and the default attack strength		
		Human susan = new Human("Susan", 10, 50);		
		assertEquals(5, susan.getAttackStrength());
	}
	
	/**
	 * Test the Armor's hit-absorbing ability
	 * This test checks when the armor can only absorb
	 * some of the damage
	 */
	@Test
	public void testArmorAbsorbSomeDamage(){
		// Create a new Human named Susan with 10 HP, 
		//  50 Armor, and the default attack strength		
		Human susan = new Human("Susan", 10, 50);
		
		susan.takeHit(55);
		assertEquals(5, susan.getCurrentLifePoints());
		
		// Make sure the armor wasn't damaged
		assertEquals(50, susan.getArmorPoints());		
	}
	
	/**
	 * Test the Armor's hit-absorbing ability
	 * This test checks when the armor can only absorb
	 * all of the damage
	 */
	@Test
	public void testArmorAbsorbAllDamage(){
		// Create a new Human named Susan with 10 HP, 
		//  50 Armor, and the default attack strength		
		Human susan = new Human("Susan", 10, 50);
		
		susan.takeHit(5);
		assertEquals(10, susan.getCurrentLifePoints());
		
		// Make sure the armor wasn't damaged
		assertEquals(50, susan.getArmorPoints());		
	}
	
	/**
	 * Test the Armor's hit-absorbing ability
	 * This test checks that the armor doesn't degrade
	 */
	@Test
	public void testArmorNoDegrade(){
		// Create a new Human named Susan with 10 HP, 
		//  50 Armor, and the default attack strength		
		Human susan = new Human("Susan", 10, 50);
		
		// Hit repeatedly
		for(int i = 0; i < 10; i++) {
			susan.takeHit(45);
		}
		
		assertEquals(10, susan.getCurrentLifePoints());
		
		// Make sure the armor wasn't damaged
		assertEquals(50, susan.getArmorPoints());		
	}

	/**
	 * Test the Armor's hit-absorbing ability
	 * This test checks a border case
	 */
	@Test
	public void testArmorAtZero(){
		// Create a new Human named Susan with 10 HP, 
		//  0 Armor, and the default attack strength		
		Human susan = new Human("Susan", 10, 0);
		
		susan.takeHit(5);		
		assertEquals(5, susan.getCurrentLifePoints());
	}

	/**
	 * Test the Armor's hit-absorbing ability
	 * This test checks a border case
	 */
	@Test
	public void testArmorAtMaxCapability(){
		// Create a new Human named Susan with 10 HP, 
		//  0 Armor, and the default attack strength		
		Human susan = new Human("Susan", 10, 10);
		
		// The armor should absorb all of this damage
		susan.takeHit(10);		
		assertEquals(10, susan.getCurrentLifePoints());
	}
	
	/***************************
	 * TESTS FROM STRATEGY LAB *
	 ***************************/

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

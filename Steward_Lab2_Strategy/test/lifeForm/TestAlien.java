package lifeForm;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Contains tests for the Alien class
 * @author Joss Steward
 */
public class TestAlien {
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
}

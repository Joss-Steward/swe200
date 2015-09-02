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

}

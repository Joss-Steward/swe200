package environment;
import static org.junit.Assert.*;
import lifeForm.MockLifeForm;

import org.junit.Test;

/**
 * The test cases for the Cell class
 * @author Merlin, Joss Steward
 */
public class TestCell
{
   /**
    * At initialization, the CEll should be empty and not contain a MockLifeForm.
    */
   @Test
   public void testInitialization()
   {
      Cell cell = new Cell();
      assertNull(cell.getLifeForm());
   }
   
   /**
    * Checks to see if we change the MockLifeForm held by the Cell that
    * getMockLifeForm properly responds to this change.
    */
   @Test
   public void testSetMockLifeForm()
   {
	   MockLifeForm bob = new MockLifeForm("Bob", 40);
	   MockLifeForm fred = new MockLifeForm("Fred", 40);
	   Cell cell = new Cell();
	   
	   //The cell is empty right now, so this will work
	   boolean success = cell.addLifeForm(bob);
	   assertTrue(success);
	   assertEquals(bob, cell.getLifeForm());
	   
	   //The cell is not empty now, so this should fail
	   success = cell.addLifeForm(fred);
	   assertFalse(success);
	   assertEquals(bob, cell.getLifeForm());
   }
   
   /**
    * Checks to see that we can remove a MockLifeForm without a issue
    */
   @Test
   public void testRemoveMockLifeForm()
   {
	   MockLifeForm bob = new MockLifeForm("Bob", 40);
	   Cell cell = new Cell();	   

	   //The cell is empty right now, so this will work
	   boolean success = cell.addLifeForm(bob);
	   assertTrue(success);
	   assertEquals(bob, cell.getLifeForm());
	   
	   //Now try removing the MockLifeForm
	   assertEquals(bob, cell.removeLifeForm());
	   assertNull(cell.getLifeForm());

	   //Now try adding the MockLifeForm back again
	   success = cell.addLifeForm(bob);
	   assertTrue(success);
	   assertEquals(bob, cell.getLifeForm());
   }
   
}

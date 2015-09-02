import static org.junit.Assert.*;

import org.junit.Test;

/**
 * The test cases for the Cell class
 * @author Merlin, Joss Steward
 */
public class TestCell
{
   /**
    * At initialization, the CEll should be empty and not contain a LifeForm.
    */
   @Test
   public void testInitialization()
   {
      Cell cell = new Cell();
      assertNull(cell.getLifeForm());
   }
   
   /**
    * Checks to see if we change the LifeForm held by the Cell that
    * getLifeForm properly responds to this change.
    */
   @Test
   public void testSetLifeForm()
   {
	   LifeForm bob = new LifeForm("Bob", 40);
	   LifeForm fred = new LifeForm("Fred", 40);
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
    * Checks to see that we can remove a LifeForm without a issue
    */
   @Test
   public void testRemoveLifeForm()
   {
	   LifeForm bob = new LifeForm("Bob", 40);
	   Cell cell = new Cell();	   

	   //The cell is empty right now, so this will work
	   boolean success = cell.addLifeForm(bob);
	   assertTrue(success);
	   assertEquals(bob, cell.getLifeForm());
	   
	   //Now try removing the LifeForm
	   assertEquals(bob, cell.removeLifeForm());
	   assertNull(cell.getLifeForm());

	   //Now try adding the LifeForm back again
	   success = cell.addLifeForm(bob);
	   assertTrue(success);
	   assertEquals(bob, cell.getLifeForm());
   }
   
}

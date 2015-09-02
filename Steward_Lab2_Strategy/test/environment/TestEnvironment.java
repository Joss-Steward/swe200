package environment;
import static org.junit.Assert.*;
import lifeForm.MockLifeForm;

import org.junit.Test;

/**
 * The test cases for the Environment class
 * @author Merlin, Joss Steward
 */
public class TestEnvironment 
{
	/**
	 * Test a simple environment with a single cell
	 */	
	@Test
	public void testSingleCellEnvironment() 
	{
		Environment e = new Environment(1, 1);
		assertNull(e.getLifeForm(0,0));
	}
	
	/**
	 * Test storing a MockMockLifeForm in a single cell in a small array.
	 */
	@Test
	public void testStorageAbility()
	{
		Environment e = new Environment(2, 3);	
		MockLifeForm bobo = new MockLifeForm("bobo", 40);
		boolean success = e.addLifeForm(1, 2, bobo);
		assertTrue(success);
		
		assertEquals(bobo, e.getLifeForm(1, 2));
	}
	
	/**
	 * Test Adding a MockMockLifeForm and then removing it.
	 */
	@Test
	public void testRemovingLifeForm()
	{
		Environment e = new Environment(2, 3);	
		MockLifeForm bobo = new MockLifeForm("bobo", 40);
		boolean success = e.addLifeForm(1, 2, bobo);
		assertTrue(success);
		
		assertEquals(bobo, e.getLifeForm(1, 2));
		
		assertEquals(bobo, e.removeLifeForm(1, 2));
		assertNull(e.getLifeForm(1, 2));		
	}
	
	/**
	 * Test some of the edge cases.
	 */
	@Test
	public void testEdgeCases()
	{
		Environment e = new Environment(500, 500);	
		
		// Test adding a MockMockLifeForm at (0, 0)
		MockLifeForm bobo = new MockLifeForm("bobo", 40);		
		boolean success = e.addLifeForm(0, 0, bobo);
		assertTrue(success);		
		assertEquals(bobo, e.getLifeForm(0, 0));
		
		// Test adding a MockMockLifeForm at the farthest row
		MockLifeForm billy = new MockLifeForm("billy", 60);		
		success = e.addLifeForm(0, 499, billy);
		assertTrue(success);		
		assertEquals(billy, e.getLifeForm(0, 499));

		// Test adding a MockMockLifeForm at the farthest column
		MockLifeForm jo = new MockLifeForm("jo", 60);		
		success = e.addLifeForm(499, 0, jo);
		assertTrue(success);		
		assertEquals(jo, e.getLifeForm(499, 0));

		// Test adding a MockMockLifeForm at the farthest cell
		MockLifeForm john = new MockLifeForm("john", 60);		
		success = e.addLifeForm(499, 499, john);
		assertTrue(success);		
		assertEquals(john, e.getLifeForm(499, 499));
		
	}

}

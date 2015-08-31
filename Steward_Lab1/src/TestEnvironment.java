import static org.junit.Assert.*;

import org.junit.Test;


public class TestEnvironment {

	@Test
	public void testSingleCellEnvironment() 
	{
		Environment e = new Environment(1, 1);
		assertNull(e.getLifeForm(0,0));
	}
	
	@Test
	public void testStorageAbility()
	{
		Environment e = new Environment(2, 3);	
		LifeForm bobo = new LifeForm("bobo", 40);
		boolean success = e.addLifeForm(1, 2, bobo);
		assertTrue(success);
		
		assertEquals(bobo, e.getLifeForm(1, 2));
	}
	
	@Test
	public void testRemovingLifeForm()
	{
		Environment e = new Environment(2, 3);	
		LifeForm bobo = new LifeForm("bobo", 40);
		boolean success = e.addLifeForm(1, 2, bobo);
		assertTrue(success);
		
		assertEquals(bobo, e.getLifeForm(1, 2));
		
		assertEquals(bobo, e.removeLifeForm(1, 2));
		assertNull(e.getLifeForm(1, 2));		
	}
	
	@Test
	public void testEdgeCases()
	{
		Environment e = new Environment(500, 500);	
		
		// Test adding a LifeForm at (0, 0)
		LifeForm bobo = new LifeForm("bobo", 40);		
		boolean success = e.addLifeForm(0, 0, bobo);
		assertTrue(success);		
		assertEquals(bobo, e.getLifeForm(0, 0));
		
		// Test adding a LifeForm at the farthest column
		LifeForm billy = new LifeForm("billy", 60);		
		success = e.addLifeForm(0, 499, billy);
		assertTrue(success);		
		assertEquals(billy, e.getLifeForm(0, 499));

		// Test adding a LifeForm at the farthest row
		LifeForm jo = new LifeForm("jo", 60);		
		success = e.addLifeForm(0, 499, billy);
		assertTrue(success);		
		assertEquals(billy, e.getLifeForm(0, 499));
	}

}

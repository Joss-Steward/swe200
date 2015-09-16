package gameplay;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * MockSimpleTimerObserver
 * Used for the tests in TestSimpleTimer
 * @author Joss Steward
 */
class MockSimpleTimerObserver implements TimeObserver
{
	public int myTime = 0;
	
	public void updateTime(int time){
		myTime = time;
	}
}

/**
 * Contains tests for the Timer and stuff
 * @author Joss Steward
 */
public class TestSimpleTimer {
	
	/** 
	 * Test that we can create a simple timer
	 */
	@Test
	public void testInitialization() {
		Timer t = new SimpleTimer();
		assertEquals(0, t.getTime());
	}
	
	/**
	 * Test that the timer updates its observers
	 */
	@Test
	public void testWithObserver(){
		Timer t = new SimpleTimer();
		MockSimpleTimerObserver c = new MockSimpleTimerObserver();
		
		assertEquals(0, c.myTime);
		t.timeChanged();
		
		// Shouldn't update the observer since it hasn't been added yet
		t.addTimeObserver(c);
		assertEquals(0, c.myTime);
		
		// Since the timer has ticked twice now, the current 
		// time should be 2
		t.timeChanged();
		assertEquals(2, c.myTime);		
	}
	
	/**
	 * Test that the timer updates its observers
	 */
	@Test
	public void testRemovingObserver(){
		Timer t = new SimpleTimer();
		MockSimpleTimerObserver c = new MockSimpleTimerObserver();
		
		// Test adding an observer and updating it
		t.addTimeObserver(c);
		assertEquals(0, c.myTime);
		t.timeChanged();
		assertEquals(1, c.myTime);	
		
		// Now remove the observer and update again
		// Then make sure the observer didn't update
		t.removeTimeObserver(c);
		t.timeChanged();
		assertEquals(1, c.myTime);
	}
	
	/**
	 * Test that the timer updates its observers
	 */
	@Test
	public void testTimeChangedWithNoObservers(){
		Timer t = new SimpleTimer();
		t.timeChanged();
		assertEquals(1, t.getTime());	
	}
}

package gameplay;
import java.util.ArrayList;

/**
 * A simple implementation of the Observable Timer
 * @author Joss Steward
 */
public class SimpleTimer implements Timer {
	private ArrayList<TimeObserver> Observers;
	private int time;
	
	public SimpleTimer(){
		Observers = new ArrayList<TimeObserver>();
		time = 0;
	}
	
	/** 
	 * @return The current in-game time
	 */
	@Override
	public int getTime(){
		return time;
	}
	
	/**
	 * Change time, then notify the observers 
	 * that the time has changed
	 */
	@Override
	public void timeChanged() {
		time++;
		
		for(TimeObserver obs : Observers){
			obs.updateTime(time);
		}
	}

	/**
	 * Add an observer
	 */
	@Override
	public void addTimeObserver(TimeObserver observer) {
		Observers.add(observer);
	}

	/**
	 * Remove an observer
	 */
	@Override
	public void removeTimeObserver(TimeObserver observer) {
		Observers.remove(observer);
	}

}

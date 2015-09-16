package gameplay;
import java.util.ArrayList;

/**
 * A simple implementation of the Observable Timer
 * @author Joss Steward
 */
public class SimpleTimer extends Thread implements Timer {
	private ArrayList<TimeObserver> Observers;
	private int time;
	
	public SimpleTimer(){
		Observers = new ArrayList<TimeObserver>();
		time = 0;
	}
	
	/**
	 * This timer will tick every once in a while,
	 * calling timeChanged() to notify its observers
	 * that time has moved on
	 */
	public void run(){
		for(int i = 0; i < 100; i++){
			try
			{
				Thread.sleep(1000);
				this.timeChanged();
			} catch (InterruptedException e) {
				System.out.println("Oh god! Oh god! Everything is on fire! Help!");
			}
		}
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

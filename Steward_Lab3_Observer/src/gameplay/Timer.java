package gameplay;

/**
 * Observable timer
 * Used to track time in the game
 * @author Joss Steward
 */
public interface Timer {
	public void addTimeObserver(TimeObserver observer);
	public void removeTimeObserver(TimeObserver observer);
	public void timeChanged();
	public int getTime();
}

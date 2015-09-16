package gameplay;

/**
 * A Simple interface for items that want 
 * to watch time itself (although, if you think about it,
 * watching time is all that any of us can do)
 * 
 * @author Joss Steward
 */
public interface TimeObserver {
	public void updateTime(int time);
}

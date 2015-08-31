import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Runs all of the tests in this project
 * @author js0289
 */
@RunWith(Suite.class)
@Suite.SuiteClasses ({
	TestLifeForm.class,
	TestCell.class
})
public class AllGameTests 
{
}

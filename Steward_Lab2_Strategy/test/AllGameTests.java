import lifeForm.TestLifeForm;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import environment.TestCell;
import environment.TestEnvironment;

/**
 * Runs all of the tests in this project
 * @author js0289
 */
@RunWith(Suite.class)
@Suite.SuiteClasses ({
	TestLifeForm.class,
	TestCell.class,
	TestEnvironment.class
})
public class AllGameTests 
{
}

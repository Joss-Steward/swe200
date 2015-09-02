import lifeForm.TestLifeForm;
import lifeForm.TestHuman;
import lifeForm.TestAlien;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import environment.TestCell;
import environment.TestEnvironment;

import recovery.TestRecoveryNone;
import recovery.TestRecoveryLinear;

/**
 * Runs all of the tests in this project
 * @author Joss Steward
 */
@RunWith(Suite.class)
@Suite.SuiteClasses ({
	TestLifeForm.class,
	TestCell.class,
	TestEnvironment.class,
	TestHuman.class,
	TestAlien.class,
	TestRecoveryNone.class,
	TestRecoveryLinear.class
})
public class AllGameTests 
{
}

import lifeForm.TestLifeForm;
import lifeForm.TestHuman;
import lifeForm.TestAlien;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import environment.TestCell;
import environment.TestEnvironment;
import gameplay.TestSimpleTimer;
import recovery.TestRecoveryNone;
import recovery.TestRecoveryLinear;
import recovery.TestRecoveryFractional;

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
	TestRecoveryLinear.class,
	TestRecoveryFractional.class,
	TestSimpleTimer.class
})
public class AllGameTests 
{
}

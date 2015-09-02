package lifeForm;

/**
 * This class allows us to instantiate base LifeForms,
 * allowing us to run tests against LifeForm.
 * @author Joss Steward
 */
public class MockLifeForm extends LifeForm {
	/**
	 * This Constructor will just call the constructor in LifeForm
	 * @param name - The name of the new LifeForm
	 * @param points - The Initial Hit points of the new LifeForm
	 */
	public MockLifeForm(String name, int points) {
		super(name, points);
	}

}

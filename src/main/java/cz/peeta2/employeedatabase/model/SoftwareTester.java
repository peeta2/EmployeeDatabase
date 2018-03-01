package cz.peeta2.employeedatabase.model;

public class SoftwareTester extends Employee {

	private boolean knowsAutomatedTests;

	private void setKnowsAutomatedTests(boolean knowsAutomatedTests) {
		this.knowsAutomatedTests = knowsAutomatedTests;
	}

	public boolean getKnowsAutomatedTests() {
		return knowsAutomatedTests;
	}

	public SoftwareTester(String firstname, String surname, boolean knowsJava, Office office) {
		super(firstname, surname, office);
		setKnowsAutomatedTests(knowsJava);
	}

	public SoftwareTester(String firstname, String surname, boolean knowsJava) {
		super(firstname, surname);
		setKnowsAutomatedTests(knowsJava);
	}

}

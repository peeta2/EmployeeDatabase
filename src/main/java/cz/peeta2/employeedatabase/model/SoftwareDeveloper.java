package cz.peeta2.employeedatabase.model;

public class SoftwareDeveloper extends Employee {

	private boolean knowsJava;

	private void setKnowsJava(boolean knowsJava) {
		this.knowsJava = knowsJava;
	}

	public boolean getKnowsJava() {
		return knowsJava;
	}

	public SoftwareDeveloper(String firstname, String surname, boolean knowsJava, Office office) {
		super(firstname, surname, office);
		setKnowsJava(knowsJava);
	}

	public SoftwareDeveloper(String firstname, String surname, boolean knowsJava) {
		super(firstname, surname);
		setKnowsJava(knowsJava);
	}

}

package cz.peeta2.employeedatabase.model;

public class Employee {
	private String firstname;
	private String surname;
	
	private Office office;

	public Employee(String firstname, String surname) {
		this.firstname = firstname;
		this.surname = surname;
	}
	
	public Employee(String firstname, String surname, Office office) {
		this(firstname, surname);
		this.office = office;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Office getOffice() {
		return office;
	}

	public void setOffice(Office office) {
		this.office = office;
	}
	
	public String getName() {
		return firstname + " " + surname;
	}
	
}

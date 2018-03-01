package cz.peeta2.employeedatabase;

import java.util.List;
import cz.peeta2.employeedatabase.model.Employee;
import cz.peeta2.employeedatabase.model.Office;
import cz.peeta2.employeedatabase.model.SoftwareDeveloper;
import cz.peeta2.employeedatabase.model.SoftwareTester;

public class CLIPrinter {
	private EmployeeDatabase employeeDatabase;

	private EmployeeDatabase getEmployeeDatabase() {
		return this.employeeDatabase;
	}

	public CLIPrinter(EmployeeDatabase employeeDatabase) {
		this.employeeDatabase = employeeDatabase;
	}

	protected String getReadableEmployeeRole(Employee employee) {
		return employee.getClass().getSimpleName().replaceAll(
				String.format("%s|%s|%s", "(?<=[A-Z])(?=[A-Z][a-z])",
				"(?<=[^A-Z])(?=[A-Z])", "(?<=[A-Za-z])(?=[^A-Za-z])"), " ");
	}
	
	protected String specialSkills(Employee employee) {
		String skills = "";
		switch (employee.getClass().getSimpleName()) {
		case "SoftwareDeveloper":
			if(((SoftwareDeveloper)employee).getKnowsJava())
				skills = "He knows Java. ";
			break;
		case "SoftwareTester":
			if(((SoftwareTester)employee).getKnowsAutomatedTests())
				skills = "He knows automated test. ";
		}
		
		return skills;
	}
	
	private String getOfficeInfo(Office office) {
		if (office == null) return "";
		else return "You can find him in office " + office.getName() + ". ";
	}
	
	private void printEmployeeDetail(Employee employee) {
		String employeeRole = getReadableEmployeeRole(employee);
		String skills = specialSkills(employee);
		String officeInfo = getOfficeInfo(employee.getOffice());
		System.out.println(employee.getName() + " is " + employeeRole  + ". " + skills + officeInfo);
	}

	protected void printEmployeesInOffice(Office office) {
		List<Employee> employeesInOffice = this.getEmployeeDatabase().getEmployeesInOffice(office);
		employeesInOffice.stream().forEach(employee -> printEmployeeDetail(employee));
	}

	protected void printOfficeDetail(Office office) {
		System.out.println("Office " + office.getName() + " has an area " + office.getArea() + "m2, and area per employee is "
				+ getEmployeeDatabase().getAreaInOfficePerEmployee(office) + "m2" );
	}

	protected void printOffices() {
		System.out.println("Offices:");
		getEmployeeDatabase().getOffices().forEach((office) -> {
			printOfficeDetail(office);
			printEmployeesInOffice(office);
		});
	}

	protected void printEmployees() {
		getEmployeeDatabase().getEmployees().stream().forEach(employee -> printEmployeeDetail(employee));
	}

	protected void printStats() {
		System.out.println("Statistics:");
		printNumberOfEmployees();
		printNumberOfOffices();
		printAverageAreaPreEmployee();
		printAllOfficesStatistics();
	}

	protected void printAverageAreaPreEmployee() {
		System.out.println("Average area per employee " + getEmployeeDatabase().getAverageAreaPerEmployee());
	}

	protected void printNumberOfEmployees() {
		System.out.println("Number of employees: " + getEmployeeDatabase().getNumberOfEmployees());
	}

	protected void printNumberOfOffices() {
		System.out.println("Number of offices: " + getEmployeeDatabase().getNumberOfOffices());
	}

	protected void printAllOfficesStatistics() {
		System.out.println("List of offices");
		getEmployeeDatabase().getOffices().stream().forEach(office -> printOfficeDetail(office));
	}

}
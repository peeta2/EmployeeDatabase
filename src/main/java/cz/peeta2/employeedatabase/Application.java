package cz.peeta2.employeedatabase;

public class Application {

	public static void main(String[] args) {
		EmployeeDatabase employeeDatabase;
		try {
			employeeDatabase = new EmployeeDatabaseFactory().getSampleEmployeeDatabase();
		} catch (Exception e) {
			employeeDatabase = new EmployeeDatabase();
		}
		CLI cli = new CLI(employeeDatabase);
		
		cli.start();
	}
}
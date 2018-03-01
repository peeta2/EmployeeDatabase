package cz.peeta2.employeedatabase;

public class Application {

	public static void main(String[] args) {
		CLI cli = new CLI(new EmployeeDatabase());
		cli.start();
	}
}

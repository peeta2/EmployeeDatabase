package cz.peeta2.employeedatabase;

import static org.junit.Assert.*;

import org.junit.Test;

public class CreateEmployeeTest {

	@Test
	public void testCreateEmployyes()
			throws RoomAlreadyExistsException, RoomWasNotFoundException, RoomIsNotOfficeException, WrongArgumentException {
		EmployeeDatabase employeeDatabase = new EmployeeDatabaseFactory().getSampleEmployeeDatabase();
		CLI cli = new CLI(employeeDatabase);
		cli.parseCommand("Create Emp test employee Office_1");
		assertEquals("Adding of employee is broken", employeeDatabase.getNumberOfEmployees(), 6);
		assertEquals(9.0, employeeDatabase.getAreaInOfficePerEmployee(employeeDatabase.getOfficeByName("Office_1")), 0);
		assertEquals(72.0, employeeDatabase.getAverageAreaPerEmployee(), 0);
	}
}
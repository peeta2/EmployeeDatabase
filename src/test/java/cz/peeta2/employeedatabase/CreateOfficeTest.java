package cz.peeta2.employeedatabase;

import static org.junit.Assert.*;

import org.junit.Test;

public class CreateOfficeTest {

	@Test
	public void testCreateOffice()
			throws RoomAlreadyExistsException, RoomWasNotFoundException, RoomIsNotOfficeException, WrongArgumentException {
		EmployeeDatabase employeeDatabase = new EmployeeDatabaseFactory().getSampleEmployeeDatabase();
		CLI cli = new CLI(employeeDatabase);
		cli.parseCommand("Create Office Office_22 36");
		assertEquals("Stats number of offices are broken", employeeDatabase.getNumberOfOffices(), 12);
		assertEquals(36.0, employeeDatabase.getAreaInOfficePerEmployee(employeeDatabase.getOfficeByName("Office_22")), 0);
	}
}

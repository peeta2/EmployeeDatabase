package cz.peeta2.employeedatabase;

import static org.junit.Assert.*;

import org.junit.Test;

public class StatisticsTest {
	@Test
	public void testStats() throws RoomAlreadyExistsException, RoomWasNotFoundException, RoomIsNotOfficeException {
		EmployeeDatabase employeeDatabase = new EmployeeDatabaseFactory().getSampleEmployeeDatabase();
		assertEquals("Stats number of employees are broken", employeeDatabase.getNumberOfEmployees(), 5);
		assertEquals("Stats number of offices are broken", employeeDatabase.getNumberOfOffices(), 11);
		assertEquals(22.0, employeeDatabase.getAreaInOfficePerEmployee(employeeDatabase.getOfficeByName("Office_2")), 0);
		assertEquals(86.0, employeeDatabase.getAverageAreaPerEmployee(), 0);
	}
	
	@Test
	public void testStatsForEmptyDatabase() throws RoomAlreadyExistsException, RoomWasNotFoundException, RoomIsNotOfficeException {
		EmployeeDatabase employeeDatabase = new EmployeeDatabase();
		assertEquals("Stats number of employees are broken", employeeDatabase.getNumberOfEmployees(), 0);
		assertEquals("Stats number of offices are broken", employeeDatabase.getNumberOfOffices(), 0);
		assertEquals(0, employeeDatabase.getAverageAreaPerEmployee(), 0);
	}
}
package cz.peeta2.employeedatabase;

public class EmployeeDatabaseFactory {

	public EmployeeDatabase getSampleEmployeeDatabase()
			throws RoomAlreadyExistsException, RoomWasNotFoundException, RoomIsNotOfficeException {
		EmployeeDatabase employeeDatabase = new EmployeeDatabase();

		employeeDatabase.createMeetingRoom("Meeting_room_1", 56);
		employeeDatabase.createMeetingRoom("Meeting_room_2", 22);
		employeeDatabase.createMeetingRoom("Meeting_room_3", 52);
		employeeDatabase.createMeetingRoom("Meeting_room_4", 110);
		employeeDatabase.createOffice("Office_1", 28);
		employeeDatabase.createOffice("Office_2", 22);
		employeeDatabase.createOffice("Office_3", 31);
		employeeDatabase.createOffice("Office_4", 35);
		employeeDatabase.createOffice("Office_5", 24);
		employeeDatabase.createOffice("Office_6", 24);
		employeeDatabase.createOffice("Office_7", 29);
		employeeDatabase.createEmployee("Josef", "Novak", "Office_2");
		employeeDatabase.createEmployee("Alois", "Jirasek");
		employeeDatabase.createEmployee("Jonas", "Zendl", "Office_1");
		employeeDatabase.createSoftwareDeveloper("Jack", "Stevenson", true, "Office_1");
		employeeDatabase.createSoftwareDeveloper("Josef", "Blaha", false, "Office_4");

		return employeeDatabase;
	}

}
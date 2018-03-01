package cz.peeta2.employeedatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import cz.peeta2.employeedatabase.model.Employee;
import cz.peeta2.employeedatabase.model.MeetingRoom;
import cz.peeta2.employeedatabase.model.Office;
import cz.peeta2.employeedatabase.model.Room;
import cz.peeta2.employeedatabase.model.SoftwareDeveloper;
import cz.peeta2.employeedatabase.model.SoftwareTester;

public class EmployeeDatabase {

	private List<Room> rooms;

	private List<Employee> employees;

	private List<Room> getRooms() {
		return rooms;
	}

	public List<Office> getOffices() {
		return getRooms().stream().filter(room -> room instanceof Office).map(room -> (Office) room)
				.collect(Collectors.toList());
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	// statistics
	public int getNumberOfEmployees() {
		return getEmployees().size();
	}

	public int getNumberOfOffices() {
		return getRooms().size();
	}

	private int getTotalArea() {
		return getRooms().stream().mapToInt(room -> room.getArea()).sum();
	}

	public double getAverageAreaPerEmployee() {
		if (getNumberOfEmployees() == 0)
			return getTotalArea();
		else
			return getTotalArea() / getNumberOfEmployees();
	}

	public Room getRoomByName(String name) {
		return getRooms().stream().filter(room -> room.getName().equals(name)).findFirst().get();
	}

	public Office getOfficeByName(String name) throws RoomWasNotFoundException, RoomIsNotOfficeException {

		Room room = getRoomByName(name);

		if (room == null)
			throw new RoomWasNotFoundException(name);

		if (room.getClass() != Office.class)
			throw new RoomIsNotOfficeException(name);

		return (Office) room;

	}

	private boolean doesRoomExists(String name) {
		return getRooms().stream().anyMatch(office -> office.getName().equals(name));
	}

	public EmployeeDatabase() {
		rooms = new ArrayList<Room>();

		employees = new ArrayList<Employee>();
	}

	public void ensureRoomDontExists(String name) throws RoomAlreadyExistsException {
		if (doesRoomExists(name))
			throw new RoomAlreadyExistsException(name);
	}

	public void createOffice(String name, int area) throws RoomAlreadyExistsException {
		ensureRoomDontExists(name);
		getRooms().add(new Office(name, area));
	}

	public void createMeetingRoom(String name, int area) throws RoomAlreadyExistsException {
		ensureRoomDontExists(name);
		getRooms().add(new MeetingRoom(name, area));
	}

	public void createEmployee(String firstname, String surname) {
		getEmployees().add(new Employee(firstname, surname));
	}

	public void createEmployee(String firstname, String surname, String officeName)
			throws RoomWasNotFoundException, RoomIsNotOfficeException {
		Office office = getOfficeByName(officeName);
		getEmployees().add(new Employee(firstname, surname, office));
	}

	public void createSoftwareDeveloper(String firstname, String surname, boolean knowsJava) {
		getEmployees().add(new SoftwareDeveloper(firstname, surname, knowsJava));
	}

	public void createSoftwareDeveloper(String firstname, String surname, boolean knowsJava, String officeName)
			throws RoomWasNotFoundException, RoomIsNotOfficeException {
		Office office = getOfficeByName(officeName);
		getEmployees().add(new SoftwareDeveloper(firstname, surname, knowsJava, office));
	}

	public void createSoftwareTester(String firstname, String surname, boolean knowsAutomatedTests) {
		getEmployees().add(new SoftwareTester(firstname, surname, knowsAutomatedTests));
	}

	public void createSoftwareTester(String firstname, String surname, boolean knowsAutomatedTests, String officeName)
			throws RoomWasNotFoundException, RoomIsNotOfficeException {
		Office office = getOfficeByName(officeName);
		getEmployees().add(new SoftwareTester(firstname, surname, knowsAutomatedTests, office));
	}

	public List<Employee> getEmployeesInOffice(Office office) {
		return getEmployees().stream().filter(employee -> employee.getOffice() == office).collect(Collectors.toList());
	}

	public double getAreaInOfficePerEmployee(Office office) {
		int employeesCount = getEmployeesInOffice(office).size();

		if (employeesCount == 0)
			return office.getArea();
		else
			return office.getArea() / employeesCount;
	}

}

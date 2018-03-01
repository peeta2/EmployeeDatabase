package cz.peeta2.employeedatabase;

import java.util.Scanner;

public class CLI {
	private CLIPrinter printer;

	private EmployeeDatabase employeeDatabase;

	public CLI(EmployeeDatabase employeeDatabase) {
		this.employeeDatabase = employeeDatabase;
		printer = new CLIPrinter(employeeDatabase);
	}

	private EmployeeDatabase getEmployeeDatabase() {
		return employeeDatabase;
	}

	public void start() {

		while (true) {
			System.out.print("employeedb>");

			Scanner scan = new Scanner(System.in);
			String command = scan.nextLine();

			if (command.equals("exit")) {
				scan.close();
				System.exit(0);
			}
			try {
				parseCommand(command);
			} catch (RoomWasNotFoundException | RoomAlreadyExistsException | RoomIsNotOfficeException
					| WrongArgumentException e) {
				System.out.println(e.getMessage());
			} catch (NumberFormatException e) {
				System.out.println("Number was expected! Please, check documentation for deatils.");
			}

		}

	}

	public void parseCommand(String command) throws WrongArgumentException, RoomWasNotFoundException,
			RoomIsNotOfficeException, NumberFormatException, RoomAlreadyExistsException {
		String[] commands = command.split(" ");
		switch (commands[0]) {
		case "Show":
			parseShow(commands);
			break;
		case "Create":
			parseCreate(commands);
			break;
		default:
			throw new WrongArgumentException();
		}
	}

	private void parseShow(String[] commands) throws WrongArgumentException {
		switch (commands[1]) {
		case "Offices":
			printer.printOffices();
			break;
		case "Emps":
			printer.printEmployees();
			break;
		case "Stats":
			printer.printStats();
			break;
		default:
			throw new WrongArgumentException();
		}
	}

	private void parseCreate(String[] commands) throws WrongArgumentException, RoomWasNotFoundException,
			RoomIsNotOfficeException, NumberFormatException, RoomAlreadyExistsException {
		String option = commands[1];
		switch (option) {
		case "Office":
		case "MeetingRoom":
			parseCreateRoom(commands, option);
			break;
		case "Emp":
		case "DevEmp":
		case "TestEmp":
			parseCreateEmployeeCommand(commands, option);
			break;
		default:
			throw new WrongArgumentException();
		}
	}

	private void parseCreateRoom(String[] command, String type)
			throws WrongArgumentException, NumberFormatException, RoomAlreadyExistsException {
		if (command.length != 4)
			throw new WrongArgumentException();
		else
			switch (type) {
			case "Office":
				this.getEmployeeDatabase().createOffice(command[2], Integer.parseInt(command[3]));
				break;
			case "MeetingRoom":
				this.getEmployeeDatabase().createMeetingRoom(command[2], Integer.parseInt(command[3]));
				break;
			}

	}

	private boolean checkForSkill(String skill) throws WrongArgumentException {
		switch (skill) {
		case "yes":
			return true;
		case "no":
			return false;
		default:
			throw new WrongArgumentException(skill);
		}

	}

	private void parseCreateEmployeeCommand(String[] commands, String employeeType)
			throws WrongArgumentException, RoomWasNotFoundException, RoomIsNotOfficeException {
		if (commands.length < 4 && commands.length < 6)
			throw new WrongArgumentException();
		else
			switch (employeeType) {
			case "Emp":
				if (commands.length > 4)
					this.getEmployeeDatabase().createEmployee(commands[2], commands[3], commands[4]);
				else
					this.getEmployeeDatabase().createEmployee(commands[2], commands[3]);
				break;
			case "DevEmp":
				boolean knowsJava = checkForSkill(commands[4]);
				if (commands.length > 5)
					getEmployeeDatabase().createSoftwareDeveloper(commands[2], commands[3], knowsJava, commands[5]);
				else
					getEmployeeDatabase().createSoftwareDeveloper(commands[2], commands[3], knowsJava);
				break;
			case "TestEmp":
				boolean knowsAutomatedTests = checkForSkill(commands[4]);
				if (commands.length > 5)
					getEmployeeDatabase().createSoftwareTester(commands[2], commands[3], knowsAutomatedTests,
							commands[5]);
				else
					getEmployeeDatabase().createSoftwareTester(commands[2], commands[3], knowsAutomatedTests);
				break;
			}

	}

}
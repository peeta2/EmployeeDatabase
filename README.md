# EmployeeDatabase
Assignment for a job interview.

Requirements

The application should store data about all employees (first name, surname) and offices (name, area) and location of each employee in the office. Each employee can be assigned just one office.

If employee is a developer it should track if he knows Java.

If employee is a tester it should track if he knows automated tests.

If office is a meeting room there cannot be assigned any employee.

It should be able to print assignments of employees to offices sorted either by surname or by office name.

It should be able to print statistics:

Number of employees
Number of offices
Average area (m2) per one employee
List all offices and write area per one employee of particular office
User Interface

The application is controlled by commands written to some command line (asked by the application) in the following syntax:

Create Office name, area – creates a new office with given name and area
Create MeetingRoom name, area – creates a new meeting room with given name and area
Create Emp firstname, surname<<, officename>>  – creates a new employee with first name and surname and optionally assigns him to the office with given name
Create DevEmp firstname, surname, yes/no<<, officename>>  – creates a new employee as a developer with first name and surname with a flag (yes or no) if he knows Java and optionally assigns him to the office with given name
Create TestEmp firstname, surname, yes/no <<, officename>>  – creates a new employee as a tester with first name and surname with a flag (yes or no) if he knows automated tests and optionally assigns him to the office with given name
Show Offices – lists offices with assigned employees, showing name, surname and whether it is a normal/developer/employee and informing about special characteristic
Show Emps – lists employees showing first name, surname and whether it is a normal/developer/employee and informing about special characteristic, and assigned office
Show Stats – shows the statistics as described in Requirements
Architecture

It should be written in Java (it is preferred), as a console application communicating via standard input and output. Clear design and good maintainability and understandability are appreciated.

Estimated implementation time is about 6-8 hours. If you reach 8 hours you may contact me and send me the result.

    
  Feature: employee managment
	
	Scenario: Save employee data
		Given employee object
		When  an employee is saved to db
		Then  it should return saved employee object

	Scenario: user wants to get employee by id
		When  employee id is given as 111
		Then  it should return an employee record


	Scenario: user wants to get all the employees
		Then it should return all the employees

	Scenario: is to update employee by id
		When employee object is matched with an existing id 222
		Then it should update with the employee with new values

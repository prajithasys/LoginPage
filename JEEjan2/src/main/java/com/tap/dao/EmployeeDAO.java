package com.tap.dao;

import com.tap.models.Employee;

public interface EmployeeDAO {
	
	void addEmployee(Employee e);
	
	Employee getEmployeeByName(String name);
}

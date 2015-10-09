package com.fission.service;

import java.util.List;

import com.fission.model.Employee;


public interface EmpService {
	
	public List<Employee> listEmployees();
	public void addEmployee(Employee e);
	public void updateEmployee(Employee e);
	public Employee getEmployeeByEmpId(int id);
	public void removeEmployee(int id);
}

package com.fission.service;

import java.util.List;

import javax.transaction.Transactional;

import com.fission.dao.EmpDao;
import com.fission.model.Employee;

public class EmpServiceImpl implements EmpService {

	private EmpDao ed;
	
	public EmpDao getEd() {
		return ed;
	}

	public void setEd(EmpDao ed) {
		this.ed = ed;
	}

	@Override
	@Transactional
	public List<Employee> listEmployees() {
		return this.ed.listEmployees();
	}

	@Override
	@Transactional
	public void addEmployee(Employee e) {
			this.ed.addEmployee(e);
	}

	@Override
	@Transactional
	public void updateEmployee(Employee e) {
		System.out.println("EmpService update");
		this.ed.updateEmployee(e);
	}

	@Override
	@Transactional
	public Employee getEmployeeByEmpId(int id) {
		return this.ed.getEmployeeByEmpId(id);
	}

	@Override
	@Transactional
	public void removeEmployee(int id) {
			this.ed.removeEmployee(id);
	}

}

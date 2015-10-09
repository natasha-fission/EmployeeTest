package com.fission.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fission.model.Employee;

public class EmpDaoImpl implements EmpDao {

	private SessionFactory sessionFactory;
	
	private static final Logger logger = LoggerFactory.getLogger(EmpDaoImpl.class);

	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> listEmployees() {
		Session ses= sessionFactory.openSession();
		List<Employee>emp= ses.createQuery("from Employee").list();
	/*	for(Employee e: emp){
			System.out.println(e);
		}
		*/
		return emp;
	}
	
	@Override
	public void addEmployee(Employee e) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(e);
			
	}

	@Override
	public void updateEmployee(Employee e) {
		Session session = sessionFactory.getCurrentSession();
	//	System.out.println("EmpDao updatae");
		session.update(e);
//		System.out.println("logged");
	//	Query q=session.createQuery("update Employee set name='"+e.getName()+"',designation ='"+e.getDesignation()+"',contactNo="+e.getContactNo()+"where empID="+e.getEmpID());
	//	q.executeUpdate();
	//	session.close();
		session.flush();
	}

	@Override
	public Employee getEmployeeByEmpId(int id) {
		Session session = this.sessionFactory.openSession();		
		Employee e = (Employee) session.load(Employee.class, new Integer(id));
		return e;
	}

	@Override
	public void removeEmployee(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Employee e = (Employee) session.load(Employee.class, new Integer(id));
		if(null != e){
			session.delete(e);
		}
	}

}

package at.splendit.example.hibernate.dao;

import at.splendit.example.hibernate.domain.Employee;

public class EmployeeDao extends AbstractBasicDaoSupport<Employee, Long> implements InterfaceEmployeeDao {

	public EmployeeDao() {
		super(Employee.class);
	}
}

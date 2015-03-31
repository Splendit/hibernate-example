package at.splendit.example.hibernate.service;

import at.splendit.example.hibernate.dao.InterfaceEmployeeDao;
import at.splendit.example.hibernate.domain.Employee;

public class EmployeeService extends AbstractBasicService<Employee, Long, InterfaceEmployeeDao> implements
		InterfaceEmployeeService {

}

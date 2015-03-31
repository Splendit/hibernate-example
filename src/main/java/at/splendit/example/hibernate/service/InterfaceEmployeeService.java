package at.splendit.example.hibernate.service;

import at.splendit.example.hibernate.dao.InterfaceEmployeeDao;
import at.splendit.example.hibernate.domain.Employee;

public interface InterfaceEmployeeService extends InterfaceBasicService<Employee, Long, InterfaceEmployeeDao> {

}

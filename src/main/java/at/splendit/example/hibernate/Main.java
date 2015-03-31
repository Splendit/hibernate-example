package at.splendit.example.hibernate;

import java.util.List;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import at.splendit.example.hibernate.domain.Employee;
import at.splendit.example.hibernate.service.InterfaceEmployeeService;

public class Main {

	private static final Logger log = LogManager.getLogger(Main.class);
	private static final int RANDOMCOUNT = 10;

	public static void main(String[] args) {
		log.info("loading ApplicationContext");
		@SuppressWarnings("resource")
		ApplicationContext appContext = new ClassPathXmlApplicationContext("spring/spring-context.xml");

		log.info("get employeeService");
		InterfaceEmployeeService employeeService = (InterfaceEmployeeService) appContext.getBean("employeeService");

		for (int i = 0; i < 10; i++) {
			log.info("create Employee");
			Employee employee = new Employee();
			employee.setUsername(RandomStringUtils.randomAlphabetic(RANDOMCOUNT));
			employee.setFirstName(RandomStringUtils.randomAlphabetic(RANDOMCOUNT));
			employee.setLastName(RandomStringUtils.randomAlphabetic(RANDOMCOUNT));
			log.info("save Employee");
			employeeService.save(employee);
			log.info(employee);
		}

		log.info("get all Employees");
		List<Employee> employees = employeeService.findAll();

		log.info(ArrayUtils.toString(employees));

		log.info("shutdown DB");
		employeeService.shutdown();

	}

}

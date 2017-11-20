package learn.sankar.webservices.database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import learn.sankar.webservices.models.Employee;

public class EmployeeDatabase {
	
	private static HashMap<Long,Employee> employeeMap = new HashMap<Long,Employee>();
	
	public EmployeeDatabase(){
		
	}
	
	public List<Employee> getAllEmployees(){
		return new ArrayList<Employee>(employeeMap.values());
	}

	public Employee updateEmployee(Employee e) {
		employeeMap.put(e.getId(), e);
		return e;
	}

	public void deleteEmployee(Long id) {
		employeeMap.remove(id);
	}

	public Employee createEmployee(Employee e) {
		
		Long id = (long) (employeeMap.size() +1);
		e.setId(id);
		employeeMap.put(id, e);
		return e;
	}
	
	

}

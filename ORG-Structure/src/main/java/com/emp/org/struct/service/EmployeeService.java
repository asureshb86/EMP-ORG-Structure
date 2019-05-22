package com.emp.org.struct.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.emp.org.struct.dao.EmployeeDAO;
import com.emp.org.struct.model.Employee;

public class EmployeeService {

	private static Map<Long, Employee> employees = EmployeeDAO.getEmployees();
	
	public static List<Employee> getAllEmployees() {		  
			return  new ArrayList<Employee>(employees.values());
	}
	
	public static Employee getEmployee(long employeeID) {
		return employees.get(employeeID);
	}
	
	public static Employee addEmployee(Employee emp) {
		emp.setEmpId(employees.size() + 200);
		employees.put(emp.getEmpId(), emp);
		return emp;
	}
	
	
	public static Employee updateEmployee(Employee emp) {
		System.out.println("employee Details" +employees.get(emp.getEmpId()));
		if (emp.getEmpId() <= 0) { 
			return null;   
		}
		
		employees.put(emp.getEmpId(), emp);
		return emp;
	}
	
	public static String getEmpReporties(long managerID) {
		return EmployeeDAO.getEmpReporties(managerID);
	}
	
	
	public static String getTotalSubOrdSalaries(long empID) {
		return EmployeeDAO.totalSalForSubOrdinates(empID);
	}
}


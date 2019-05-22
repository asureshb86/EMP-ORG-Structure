package com.emp.org.struct.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Employee {

	
	/*
	 * "Employee ID": 1490, "City Name": "New Delhi", "Salary": 200000,
	 * "First Name": "Suresh", "Second Name" : "Prabhu", "Manager Emp Id" :3450
	 */
	
	public static final String Response = null;
	private long empId; 
    private String cityName;
    private long salary;
    private String firstName;
    private String secondName;
    private long managerEmpId;
    
    public Employee() {
    	
    }
    
	public Employee(long empId, String cityName, long salary, String firstName, String secondName,
			long managerEmpId) {
		
		this.empId = empId;
		this.cityName = cityName;
		this.salary = salary;
		this.firstName = firstName;
		this.secondName = secondName;
		this.managerEmpId = managerEmpId;
	}
	
	public long getEmpId() {
		return empId;
	}
	public void setEmpId(long empId) {
		this.empId = empId;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public long getSalary() {
		return salary;
	}
	public void setSalary(long salary) {
		this.salary = salary;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getSecondName() {
		return secondName;
	}
	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}
	public long getManagerEmpId() {
		return managerEmpId;
	}
	public void setManagerEmpId(long managerEmpId) {
		this.managerEmpId = managerEmpId;
	}
}


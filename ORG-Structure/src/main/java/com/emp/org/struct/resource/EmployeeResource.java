package com.emp.org.struct.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.emp.org.struct.model.Employee;
import com.emp.org.struct.service.EmployeeService;

@Path("/employees")
public class EmployeeResource {

	@GET
	//@Produces(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON) 
	public List<Employee> getEmployees() {
		
		return EmployeeService.getAllEmployees();
	}
	
	@GET
	@Path("employeeID/{employeeId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Employee getEmployee(@PathParam("employeeId") long employeeID) {
		
		return EmployeeService.getEmployee(employeeID);
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Employee addEmployee(Employee emp) {
		
		return EmployeeService.addEmployee(emp);
	}
	
	@PUT
	@Path("/{empId}") 
	@Produces(MediaType.APPLICATION_JSON)  
	@Consumes(MediaType.APPLICATION_JSON)
	public Employee updateEmpDetails(@PathParam("empId") long empId, Employee emp) {
		emp.setEmpId(empId);
		return EmployeeService.updateEmployee(emp);
	}
	
	@GET
	@Path("empID/{empID}")
	@Produces(MediaType.TEXT_PLAIN) 
	public String getSubOrdinates(@PathParam("empID") long empID) {
		
		if(empID == 0)
			return "Error Returned: Employee cannot be zero";
		
		return EmployeeService.getEmpReporties(empID);
	}
	
	
	@GET
	@Path("sumOfsubOrdSalaries/{empID}")
	@Produces(MediaType.TEXT_PLAIN) 
	public String getTotSubOrdSalaries(@PathParam("empID") long empID) {
		
		if(empID == 0)
			return "Error Returned: Employee cannot be zero";
		
		return EmployeeService.getTotalSubOrdSalaries(empID);
	}
}

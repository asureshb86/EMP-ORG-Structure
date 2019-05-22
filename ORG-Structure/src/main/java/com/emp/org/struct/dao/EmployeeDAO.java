package com.emp.org.struct.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.emp.org.struct.model.Employee;
import com.emp.org.struct.utility.LoadJSONUtility;

public class EmployeeDAO {

	private static Map<Long, Employee> employees = EmployeeDAO.getEmployees();
	private static StringBuilder empStbd = new StringBuilder();
	private static StringBuilder totalStbd = new StringBuilder();
	private static List<Long> totalEmp = new ArrayList<Long>();
	private static String empName = null;
    private static long sumOfSalary = 0;
	
	
	/**
	 * 
	 * This methods reads the json file and returns
	 * total number of employees in an organization
	 *
	 * @return Map<Long,Employee>  Returns a list of all Employees in 
	 *                             an Organization. 
	 * 
	 */
	public static Map<Long,Employee> getEmployees() {
		return LoadJSONUtility.readJsonFile();
	}
	
	/**
	 * 
	 * Returns a String on the screen. 
	 * This methods takes mangerID as an input argument. and returns
	 * the employee details who are reporting under him  
	 *
	 *
	 * @param  mangerID  Manager's Employee ID.
	 * @return String    Return list of Employee's for a specific Manager.
	 * 
	 */
	public static String getEmpReporties(long managerID) {
        
		totalStbd.setLength(0);
		getSubEmpDetails(managerID, false);   
		
        if(totalEmp.size() == 1)
        	totalStbd.append("\n Only one employee reporting to  " +managerID);
        
        else if(totalEmp.size() > 0 && totalEmp.size() != 1 )
        	totalStbd.append("Total  number of employees directly reporting to  " +managerID+ ": " +totalEmp.size());
            
        totalStbd.append("\n---------------------------------------------------------");
        return totalStbd.toString() + "\n" +empStbd.toString();
	}

	/**
	 * 
	 * Returns a Detailed list of Sub-ordinates and their total salary. 
	 * This methods takes employee ID as an input argument. and returns
	 * the total salary of all employees who are reporting under him.  
	 *
	 *
	 * @param  empID     Indicates the Employee ID.
	 * @return String    Return the total salary of all 
	 *                   sub-ordinates employees who are
	 *                   reporting to a specific employee
	 * 
	 */
	public static String totalSalForSubOrdinates(long empID) {
	
		totalStbd.setLength(0);
		getSubEmpDetails(empID, true);   
		
        if(totalEmp.size() == 1)
        	totalStbd.append("\n Only one employee reporting to  " +empName+ "(EmpID: "  + empID + ")");
        
        else if(totalEmp.size() > 0 && totalEmp.size() != 1 )
        	totalStbd.append("Total  number of Sub Ordinates for " + empName + "(EmpID: "  + empID + "):-  " +totalEmp.size());
            
        totalStbd.append("\n--------------------------------------------------------------------------------");
        return totalStbd.toString() + "\n" +empStbd.toString() + "\n Total Salary of Sub-Ordinates : " +sumOfSalary;
	}
	
	
	/**
	 *
	 * @param  empID     Indicates the Employee ID.
	 * @param  boolean   If true compute the total salary 
	 *                   of sub-ordinates employees who are
	 *                   reporting to a specific employee
	 *                   else find the employees who are 
	 *                   reporting to a specific employee
	 * 
	 */
	private static void getSubEmpDetails(long empID, boolean value) {
		// TODO Auto-generated method stub
		
		 Employee emp = employees.get(empID);
	     empName = emp.getFirstName() + "  " +emp.getSecondName();
	     empStbd.setLength(0);
	     totalEmp.clear();

		for (Map.Entry<Long, Employee> empDetails : employees.entrySet()) { 
            Employee empObj = empDetails.getValue(); 
            
		if( empID == empObj.getManagerEmpId()) {
			
			if(!value) {
				 empStbd.append( empObj.getFirstName() + "  " + empObj.getSecondName() +  " with EmployeeID: " + empObj.getEmpId() + 
           		         "  is Reproting to  " +empName +"(EmpID: "  + empID + ")" + "\n"); 
                 totalEmp.add(empObj.getEmpId());
                 
			} else if(value) {
				
				empStbd.append(empObj.getFirstName() + "  " + empObj.getSecondName() +  " with EmployeeID: " + empObj.getEmpId() + "  is Sub-Ordinate to  " 
                        +empName +"(EmpID: "  + empID + ") and his salary is: " +empObj.getSalary() +" \n"); 
                sumOfSalary += empObj.getSalary();
                totalEmp.add(empObj.getEmpId());
                
			}
          }
		}
	  }
}

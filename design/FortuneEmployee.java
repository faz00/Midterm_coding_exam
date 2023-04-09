package design;

import java.util.ArrayList;
import java.util.List;

public class FortuneEmployee {

	/**
	 * FortuneEmployee class has a main methods where you will be able to create Object from
	 * EmployeeInfo class to use fields and attributes.Demonstrate as many methods as possible 
	 * to use with proper business work flow.Think as a Software Architect, Product Designer and 
	 * as a Software Developer.(employee.info.system) package is given as an outline,you need to elaborate
	 * more to design an application that will meet for fortune 500 Employee Information
	 * Services.
	 *
	 * Use any databases[MongoDB, Oracle, MySql] to store data and retrieve data.
	 *
	 **/
	public static void main(String[] args) {

		List<EmployeeInfo> employeeList = new ArrayList<>();

		employeeList.add(new EmployeeInfo( "John",1));
		employeeList.add(new EmployeeInfo("Sarah",2));
		employeeList.add(new EmployeeInfo("David",3));

		// iterate through the list and print out each employee id and name
		for (Employee employee : employeeList) {
			System.out.println("Employee ID: " + EmployeeInfo.getEmployeeId() + ", Employee Name: " + EmployeeInfo.getEmployeeName());
		}

/*		// create an instance of EmployeeInfo class
		EmployeeInfo employee = new EmployeeInfo("John", 1001);

		// set employee's department
		employee.assignDepartment("IT", employee.getEmployeeId());

		// set employee's salary
		employee.setSalary(50000);

		// calculate and print employee's bonus
		int yearsWithCompany = 5;
		int bonus = EmployeeInfo.calculateEmployeeBonus(yearsWithCompany,Performance.Good,employee.getEmployeeId(), employee.getSalary());
		System.out.println("Employee's bonus: $" + bonus);

		// calculate and print employee's pension

	//	int pension = EmployeeInfo.calculateEmployeePension(employee.getSalary());
	//	System.out.println("Employee's pension: $" + pension);

		// print employee information
		System.out.println("Employee ID: " + employee.getEmployeeId();
		System.out.println("Employee Name: " + employee.getEmployeeName());
		System.out.println("Employee Department: " + employee.getDepartment());
		System.out.println("Employee Salary: $" + employee.getSalary());
*/

	}

}

package design;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class EmployeeInfo extends EmployeeMethode implements Employee {

 /*This class can be implemented from Employee interface then add additional methods in EmployeeInfo class.
 * Also, Employee interface can be implemented into an abstract class.So create an Abstract class
 * then inherit that abstract class into EmployeeInfo class.Once you`re done with designing EmployeeInfo class,
 * go to FortuneEmployee class to apply all the fields and attributes.
 *
 * Important: YOU MUST USE the
 * OOP(abstraction,Encapsulation, Inheritance and Polymorphism) concepts in every level possible.
 * Use all kind of keywords(super,this,static,final........)
 * Implement Nested class.
 * Use Exception Handling.
 *
 */
    private static int id;
	private static String name;
	private String department;
	private static int salary;
	private int benefit;
	private static int count = 0;

	//Constructors
	public EmployeeInfo(int id, String name, String department, int salary, int benefit) {
		super(name,id);
		this.department = department;
		this.salary = salary;
		this.benefit = benefit;
	}


	public EmployeeInfo(int employeeId){

		super(employeeId);

		this.salary = salary;
		count++;
	}

	public EmployeeInfo(String name, int employeeId){

		super(name,employeeId);
		this.salary = salary;
		count++;
	}
	@Override
	public int employeeId(){
		return id;
	}

	//employeeName() will return employee name
	public String employeeName(){
		return getEmployeeName();
	}

	//assignDepartment() will assign employee to departments
	public void assignDepartment(){
		this.department=getDepartment();
	}

	//calculate employee salary
	public int calculateSalary(){
		return getSalary();
	}

	//employeeId() will return employee id.
 @Override
    public int employeeId(String name, String department){
		return id;
    }

	//employeeName() will return employee name
	@Override
	public String employeeName(int id){
		return name;
	}

	//assignDepartment() will assign employee to departments
	@Override
	public void assignDepartment(String name, int id){

		this.department = name + "-" + id;
	}

	//calculate employee salary

	@Override
	public int calculateSalary(int hourlyPay, int hoursWorked) {

		int salary = hoursWorked * hourlyPay;
		return salary;
	}


	@Override
	//employee benefit
	public void benefitLayout() {
		System.out.println("Employee Benefits:");
		System.out.println("- Health insurance");
		System.out.println("- 401(k) plan");
		System.out.println("- Paid time off");
		System.out.println("- Stock options");
	}


	// Getters and setters
	public static int getEmployeeId() {
		return id;
	}

	public void setEmployeeId(int employeeId) {
		this.id = employeeId;
	}

	public static String getEmployeeName() {
		return name;
	}

	public void setEmployeeName(String employeeName) {
		this.name = employeeName;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public static int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
	/*
	 * declare few static and final fields and some non-static fields
	 */
	static String companyName;

	/*
	 * You must implement the logic for below 2 methods and
	 * following 2 methods are prototype as well for other methods need to be design,
	 * as you will come up with the new ideas.
	 */

	/*
	 * you must have multiple constructor.
	 * Must implement below constructor.
	 */


	/*
	 * This methods should calculate Employee bonus based on salary and performance.
	 * Then it will return the total yearly bonus. So you need to implement the logic.
	 * Hints: 10% of the salary for best performance, 8% of the salary for average performance and so on.
	 * You can set arbitrary number for performance.
	 * So you probably need to send 2 arguments.
	 *
	 */
	public static int calculateEmployeeBonus(int numberOfYearsWithCompany,Performance perf,int id,int salary){
		int total=0;
		if(Performance.Best.equals(perf)){
              total= salary*8/100+numberOfYearsWithCompany;
		} else if (Performance.Average.equals(perf)) {
			total= salary*6/100+numberOfYearsWithCompany;
		}else if(Performance.NotBad.equals(perf)){
			total= salary*4/100+numberOfYearsWithCompany;
		}else{
			total=0;
		}

		return total;
	}

	/*
	 * This methods should calculate Employee Pension based on salary and numbers of years with the company.
	 * Then it will return the total pension. So you need to implement the logic.
	 * Hints: pension will be 5% of the salary for 1 year, 10% for 2 years with the company and so on.
	 *
	 */
	public static int calculateEmployeePension(int salary){
		/*int total=0;
        boolean validDate=false;
		Scanner sc  = new Scanner(System.in);
		while(!validDate){
		try {
			System.out.println("Please enter start date in format (example: May,2015): ");
			String joiningDate = sc.nextLine();
			System.out.println("Please enter today's date in format (example: August,2017): ");
			String todaysDate = sc.nextLine();
			String convertedJoiningDate = DateConversion.convertDate(joiningDate);
			String convertedTodaysDate = DateConversion.convertDate(todaysDate);

			//implement numbers of year from above two dates
			//Calculate pension
			LocalDate joiningLocalDate = LocalDate.parse(convertedJoiningDate);
			LocalDate todaysLocalDate = LocalDate.parse(convertedTodaysDate);
			Period period = Period.between(joiningLocalDate, todaysLocalDate);

			validDate = true;
		}catch (DateTimeException e) {
			System.out.println("Invalid date format. Please enter the date in format: MMMM,yyyy");
		}
		}

		int yearsOfService = periodes;
		//calculate pension based on years of service

		if (yearsOfService == 1) {
			total = (int) (salary * 0.05);
		} else if (yearsOfService == 2) {
			total = (int) (salary * 0.1);
		} else if (yearsOfService > 2) {
			total = (int) (salary * 0.15);
		}
		return total;*/
		int total=0;
		Scanner sc  = new Scanner(System.in);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM,yyyy");
		LocalDate joiningDate = null;
		LocalDate todaysDate=null;
		boolean validDate = false;

		while (!validDate) {
			try {
				System.out.println("Please enter start date in format (example: May,2015): ");
				joiningDate = LocalDate.parse(sc.nextLine() + ",01", formatter);
				System.out.println("Please enter today's date in format (example: August,2017): ");
				todaysDate = LocalDate.parse(sc.nextLine() + ",01", formatter);
				validDate = true;
			} catch (DateTimeParseException e) {
				System.out.println("Invalid date format. Please enter the date in format: MMMM,yyyy");
			}
		}

		//calculate number of years from above two dates
		long years = ChronoUnit.YEARS.between(joiningDate, todaysDate);

		//Calculate pension
		double pensionRate = 0.05; //5% pension rate for each year
		total = (int) (salary * years * pensionRate);

		return total;

	}

	private static class DateConversion {

		public DateConversion(Months months){}

		public static String convertDate(String date) {
			String [] extractMonth = date.split(",");
			String givenMonth = extractMonth[0];
			int monthDate = whichMonth(givenMonth);
			String actualDate = monthDate + "/" + extractMonth[1];
			return actualDate;
		}

		public static int whichMonth(String givenMonth) {
			Months months = Months.valueOf(givenMonth);
			int date = 0;
			switch (months) {
				case January:
					date = 1;
					break;
				case February:
					date = 2;
					break;
				case March:
					date = 3;
					break;
				case April:
					date = 4;
					break;
				case May:
					date = 5;
					break;
				case June:
					date = 6;
					break;
				case July:
					date = 1;
					break;
				case August:
					date = 1;
					break;
				case September:
					date = 1;
					break;
				case October:
					date = 1;
					break;
				case November:
					date = 1;
					break;
				case December:
					date = 1;
					break;
				default:
					date = 0;
					break;
			}
			return date;

		}
	}
}

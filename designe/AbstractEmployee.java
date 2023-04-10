package src.designe;
import java.util.Scanner;
public abstract class AbstractEmployee implements Employee{
    private int employeeId;
    private String name;
    private String department;
    private int salary;
    private int yearsWithCompany;
    static String companyName;
    private String emailAddress;
    private String phoneNumber;
    private String address;

    /*
     * You must implement the logic for below 2 methods and
     * following 2 methods are prototype as well for other methods need to be design,
     * as you will come up with the new ideas.
     */

    /*
     * you must have multiple constructors.
     * Must implement below constructor.
     */
    public AbstractEmployee(int employeeId) {
        this.employeeId = employeeId;
    }

    public AbstractEmployee(String name, int employeeId) {
        this.name = name;
        this.employeeId = employeeId;
    }

    /*
     * This methods should calculate Employee bonus based on salary and performance.
     * Then it will return the total yearly bonus. So you need to implement the logic.
     * Hints: 10% of the salary for best performance, 8% of the salary for average performance and so on.
     * You can set arbitrary number for performance.
     * So you probably need to send 2 arguments.
     *
     */
    @Override
    public int employeeId() {
        return this.employeeId;
    }

    @Override
    public String employeeName() {
        return this.name;
    }

    @Override
    public void assignDepartment() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter department name:");
        this.department = scanner.nextLine();
    }

    @Override
    public int calculateSalary() {
        // logic to calculate salary
        return this.salary;
    }

    @Override
    public void benefitLayout() {
        // logic for employee benefits layout
    }

    @Override
    public String getEmailAddress() {
        return this.emailAddress;
    }

    @Override
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Override
    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    @Override
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String getAddress() {
        return this.address;
    }

    @Override
    public void setAddress(String address) {
        this.address = address;
    }
    public void printEmployeeInfo() {
        // implementation for printing employee information
        System.out.println("Employee ID: " + employeeId());
        System.out.println("Employee Name: " + employeeName());
        System.out.println("Years with Company: " + getYearsWithCompany());
        System.out.println("Email Address: " + getEmailAddress());
        System.out.println("Phone Number: " + getPhoneNumber());
        System.out.println("Address: " + getAddress());
    }

    public int getYearsWithCompany() {
        return this.yearsWithCompany;
    }


    public int calculateAnnualAppraisal(int performance) {
        int appraisalPercentage = 0;
        if (performance >= 8 && performance <= 10) {
            appraisalPercentage = 5;
        } else if (performance >= 6 && performance < 8) {
            appraisalPercentage = 4;
        } else if (performance >= 4 && performance < 6) {
            appraisalPercentage = 3;
        } else if (performance >= 2 && performance < 4) {
            appraisalPercentage = 2;
        } else {
            appraisalPercentage = 1;
        }
        return (int) (this.salary * (appraisalPercentage / 100.0));
    }

    /*
     * Abstract method to calculate employee performance based on certain criteria.
     * This method should be implemented by the concrete child classes.
     */
    public abstract int calculatePerformance();

    /*
     * Abstract method to assign employee benefits based on certain criteria.
     * This method should be implemented by the concrete child classes.
     */
    public abstract void assignBenefits();

    public void setYearsWithCompany(int years) {
        this.yearsWithCompany=years;
    }
}

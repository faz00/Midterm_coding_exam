package src.designe;
import java.util.Scanner;
public class EmployeeInfo extends AbstractEmployee {
    /*This class can be implemented from Employee interface then add additional methods in EmployeeInfo class.
     * Also, Employee interface can be implemented into an abstract class.So create an Abstract class
     * then inherit that abstract class into EmployeeInfo class.Once you done with designing EmployeeInfo class,
     * go to FortuneEmployee class to apply all the fields and attributes.
     *
     * Important: YOU MUST USE the
     * OOP(abstraction,Encapsulation, Inheritance and Polymorphism) concepts in every level possible.
     * Use all kind of keywords(super,this,static,final........)
     * Implement Nested class.
     * Use Exception Handling.
     *
     */

    /*
     * declare few static and final fields and some non-static fields
     */

    private int employeeId;
    private String name;
    private String department;
    private int salary;
    private int yearsWithCompany;
    static String companyName;
    private String emailAddress;
    private String phoneNumber;
    private String address;

    public EmployeeInfo(int employeeId) {
        super(employeeId);
    }

    public EmployeeInfo(String name, int employeeId) {
        super(name, employeeId);
    }
    /*
     * This methods should calculate Employee bonus based on salary and performance.
     * Then it will return the total yearly bonus. So you need to implement the logic.
     * Hints: 10% of the salary for best performance, 8% of the salary for average performance and so on.
     * You can set arbitrary number for performance.
     * So you probably need to send 2 arguments.
     *
     */


    public int calculateEmployeeBonus(int numberOfYearsWithCompany, int performance) {
        int bonusPercentage = 0;
        if (performance >= 5 && performance <= 10) {
            bonusPercentage = 10;
        } else if (performance >= 4 && performance < 5) {
            bonusPercentage = 8;
        } else if (performance >= 2 && performance < 4) {
            bonusPercentage = 6;
        } else if (performance >= 1 && performance < 2) {
            bonusPercentage = 4;
        } else {
            bonusPercentage = 0;
        }
        return (int) (this.salary * (bonusPercentage / 100.0));
    }


    /*
     * This methods should calculate Employee Pension based on salary and numbers of years with the company.
     * Then it will return the total pension. So you need to implement the logic.
     * Hints: pension will be 5% of the salary for 1 year, 10% for 2 years with the company and so on.
     *
     */

    public int calculateEmployeePension() {
        int totalPension = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter start date in format (example: May,2015): ");
        String joiningDate = scanner.nextLine();
        System.out.println("Please enter today's date in format (example: August,2017): ");
        String todaysDate = scanner.nextLine();
        String convertedJoiningDate = DateConversion.convertDate(joiningDate);
        String convertedTodaysDate = DateConversion.convertDate(todaysDate);

        // calculate years of service
        int yearsOfService = calculateYearsOfService(convertedJoiningDate, convertedTodaysDate);

        if (yearsOfService > 0) {
            if (yearsOfService <= 5) {
                totalPension = (int) (this.salary * (yearsOfService * 0.05));
            } else if (yearsOfService > 5 && yearsOfService <= 10) {
                totalPension = (int) (this.salary * ((5 * 0.05) + ((yearsOfService - 5) * 0.10)));
            } else {
                totalPension = (int) (this.salary * ((5 * 0.05) + (5 * 0.10) + ((yearsOfService - 10) * 0.20)));
            }
        }

        return totalPension;
    }
    public void printEmployeeInfo() {
       super.printEmployeeInfo();
    }
    @Override
    public int calculatePerformance() {
        // implementation for calculating employee performance based on certain criteria
        // For example, let's assume that performance is calculated based on years with the company and salary
        int performance = 0;


        // Calculate performance based on salary
        if (salary > 50000) {
            performance += 3;
        } else if (salary > 40000) {
            performance += 2;
        } else if (salary > 30000) {
            performance += 1;
        }

        return performance;
    }

    @Override
    public void assignBenefits() {
        // implementation for assigning employee benefits based on certain criteria
        // For example, let's assume that benefits are assigned based on employee's department
        switch (department) {
            case "IT":
                System.out.println("Assigned benefits for IT department: Health insurance, Retirement plan");
                break;
            case "HR":
                System.out.println("Assigned benefits for HR department: Paid time off, Training opportunities");
                break;
            case "Finance":
                System.out.println("Assigned benefits for Finance department: Employee stock options, Bonus");
                break;
            default:
                System.out.println("No benefits assigned for department: " + department);
                break;
        }
    }
    private int calculateYearsOfService(String joiningDate, String todaysDate) {
        int yearsOfService = 0;
        String[] joining = joiningDate.split("/");
        String[] today = todaysDate.split("/");

        int joiningMonth = Integer.parseInt(joining[0]);
        int joiningYear = Integer.parseInt(joining[1]);

        int todayMonth = Integer.parseInt(today[0]);
        int todayYear = Integer.parseInt(today[1]);

        if (joiningYear <= todayYear) {
             if (joiningMonth <= todayMonth) {
                yearsOfService = todayYear - joiningYear;
            } else {
                yearsOfService = todayYear - joiningYear - 1;
            }
        }
        return yearsOfService;
    }
    public int calculateAnnualAppraisal(int performance){
        int cal = super.calculateAnnualAppraisal(performance);

        return cal;
    }

    public String getEmployeeName() {
        return this.name;
    }

    public int getEmployeeId() {
        return this.employeeId;
    }

    private static class DateConversion {

        public DateConversion(Months months) {
        }

        public static String convertDate(String date) {
            String[] extractMonth = date.split(",");
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

package design;

 abstract class EmployeeMethode {

     private  String name;
     private final int id;


     public EmployeeMethode(String name, int employeeId){

         this.id = employeeId;
         this.name = name;


     }
     public EmployeeMethode( int employeeId){
         this.id = employeeId;
     }
     //employeeId() will return employee id.
     public abstract int employeeId(String name, String department);

     //employeeName() will return employee name
     public abstract String employeeName(int id);

     //assignDepartment() will assign employee to departments
     public abstract void assignDepartment(String name, int id);

     //calculate employee salary
     public abstract int calculateSalary(int hourlyPay, int hoursWorked);
 }

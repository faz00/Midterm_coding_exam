package designe;

import org.junit.Assert;

public class UnitTestingEmployeeInfo {
    public static void main(String[] args) {
        //Write Unit Test for all the methods has been implemented in this package.
         EmployeeInfo employeeInfo;


            // Initialize EmployeeInfo object with sample data for testing
            employeeInfo = new EmployeeInfo("John Doe",1);
            employeeInfo.setYearsWithCompany(5);
            employeeInfo.setEmailAddress("johndoe@example.com");
            employeeInfo.setPhoneNumber("123-456-7890");
            employeeInfo.setAddress("1234 Elm Street, Springfield, IL");
            employeeInfo.setSalary(6000);


            System.out.println("CalculateEmployeeBonus");
            // Test case 1: Performance = 7, expected bonus = 10% of salary
            int bonus1 = employeeInfo.calculateEmployeeBonus(5, 6);
            Assert.assertEquals(600, bonus1);

            // Test case 2: Performance = 4.5, expected bonus = 8% of salary
            int bonus2 = employeeInfo.calculateEmployeeBonus(5, 4);
            Assert.assertEquals(480, bonus2);

            // Test case 3: Performance = 2.5, expected bonus = 6% of salary
            int bonus3 = employeeInfo.calculateEmployeeBonus(5, 2);
            Assert.assertEquals(360, bonus3);

            // Test case 4: Performance = 1.5, expected bonus = 4% of salary
            int bonus4 = employeeInfo.calculateEmployeeBonus(5, 1);
            Assert.assertEquals(240, bonus4);

            // Test case 5: Performance = 0, expected bonus = 0
            int bonus5 = employeeInfo.calculateEmployeeBonus(5, 0);
            Assert.assertEquals(0, bonus5);
        System.out.println("calculateEmployeeBonus CHECKED");


       System.out.println("testCalculatePerformance");
            // Test case 1: Employee with 0 years of experience
            employeeInfo.setSalary(2000);
            int performanceRating1 = employeeInfo.calculatePerformance();
            Assert.assertEquals(1, performanceRating1);

            // Test case 2: Employee with 1-5 years of experience
            employeeInfo.setSalary(3500);
            int performanceRating2 = employeeInfo.calculatePerformance();
            Assert.assertEquals(2, performanceRating2);

            // Test case 3: Employee with 6-10 years of experience
            employeeInfo.setSalary(5500);
            int performanceRating3 = employeeInfo.calculatePerformance();
            Assert.assertEquals(3, performanceRating3);



        System.out.println("testCalculatePerformance CHECKED");

            System.out.println("estSettersAndGetters");
            // Test setting and getting years with company
            employeeInfo.setYearsWithCompany(3);
            Assert.assertEquals(3, employeeInfo.getYearsWithCompany());

            // Test setting and getting email address
            employeeInfo.setEmailAddress("janesmith@example.com");
            Assert.assertEquals("janesmith@example.com", employeeInfo.getEmailAddress());

            // Test setting and getting phone number
            employeeInfo.setPhoneNumber("987-654-3210");
            Assert.assertEquals("987-654-3210", employeeInfo.getPhoneNumber());

            // Test setting and getting address
            employeeInfo.setAddress("5678 Oak Street, Springfield, IL");
            Assert.assertEquals("5678 Oak Street, Springfield, IL", employeeInfo.getAddress());

        System.out.println("Getters and setters CHECKED");


        System.out.println("Print values of Employees:");

        employeeInfo.printEmployeeInfo();

        System.out.println("printEmployeeInfo CHECKED");
        }

    }


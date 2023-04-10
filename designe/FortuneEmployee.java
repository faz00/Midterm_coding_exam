package src.designe;
import databases.ConnectToSqlDB;
import java.io.IOException;
import java.sql.*;

public class FortuneEmployee {
    /*
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

    public static void saveEmployeeInfo(EmployeeInfo employee) throws IOException, ClassNotFoundException {
        ConnectToSqlDB connectToSqlDB = new ConnectToSqlDB();

        try
        {
            PreparedStatement statement = connectToSqlDB.connect.prepareStatement("INSERT_EMPLOYEE_QUERY");
            statement.setString(1, employee.getEmployeeName());
            statement.setInt(2, employee.getEmployeeId());
            statement.setString(3, employee.getAddress());
            statement.setString(4, employee.getEmailAddress());
            statement.setString(5, employee.getPhoneNumber());
            statement.setInt(6, employee.getYearsWithCompany());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static EmployeeInfo getEmployeeInfo(int employeeId) {
        EmployeeInfo employee = null;
        ConnectToSqlDB connectToSqlDB = new ConnectToSqlDB();
        try
             {
                 PreparedStatement statement = connectToSqlDB.connect.prepareStatement("SELECT_EMPLOYEE_QUERY");
            statement.setInt(1, employeeId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String employeeName = resultSet.getString("employee_name");
                String address = resultSet.getString("address");
                String email = resultSet.getString("email");
                String phone = resultSet.getString("phone");
                int yearsWithCompany = resultSet.getInt("years_with_company");

                employee = new EmployeeInfo(employeeName, employeeId);
                employee.setAddress(address);
                employee.setEmailAddress(email);
                employee.setPhoneNumber(phone);
                employee.setYearsWithCompany(yearsWithCompany);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }
    public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException {


        // Create an instance of EmployeeInfo
        EmployeeInfo employee = new EmployeeInfo("John Doe", 1001);
        employee.setAddress("CO");
        employee.setEmailAddress("John@Doe.gmail.com");
        employee.setPhoneNumber("777855");
        employee.setYearsWithCompany(8);

        // Print employee information
        System.out.println("Employee Information:");
        employee.printEmployeeInfo();

        // Calculate and print employee bonus
        int performance = employee.calculatePerformance();
        int bonus = employee.calculateEmployeeBonus(7, performance);
        System.out.println("Employee Bonus: $" + bonus);

        // Calculate and print employee pension
    //    int pension = employee.calculateEmployeePension();
     //  System.out.println("Employee Pension: $" + pension);


       //Use any databases[MongoDB, Oracle, MySql] to store data and retrieve data.

        ConnectToSqlDB connectToSqlDB = new ConnectToSqlDB();
        ConnectToSqlDB.connectToSqlDatabase();

        System.out.println("Save the data in MySQL");

        try {
            final String CREATE_TABLE_QUERY = "CREATE TABLE IF NOT EXISTS employee_info ("
                    + "id INT(11) NOT NULL AUTO_INCREMENT, "
                    + "employee_name VARCHAR(255) NOT NULL, "
                    + "employee_id INT(11) NOT NULL, "
                    + "address VARCHAR(255), "
                    + "email VARCHAR(255), "
                    + "phone VARCHAR(255), "
                    + "years_with_company INT(11), "
                    + "PRIMARY KEY (id))";
            PreparedStatement ps;
            //connectToSqlDB.ps.executeUpdate(createTableSQL);
            try {
                ps = connectToSqlDB.connect.prepareStatement(CREATE_TABLE_QUERY);

                ps.executeUpdate();
            } catch (Exception e) {

                System.out.println("Check your connection:" + e.getMessage());
            }
        }catch (Exception e) {

            System.out.println(e.getMessage());
        }

        try {
             final String INSERT_QUERY = "INSERT INTO employee_info (employee_name, employee_id, address, email, phone, years_with_company) VALUES (?, ?, ?, ?, ?, ?)";

            PreparedStatement statement = ConnectToSqlDB.connect.prepareStatement(INSERT_QUERY);
            statement.setString(1, employee.employeeName());
            statement.setInt(2, employee.employeeId());
            statement.setString(3, employee.getAddress());
            statement.setString(4, employee.getEmailAddress());
            statement.setString(5, employee.getPhoneNumber());
            statement.setInt(6, employee.getYearsWithCompany());
            statement.executeUpdate();
            System.out.println("Data successfully inserted into MySQL database.");
        } catch (SQLException e) {
            System.out.println("Check your connection: " + e.getMessage());
        }

        System.out.println("Retrieve data from MYSQL: ");
        try
        {
            final String Select_QUERY = "SELECT * FROM employee_info";
            PreparedStatement statement = ConnectToSqlDB.connect.prepareStatement(Select_QUERY);

            ResultSet resultSet = statement.executeQuery();
            System.out.println("Employee Information:");
            System.out.println("-----------------------------------------------------------------------------------------------");
            System.out.printf("%-10s %-15s %-15s %-25s %-15s %-10s%n", "ID", "Name", "Employee ID", "Address", "Email", "Phone", "Years with Company");
            System.out.println("-----------------------------------------------------------------------------------------------");

            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                int employeeId = resultSet.getInt("employee_id");
                String employeeName = resultSet.getString("employee_name");
                String address = resultSet.getString("address");
                String email = resultSet.getString("email");
                String phone = resultSet.getString("phone");
                int yearsWithCompany = resultSet.getInt("years_with_company");

                System.out.printf("%-10d %-15s %-15d %-25s %-15s %-10s%n", id, employeeName, employeeId, address, email, phone, yearsWithCompany);

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

       /* try
        {
            PreparedStatement statement = connectToSqlDB.connect.prepareStatement("SELECT_EMPLOYEE_QUERY");
            statement.setInt(1, employee.getEmployeeId());
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String employeeName = resultSet.getString("employee_name");
                String address = resultSet.getString("address");
                String email = resultSet.getString("email");
                String phone = resultSet.getString("phone");
                int yearsWithCompany = resultSet.getInt("years_with_company");



            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(getEmployeeInfo(employee.getEmployeeId()));*/

        }
    }




package Hillel_29;

import Hillel_29.DatabaseConnector;
import Hillel_29.EmployeeDAO;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        DatabaseConnector dbConnector = new DatabaseConnector();
        try {
            dbConnector.connect();
            EmployeeDAO employeeDAO = new EmployeeDAO(dbConnector.getConnection());

            employeeDAO.addEmployee("Ivan", 30, "Developer", 50000f);
            employeeDAO.addEmployee("Olena", 28, "Analyst", 45000f);

            System.out.println("Employees after adding:");
            employeeDAO.getAllEmployees().forEach(System.out::println);

            employeeDAO.updateEmployee(1, "Ivan", 31, "Senior Developer", 70000f);

            System.out.println("Employees after updating:");
            employeeDAO.getAllEmployees().forEach(System.out::println);

            employeeDAO.deleteEmployee(2);

            System.out.println("Employees after deleting:");
            employeeDAO.getAllEmployees().forEach(System.out::println);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConnector.close();
        }
    }
}

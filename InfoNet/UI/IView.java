package UI;

import Core.Employee;

import java.util.ArrayList;

public interface IView {
    public String getEmployeeData();
    public String viewAllEmployees(ArrayList<Employee> employees);
}

package UI;

import Core.Employee;

import java.util.ArrayList;

public interface IView {
    /**
     * Метод получает данные о списке сотрудников
     */
    public String getEmployeeData();
    /**
     * Метод отображает список всех сотрудников компании
     * @param employees 
     */
    public void viewAllEmployees(ArrayList<Employee> employees);

    /**
     * Отображает любые данные.
     * @param data
     */
    public void printSomeData(String data);
}

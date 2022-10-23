package Model;

import Core.Company;
import Core.Employee;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

public interface IModel {
    /**
     * Метод заполняет штат сотрудников компании
     */
    public Company setStaffCompany(String data);
    /**
     * Метод возвращает список сотрудников компании.
     */
    public ArrayList<Employee> getEmployeeList();
    public String getIDList(String type);
    public void myImport(String fileName) throws IOException, ParseException;
    public void myExport() throws IOException;
    public ArrayList<Employee> findEmployee(String key);
    public void fireEmployee(ArrayList<Employee> employees);
}

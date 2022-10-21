package Model;

import Core.Company;
import Core.Employee;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

public interface IModel {
    public Company setStaffCompany(String data);
    public String getCompanyStaff(Employee employee);
    public ArrayList<Employee> getEmployeeList();
    public void myImport() throws IOException, ParseException;
    public void myExport() throws IOException;
}

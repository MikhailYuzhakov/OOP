package Model;

import Core.Company;
import Core.Employee;
import UI.View;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

public class Model implements IModel{
    Company company;
    public Model(){

        company = new Company();
    }

    @Override
    public Company setStaffCompany(String data) {
        String[] s = data.split(";");

        return null;
    }

    @Override
    public String getCompanyStaff(Employee employee) {
        return null;
    }

    @Override
    public ArrayList<Employee> getEmployeeList() {
        return company.listOfEmployees;
    }

    @Override
    public void myImport() throws IOException, ParseException {

    }

    @Override
    public void myExport() throws IOException {

    }
}

package Model;

import Core.*;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

public class Model implements IModel{
    private Company company;
    private Storage storage;
    private IDCreator employeeID;
    private IDCreator companyID;
    
    public Model() throws IOException {
        employeeID = new IDCreator();
        companyID = new IDCreator();
        company = new Company(companyID.getId(), "Yandex");
        storage = new Storage(company.name);
    }

    @Override
    public Company setStaffCompany(String data) {
        String[] s = data.split("\n");
        for (String item : s) {
            String[] employeeFields = item.split(";");
            if (employeeFields[3].matches("[0-9]+")) {
                Employee employee = new Employee(employeeID.getId(), employeeFields[0], employeeFields[1], 
                                                employeeFields[2], Integer.parseInt(employeeFields[3]));
                company.listOfEmployees.add(employee);
            } else {
                System.out.println("setStaffCompanyException: salary must been Integer");
                return null;
            }
        }
        return this.company;
    }

    @Override
    public ArrayList<Employee> getEmployeeList() {
        return company.listOfEmployees;
    }

    @Override
    public void myImport(String fileName) throws IOException, ParseException {
        ArrayList<Integer> ids = storage.myImport(fileName, company);
        employeeID.insertIds(ids);
    }

    @Override
    public void myExport() throws IOException {
        storage.myExport(company);
    }

    @Override
    public String getIDList(String type) {
        switch (type) {
            case "employee":
                return employeeID.getIDList();
            case "company":
                return companyID.getIDList();
            default:
                System.out.println("GetIDListException: В качестве типа укажите company или employee");
                return null;
        }
    }

    @Override
    public ArrayList<Employee> findEmployee(String key) {
        return company.findEmployee(key);
    }

    @Override
    public void fireEmployee(ArrayList<Employee> employees) {
        ArrayList<Integer> ids = company.fireEmployee(employees);
        employeeID.deleteID(ids);
    }
}

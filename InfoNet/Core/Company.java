package Core;

import java.util.ArrayList;
import java.util.List;

public class Company {
    public ArrayList<Employee> listOfEmployees;

    public Company(){

        listOfEmployees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {

        listOfEmployees.add(employee);
    }
    public void fireEmployee(Employee employee) {

        listOfEmployees.remove(employee);
    }
//    public Employee findEmployee(String key) {
//
//        listOfEmployees.contains(key);
//        return Employee ;
//    }

}

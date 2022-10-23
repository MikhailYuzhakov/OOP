package Core;

import java.util.ArrayList;

public class Company {
    public String name;
    private Integer id;
    public ArrayList<Employee> listOfEmployees;

    //подумать как сделать фильтр через наследование и instead of
    //создать иерархию Developer employee = new Employee(...);
    //if (employee insteadOf Developer) фильтр

    public Company(Integer id, String name){
        listOfEmployees = new ArrayList<>();
        this.name = name;
        this.id = id;
    }

    public void addEmployee(Employee employee) {
        listOfEmployees.add(employee);
    }

    /**
     * Метод увольняет сотрудника компании
     * @param employee
     */
    public ArrayList<Integer> fireEmployee(ArrayList<Employee> employees) {
        ArrayList<Integer> ids = new ArrayList<>();;
        if (!employees.isEmpty()) {
            for (Employee employee : employees) {
                listOfEmployees.remove(employee);
                ids.add(employee.getId());
            }
        } else {
            System.out.println("fireEmployeeException: employees isn't found");
        }
        return ids;
    }

    public Integer getId() {
        return this.id;
    }

    /**
     * Ищет сотрудника по ключу
     * @param key может быть id, name, surName, phonenumber, salary
     * @return
     */
    public ArrayList<Employee> findEmployee(String key) {
        if (key.matches("[0-9]+")) {
            return findThis(Integer.parseInt(key));
        } else {
            return findThis(key);
        }
    }

    /**
     * Ищет всех сотрудников компании по полям name, surName, phonenumber (поля String)
     */
    private ArrayList<Employee> findThis(String key) {
        ArrayList<Employee> filteredEmployees = new ArrayList<>();
        for (Employee employee : listOfEmployees) {
            if (employee.name.equals(key) | employee.surName.equals(key) | employee.phonenumber.equals(key)) {
                filteredEmployees.add(employee);
            }
        }
        return filteredEmployees;
    }

    /**
     * Ищет всех сотрудников компании по ID или по заработной плате (поля Integer)
     */
    private ArrayList<Employee> findThis(Integer key) {
        ArrayList<Employee> filteredEmployees = new ArrayList<>();
        for (Employee employee : listOfEmployees) { 
            if (employee.getId().equals(key) | employee.salary.equals(key)) {
                filteredEmployees.add(employee);
            }
        }
        return filteredEmployees;
    }
}

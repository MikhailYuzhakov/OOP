import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import Core.Employee;
import Model.*;
import UI.*;

public class Presenter {
    private IModel m;
    private IView v;
    private ArrayList<Employee> employees;

    public Presenter(IModel m, IView v) {
        this.m = m;
        this.v = v;
    }

    /**
     * Позволяет заполнить штат компании сотрудниками.
     */
    public void fillCompanyStaffBtn() {
       m.setStaffCompany(v.getEmployeeData());
    }

    /**
     * Печатает состав штата компании.
     */
    public void printCompanyStaffBtn() {
        v.viewAllEmployees(m.getEmployeeList());
    }

    /**
     * Печатает какие-либо данные (для отладки)
     */
    public void printSomeDataBtn() {
        v.printSomeData(m.getIDList("employee")); //или company
    }

    /**
     * Импортирует данные о компании
     */
    public void importBtn(String fileName) throws IOException, ParseException {
        m.myImport(fileName);
    }

    /**
     * Экспортирует данные о компании
     */
    public void exportBtn() throws IOException {
        m.myExport();
    }

    /**
     * Ищет всех сотрудников по заданному ключу (aka фильтр)
     * @param key
     */
    public Presenter findEmployeeBtn(String key, Boolean deleteThis) {
        if (deleteThis) {
            this.employees = m.findEmployee(key);
        } else {
            v.viewAllEmployees(m.findEmployee(key));
        }
        return this;
    }

    /**
     * Увольняет заданных сотрудников
     * @param key
     */
    public void fireEmployeesBtn() {
        m.fireEmployee(this.employees);
    }
}
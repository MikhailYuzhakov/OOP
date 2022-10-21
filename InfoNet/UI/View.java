package UI;
import Core.Company;
import Core.Employee;
import Model.Model;

import java.util.ArrayList;
import java.util.Scanner;

public class View implements IView{
    Scanner in;
    public View() {
        in = new Scanner(System.in);
    }
    @Override
    public String getEmployeeData(){
        StringBuilder sb = new StringBuilder();
        System.out.println("Введите имя: ");
        sb.append(in.nextLine());
        System.out.println("Введите фамилию: ");
        sb.append(in.nextLine());
        System.out.println("Введите телефон: ");
        sb.append(in.nextLine());
        System.out.println("Введите зарплату: ");
        sb.append(in.nextLine());
        return sb.toString();
    }

    @Override
    public String viewAllEmployees(ArrayList<Employee> employees) {
        for (Employee e: employees
             ) {
            System.out.println(e);
        }
        return "";
    }


}

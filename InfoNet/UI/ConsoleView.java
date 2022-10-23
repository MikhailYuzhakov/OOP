package UI;
import Core.*;

import java.util.ArrayList;
import java.util.Scanner;

public class ConsoleView implements IView{
    Scanner in;
    public ConsoleView() {
        in = new Scanner(System.in);
    }

    @Override
    public String getEmployeeData() {
        StringBuilder sb = new StringBuilder();
        sb.append("Ваня").append(";").append("Пупкин").append(";").append("8953444555").append(";").append((Integer) 35700).append("\n");
        sb.append("Вася").append(";").append("Петров").append(";").append("8953444666").append(";").append((Integer) 45900).append("\n");
        sb.append("Дима").append(";").append("Сидоров").append(";").append("8953444777").append(";").append((Integer) 88400).append("\n");
        sb.append("Миша").append(";").append("Иванов").append(";").append("8953444888").append(";").append((Integer) 39900).append("\n");
        sb.append("Катя").append(";").append("Алексеева").append(";").append("8953444999").append(";").append((Integer) 54300).append("\n");
        return sb.toString();
    }

    @Override
    public void viewAllEmployees(ArrayList<Employee> employees) {
        if (!employees.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (Employee e: employees) {
                sb.append(e);
            }
            System.out.println(sb);
        } else {
            System.out.println("viewAllEmployeesException: employees not found");
        }
    }

    @Override
    public void printSomeData(String data) {
        System.out.println(data);
    }
}

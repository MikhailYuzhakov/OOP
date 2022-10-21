package UI;
import Core.Employee;
import Model.Model;

import java.util.ArrayList;
import java.util.Scanner;

public class AutoView implements IView{
    Scanner in;
    public AutoView() {

        in = new Scanner(System.in);
    }


    @Override
    public String getEmployeeData(){
        StringBuilder sb = new StringBuilder();
        sb.append("Ваня").append(";").append("Пупкин").append(";").append("8953444555").append(";").append("100000");
        sb.append("Вася").append(";").append("Петров").append(";").append("8953444666").append(";").append("100000");
        sb.append("Дима").append(";").append("Сидоров").append(";").append("8953444777").append(";").append("100000");
        sb.append("Миша").append(";").append("Иванов").append(";").append("8953444888").append(";").append("100000");
        sb.append("Катя").append(";").append("Алексеева").append(";").append("8953444999").append(";").append("100000");

        return sb.toString();
    }

    public String viewAllEmployees(ArrayList<Employee> employees){
        StringBuilder sb = new StringBuilder();
        for (Employee e: employees
        ) {
            sb.append(e).append("\n");
        }
        return sb.toString();
    }


}

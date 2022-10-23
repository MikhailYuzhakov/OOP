import java.io.IOException;
import java.text.ParseException;

import Model.*;
import UI.*;

public class Program {
    public static void main(String[] args) throws IOException, ParseException {
        Presenter p = new Presenter(new Model(), new ConsoleView());
        //варианты заполнения базы данных
        // p.fillCompanyStaffBtn(); //вручную
        // p.printCompanyStaffBtn();

        // p.importBtn("Yandex.csv"); //импортировать из файла
        // p.printCompanyStaffBtn(); //показать всех сотрудников
        // p.printSomeDataBtn(); //показать базу идентификаторов
        // p.findEmployeeBtn("4", true).fireEmployeesBtn(); //уволить сотрудника с ID = 4
        // p.printCompanyStaffBtn(); //проверить
        // p.printSomeDataBtn();

        //вырианты выгрузки базы данных
        //p.exportBtn(); //экспорт в файл
        
        //операции над базой данных
        //p.findEmployeeBtn("88400", false); //найдет людей с зарплатой 88400
        //p.findEmployeeBtn("Иванов", false); //найдет сотрудников с фамилией Сидоров
        //p.findEmployeeBtn("4", true).fireEmployeesBtn(); //найти и уволить сотрудника
        //p.printSomeDataBtn();
    }
}

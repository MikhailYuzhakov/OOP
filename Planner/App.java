import java.io.IOException;

import org.json.simple.parser.ParseException;

import Model.Author;
import Model.Storage;
import Model.TaskManager;
import View.ConsoleView;

/**
 * App
 * Осталось дописать:
 * 1. Добавить дедлайн задачи+
 * 2. Сделать, чтобы даты хранились не в строках, а в объекте Date
 * 3. Добавить импорт данных
 */
public class App {

    public static void main(String[] args) throws IOException, ParseException {
        Presenter p = new Presenter(new ConsoleView(), new TaskManager("TM_1", 1), new Storage());
        Author a1 = new Author(1, "Mike");
        Author a2 = new Author(2, "Fedor");

        
        // p.btn1Click("Do OOP homework", a1.id, 9, "15 Oct 16:40"); //создает задачи вручную
        // p.btn1Click("Do Java homework", a2.id, 4, "16 Oct 16:40");
        // p.btn1Click("Do Python homework", a1.id, 0, "18 Oct 12:40");
    
        p.btn2Click(); //печать всех задач

        //p.btn3Click(); //экспорт задач в файл storage.txt

        p.btn4Click(); //импорт задач из файла storage.txt

        p.btn2Click();
    }
}
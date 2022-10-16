package View;

import java.util.ArrayList;

import Model.*;

public class ConsoleView implements View {
    @Override
    public void viewTasks(ArrayList<Task> tasks) {
        for (Task task : tasks) {
            System.out.println(task);
        }
    }
}

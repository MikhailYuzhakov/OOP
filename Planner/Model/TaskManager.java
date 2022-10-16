package Model;

import java.util.ArrayList;

public class TaskManager {
    ArrayList<Task> tasks;
    String name;
    Long id;
    
    enum Priority {
        LOW,
        MIDDLE,
        HIGH
    }

    public TaskManager(String name, Integer id) {
        this.id = Long.valueOf(id);
        this.name = name;
        tasks = new ArrayList<>();
    }

    public void addTask(String content, Long authorId, Long priority, String deadline) {
        this.tasks.add(new TaskType1(content, priority, id++, authorId, deadline));
    }

    public ArrayList<Task> getTaskList() {
        return this.tasks;
    }
}

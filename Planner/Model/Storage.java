package Model;

import java.io.File;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Storage {
    String name = "storage.txt";
    String content = "";
    private File file;
    JSONObject json;

    public Storage() throws IOException {
        file = new File(this.name);
        json = new JSONObject();
        file.createNewFile();
    }

    public void Import(TaskManager tm) throws IOException, ParseException {
        Scanner scan = new Scanner(file);
        while (scan.hasNextLine()) {
            content += scan.nextLine();
        }
        scan.close();
        tm.tasks = deserializeFromJson(content);
    }

    public void Export(TaskManager tm) throws IOException {
        FileWriter fw = new FileWriter(this.name);
        content = serializeToJsonString(tm.tasks);
        fw.write(content);
        fw.close();
    }
    
    private String serializeToJsonString(ArrayList<Task> tasks) {
        JSONObject forListTask = new JSONObject();
        JSONObject forTask;

        for (Task task : tasks) {
            forTask = new JSONObject();
            forTask.put("datetime", task.datetime);
            forTask.put("deadline", task.deadline);
            forTask.put("content", task.content);
            forTask.put("author_id", task.author.id);
            forTask.put("priority", task.priority);
            forListTask.put(task.id, forTask);
        }
        return forListTask.toString();
    }

    private ArrayList<Task> deserializeFromJson(String content) throws ParseException {
        ArrayList<Task> tasks = new ArrayList<>();
        JSONParser parser = new JSONParser();
        JSONObject taskBoard = (JSONObject) parser.parse(content);
        JSONObject task = new JSONObject();
        
        Integer i = 1;
        while (task != null) {
            task = (JSONObject) taskBoard.get(String.format("%d", i));
            i++;
            if (task != null) {
                String text = (String) task.get("content");
                Long priority = (Long)task.get("priority");
                Long authorId = (Long)task.get("author_id");
                String deadline = (String)task.get("deadline");
                Task myTask = new TaskType1(text, priority, Long.valueOf(i), authorId, deadline);
                tasks.add(myTask);
            }
        }
        return tasks;
    }
    
}

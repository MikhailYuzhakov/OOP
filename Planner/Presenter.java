import java.io.IOException;

import org.json.simple.parser.ParseException;

import Model.*;
import View.*;

public class Presenter {
    View v;
    TaskManager tm;
    Storage s;

    public Presenter(View v, TaskManager tm, Storage s) {
        this.v = v;
        this.tm = tm;
        this.s = s;
    }
    
    /**
     * Add task
     */
    public void btn1Click(String content, Long authorId, Long priority, String deadline) {
        tm.addTask(content, authorId, priority, deadline);
    }

    /**
     * View task list
     */
    public void btn2Click() {
        v.viewTasks(tm.getTaskList());
    }

    /**
     * Export to json string
     * @throws IOException
     */
    public void btn3Click() throws IOException {
        s.Export(tm);
    }

    /**
     * Import from json string
     * @throws IOException
     * @throws ParseException
     */
    public void btn4Click() throws IOException, ParseException {
        s.Import(tm);
    }
}

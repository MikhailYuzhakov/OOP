package Model;

import java.util.Date;

public abstract class Task {
    Long id;
    String datetime;
    String deadline;
    String content;
    Author author;
    Long priority;
    private Date date;

    protected Task(String content, Long priority, Long id, Long authorId, String deadline) {
        this.id = id;
        this.content = content;
        this.priority = priority;
        date = new Date();
        this.datetime = getDatetime();
        setDeadline(deadline);
        //this.author.id = authorId;
    }

    private String getDatetime() {
        StringBuilder sb = new StringBuilder();
        String Mon = date.toString().split(" ")[1];
        String Day = date.toString().split(" ")[2];
        String Time = date.toString().split(" ")[3];
        return sb.append(Day).append(" ").append(Mon).append(" ").append(Time).toString();
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String getTask() {
        StringBuilder sb = new StringBuilder();
        sb.append("ID=" + this.id + "; ").append(this.datetime+"; ").append("Priority=" + this.priority + " ").append(author.name)
            .append("\n").append(this.content);
        return sb.toString();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ID=" + this.id + "; ").append("date=" + this.datetime+"; ").append("deadline=" + this.deadline + "; ")
        .append("Priority=" + this.priority + "; ");
        return sb.toString();
    }
}

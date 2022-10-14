package Model.Other;

import java.util.ArrayList;

import Model.Users.User;

public class Message {
    // Calendar date = new GregorianCalendar();
    private Integer id;
    public String datetime;
    public User sender;
    private String content;
    private Boolean isRead;
    public ArrayList<String> comments;

    public Message(String datetime, User sender, String content) {
        this.content = content;
        this.datetime = datetime;
        this.sender = sender;
    }

    public Integer gitId() {
        return this.id;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String readComments() {
        StringBuilder sb = new StringBuilder();
        for (String c : comments) {
            sb.append(c).append("\n");
        }
        return sb.toString();
    }

    @Override
    public String toString() {

        return String.format("%s (%s) %s", sender, datetime, content);
    }
}

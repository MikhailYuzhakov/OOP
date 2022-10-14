package Model.Chats;

import java.util.ArrayList;

import Model.Other.Message;
import Model.Users.User;

public class Chat {
    protected Integer id;
    private String name;
    public ArrayList<User> users;
    public ArrayList<Message> historyMsg;

    public Chat(String name) {
        this.name = name;
        users = new ArrayList<>();
        historyMsg = new ArrayList<>();
    }

    public String getUserList() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name).append(":\n");
        for (User user : users) {
            sb.append(user).append("\n");
        }
        return sb.toString();
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void removeUser(User user) {
        users.remove(user);
    }

    public void view() {
        for (int i = 0; i < historyMsg.size(); i++) {
            System.out.println(historyMsg.get(i));
        }
    }

    public void getCount() {

    }

    public Integer getId() {
        return this.id;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name).append(" ");
        for (User user : users) {
            sb.append(user).append("\n");
        }
        return sb.toString();
    }
}

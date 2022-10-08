import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Chat {
    private String name;
    protected ArrayList<User> users;
    protected ArrayList<Message> historyMsg;

    public Chat(String name) {
        this.name = name;
        users = new ArrayList<>();
        historyMsg = new ArrayList<>();
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

}

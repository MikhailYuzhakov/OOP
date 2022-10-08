import java.util.ArrayList;

public abstract class User {
    protected String name;
    protected Integer age;
    protected ArrayList<Chat> chats;
    protected ArrayList<Message> unread;
    
    protected User(String name, Integer age) {
        this.name = name;
        this.age = age;
    };

    protected String viewUnread() {
        StringBuilder sb = new StringBuilder();
        for (Message msg : unread) {
            sb.append(msg).append("\n");
        }
        return sb.toString();      
    }

    protected void createChat() {
        Chat c1 = new Chat("Chat1");
        c1.users.add(this);
    }

    public void addMsg(Chat chat, Message msg, User user) {
        if (user != this) {
            chat.historyMsg.add(msg);
            user.unread.add(msg);
        }
    }

    protected void rmvSelfMsg() {

    }  
    
    @Override
    public String toString() {
        return this.name;
    }
}

class stndUser extends User {
    public stndUser(String name, Integer age) {
        super(name, age);
    }
}


package Model.Users;

import java.sql.Time;
import java.time.DateTimeException;
import java.util.ArrayList;
import java.util.Date;

import Model.Chats.Chat;
import Model.Other.Message;

public class User {
    protected Integer id;
    protected String name;
    protected Integer age;
    protected ArrayList<Chat> chats;
    protected ArrayList<Integer> unread;

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
        unread = new ArrayList<>();
        chats = new ArrayList<>();
    };

    public Integer getId() {
        return this.id;
    }

    public String viewUnread(Chat chat) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < unread.size(); i++) {
            sb.append(chat.historyMsg.get(i)).append("\n");
        }
        unread.clear();
        return sb.toString();
    }

    protected void createChat() {
        Chat c1 = new Chat("Chat1");
        c1.users.add(this);
    }

    public void addUser(Chat chat, User user) {
        if (!chat.users.contains(this)) chat.users.add(this);
        if (user != null && user != this)
            chat.users.add(user);
    }

    public void addMsg(Chat chat, String content) {
        Date date = new Date();
        String datetime = date.toString();
        Message msg = new Message(datetime, this, content);
        
        if (chat.users.contains(this)) { //если пользователь действительно состоит в этом чате
            chat.historyMsg.add(msg);
            for (User user : chat.users) {
                if (user != this) 
                    user.unread.add(chat.historyMsg.indexOf(msg)); //всем пользователям в чате добавляем непрочитанное сообщение
            }
        }
    }

    public void rmvMsg(Chat chat, Message msg) {
        if (chat.historyMsg.contains(msg) && msg.sender == this) {
            chat.historyMsg.remove(msg);
        }
    }

    public void addComment(String comment, Chat chat, Message msg) {
        if (chat.historyMsg.contains(msg)) {
            msg.comments.add(comment);
        }
    }

    @Override
    public String toString() {
        return this.name;
    }
}

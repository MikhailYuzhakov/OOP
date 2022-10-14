package Model.Users;

import Model.Chats.Chat;
import Model.Other.*;

public class Admin extends User{

    public Admin(String name, Integer age) {
        super(name, age);
    }

    @Override
    public void rmvMsg(Chat chat, Message msg) {
        if (chat.historyMsg.contains(msg)) {
            chat.historyMsg.remove(msg);
        }
    }

    public void rmvUser(Chat chat, User user) {
        if (user != this) {
            chat.users.remove(user);
        }
    }
}
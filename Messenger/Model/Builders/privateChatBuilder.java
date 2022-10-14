package Model.Builders;

import java.util.ArrayList;

import Model.Chats.Chat;
import Model.Other.*;
import Model.Users.User;

public class privateChatBuilder implements ChatBuilder {
    private Integer id;
    private String name;
    private Boolean read;
    private Boolean write;
    private Boolean comment;
    private ArrayList<User> users;
    protected ArrayList<Integer> chatHistory;
    private Repository repo;

    public privateChatBuilder() {
        super();
        users = new ArrayList<>();
        chatHistory = new ArrayList<>();
    }

    @Override
    public ChatBuilder setId() {
        // this.id = repo.getId();
        return this;
    }

    @Override
    public ChatBuilder setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public ChatBuilder accessMode(Boolean read, Boolean write, Boolean comment) {
        this.read = read;
        this.write = write;
        this.comment = comment;
        return this;
    }

    @Override
    public Chat createChat() {
        Chat chat = new Chat(this.name);
        return chat;
    }
}

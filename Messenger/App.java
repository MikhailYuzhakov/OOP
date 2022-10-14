import Model.Builders.*;
import Model.Chats.Chat;
import Model.Users.Admin;
import Model.Users.User;

public class App {

    public static void main(String[] args) {
        ChatBuilder builder = new privateChatBuilder();
        User user1 = new User("Name_1", 13);
        User user2 = new User("Name_2", 14);
        Admin adm1 = new Admin("Admin_1", 23);

        Chat privateChat = builder.setName("MyChat_1").accessMode(true, true, false).createChat();
        System.out.println(privateChat);
        user1.addUser(privateChat, user2);

        System.out.println(privateChat.getUserList());

        user1.addMsg(privateChat, "Hello user2!");
        user2.addMsg(privateChat, "Hello user1!");
        user1.addMsg(privateChat, "How are you user2!");
        user2.addMsg(privateChat, "I'am fine, and you?");
        user1.addMsg(privateChat, "Me too");

        privateChat.view();

        //System.out.println(user1.viewUnread(privateChat));
        //System.out.println(user2.viewUnread(privateChat));
        

        // Chat c1 = new Chat("chat");
        // stndUser user1 = new stndUser("Ivan", 23);
        // stndUser user2 = new stndUser("Vasya", 18);

        // Message msg = new Message(10, 23, user1, "hello");
        // Message msg1 = new Message(10, 24, user1, "hello1");
        // Message msg2 = new Message(10, 25, user1, "hello2");
        // Message msg3 = new Message(10, 27, user2, "hello from user2");

        // user1.addMsg(c1, msg, user2);
        // user1.addMsg(c1, msg1, user2);
        // user1.addMsg(c1, msg2, user2);

        // user2.addMsg(c1, msg3, user1);

        // System.out.print("------chat-------");
        // c1.view();

        // System.out.print("------unread-------");
        // System.out.println(user2.viewUnread());
    }
}
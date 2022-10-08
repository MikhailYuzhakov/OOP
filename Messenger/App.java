/**
 * App
 */
public class App {

    public static void main(String[] args) {
        Chat c1 = new Chat("chat");
        stndUser user1 = new stndUser("Ivan", 23);
        stndUser user2 = new stndUser("Vasya", 18);

        Message msg = new Message(10, 23, user1, "hello");
        Message msg1 = new Message(10, 24, user1, "hello1");
        Message msg2 = new Message(10, 25, user1, "hello2");
        Message msg3 = new Message(10, 27, user2, "hello from user2");

        user1.addMsg(c1, msg, user2);
        user1.addMsg(c1, msg1, user2);
        user1.addMsg(c1, msg2, user2);

        user2.addMsg(c1, msg3, user1);

        System.out.print("------chat-------");
        c1.view();

        System.out.print("------unread-------");
        System.out.println(user2.viewUnread());
    }
}
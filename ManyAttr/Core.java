package ManyAttr;

public class Core {
    public static void main(String[] args) {
        MegaClass mg = new MegaClass("qwe", 12, 2.3);
        mg.viewArgs();

        MegaClass mg1 = new MegaClass("qwe", "ff");
        mg1.viewArgs();
    }
}

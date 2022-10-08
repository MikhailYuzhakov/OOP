/**
 * Core
 */
public class Core {

    public static void main(String[] args) {
        Frame f = new Frame("FirstFrame");
        f.setBounds(0, 0, 200, 170);

        Button btn1 = new Button("Btn 1");
        Button btn2 = new Button("Btn 1");
        Label lbl1 = new Label("Lbl 1");

        btn1.addActionListener(new BtnClick());
        btn2.addActionListener(new BtnClick2());
        lbl1.addActionListener(new LblClick());
        lbl1.addActionListener(new LblRightClick());
        // System.out.println(lbl1.viewActions());
        // System.out.println(btn1.viewActions());
        

        f.addComponent(btn1);
        f.addComponent(btn2);
        f.addComponent(lbl1);

        btn1.click();
        btn2.click();
        btn1.click();
        btn1.click();
        lbl1.click();
        lbl1.rightClick();
    }
}
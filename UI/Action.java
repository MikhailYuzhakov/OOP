interface Action {
    void actionPerformed();
}

interface ButtonClickAction extends Action {
}

interface LableClickAction extends Action {
}

class LblClick implements LableClickAction {
    @Override
    public void actionPerformed() {
        String msg = "lbl1 is clicked";
        System.out.println(msg);
    }
}

class LblRightClick implements LableClickAction {
    @Override
    public void actionPerformed() {
        String msg = "Text from label";
        System.out.println(msg);
    }
}

class BtnClick implements ButtonClickAction {

    @Override
    public void actionPerformed() {
        String msg = "btn1 is clicked";
        System.out.println(msg);
    } 
}

class BtnClick2 implements ButtonClickAction {

    @Override
    public void actionPerformed() {
        String msg = "btn2 is clicked";
        System.out.println(msg);
    } 
}
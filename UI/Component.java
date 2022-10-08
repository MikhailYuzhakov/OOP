import java.util.ArrayList;

abstract class Component {
    String text;

    protected int width;
    protected int height;
    protected int top;
    protected int left;
    protected ArrayList<Action> actions;

    public Component(String text) {
        this.text = text;
        actions = new ArrayList<>();
    }

    public void setBounds(int top, int left, int width, int height) {
        this.top = top;
        this.left = left;
        this.width = width;
        this.height = height;
    }

    public void addActionListener(Action action) {
        actions.add(action);
    }

    /**
     * View all component actions
     * @return
     */
    public String viewActions() {
        StringBuilder sb = new StringBuilder();
        for (Action action : this.actions) {
            sb.append(action).append("\n"); 
        }
        return sb.toString();
    }

    public void click() {
    }

    public void rightClick() {
    }
}

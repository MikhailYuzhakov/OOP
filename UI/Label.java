public class Label extends Component {
    public Label(String name) {
        super(name);
    }

    @Override
    public void click() {
        for (Action action : actions) {
            if (action instanceof LableClickAction) {
              action.actionPerformed();
            }
        }
    }

    @Override
    public void rightClick() {
        for (Action action : actions) {
            if (action instanceof LableClickAction) {
              action.actionPerformed();
            }
        }
    }
}

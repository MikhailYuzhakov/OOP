public class Button extends Component {
    public Button(String text) {
        super(text);
    }

    @Override
    public void click() {
        for (Action action : actions) {
            if (action instanceof ButtonClickAction) {
              action.actionPerformed();
            }
          }
    }

}

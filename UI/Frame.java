import java.util.ArrayList;

public class Frame extends Component {
    private ArrayList<Component> components;

    public Frame(String text) {
        super(text);
        components = new ArrayList<Component>();
    }

    public void addComponent(Component c) {
        if (c == this)
          new Exception();
        components.add(c);
    }
}

import java.io.IOException;

import Model.newModel;
import UI.ConsoleView;

public class App {
    public static void main(String[] args) throws IOException {
        Presenter p = new Presenter(new newModel(), new ConsoleView());
        p.button1Click();
        p.button2Click();
        p.button3Click();
    }
}

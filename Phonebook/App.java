import java.io.IOException;
import java.text.ParseException;

import Model.newModel;
import UI.ConsoleView;

public class App {
    public static void main(String[] args) throws IOException, ParseException {
        Presenter p = new Presenter(new newModel("json"), new ConsoleView());

        //p.fillButton();
        //p.exportButton();
        //p.importButton();
        //p.menuButton();
        //p.printButton();
    }
}

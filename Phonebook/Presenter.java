import java.io.IOException;

import Model.*;
import UI.*;

public class Presenter {
    Model m;
    View v;

    public Presenter(Model m, View v) throws IOException {
        this.m = new newModel();
        this.v = new ConsoleView();
    }

    public void button1Click() {
        m.fillPhonebook(v.getData());
    }

    public void button2Click() {
        v.printPhonebook(m.getPhonebook());
    }

    /**
     * Export data
     * @throws IOException
     */
    public void button3Click() throws IOException {
        m.myExport();
    }
}
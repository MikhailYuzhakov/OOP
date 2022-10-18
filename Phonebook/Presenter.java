import java.io.IOException;
import java.text.ParseException;

import Model.*;
import UI.*;

public class Presenter {
    Model m;
    View v;
    
    public Presenter(Model m, View v) throws IOException {
        this.m = new newModel();
        this.v = new ConsoleView();
        
    }

    /**
     * Fill phonebook
     */
    public void button1Click() {
        m.fillPhonebook(v.getData());
    }

    /**
     * View phonebook
     */
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

    /**
     * Import data
     * @throws IOException
     * @throws ParseException
     */
    public void button4Click() throws IOException, ParseException {
        m.myImport();
    }

    /**
     * View menu and contact
     */
    public void button5Click() {
        Boolean isCmd = true;
        Integer pointer = 0;
        while (isCmd) {
            switch (v.menu()) {
                case "1":
                    if (pointer == m.getcontactList().size()) pointer = 0;
                    v.nextContact(m.getcontactList(), pointer++);
                break;
                case "2":
                    if (pointer < 0) pointer = m.getcontactList().size() - 1;
                    v.prevContact(m.getcontactList(), pointer--);
                break;
                default:
                    isCmd = false;
                break;
            }
        }
    }
}
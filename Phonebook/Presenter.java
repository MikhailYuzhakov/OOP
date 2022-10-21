import java.io.IOException;
import java.text.ParseException;

import Model.*;
import UI.*;

public class Presenter {
    Model m;
    View v;
    
    public Presenter(Model m, View v) throws IOException {
        this.m = new newModel("csv"); //or csv or json
        this.v = new ConsoleView();
        
    }

    /**
     * Fill phonebook
     */
    public void fillButton() {
        m.fillPhonebook(v.getData());
    }

    /**
     * View phonebook
     */
    public void printButton() {
        v.printPhonebook(m.getPhonebook());
    }

    /**
     * Export data
     * @throws IOException
     */
    public void exportButton() throws IOException {
        m.myExport();
    }

    /**
     * Import data
     * @throws IOException
     * @throws ParseException
     */
    public void importButton() throws IOException, ParseException {
        m.myImport();
    }

    /**
     * View menu and contact
     */
    public void menuButton() {
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
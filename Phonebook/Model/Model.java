package Model;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

public interface Model {
    public Phonebook fillPhonebook(String data);
    public String getPhonebook();
    public ArrayList<Contact> getcontactList();
    public void myImport() throws IOException, ParseException;
    public void myExport() throws IOException;
}

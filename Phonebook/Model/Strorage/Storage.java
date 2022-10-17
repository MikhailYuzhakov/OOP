package Model.Strorage;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import Model.Contact;
import Model.Phonebook;

public interface Storage {
    public void myExport(Phonebook pb) throws IOException;
    public void myImport(Phonebook pb) throws IOException, ParseException;
    public String serialize(ArrayList<Contact> contacts);
    public ArrayList<Contact> deserialize(String content) throws ParseException;
}
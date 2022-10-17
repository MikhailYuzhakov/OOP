package Model.Strorage;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import Model.Contact;
import Model.Phonebook;

public class Csv implements Storage {

    @Override
    public void myExport(Phonebook pb) throws IOException {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void myImport(Phonebook pb) throws IOException, ParseException {
        // TODO Auto-generated method stub
        
    }

    @Override
    public String serialize(ArrayList<Contact> contacts) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ArrayList<Contact> deserialize(String content) throws ParseException {
        // TODO Auto-generated method stub
        return null;
    }

}

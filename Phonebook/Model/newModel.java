package Model;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import Model.Strorage.*;

public class newModel implements Model {
    Phonebook pb1;
    Storage st;
    
    public newModel(String format) throws IOException {
        pb1 = new Phonebook(223);
        switch (format) {
            case "json":
                st = new Json();
                break;
            case "csv":
                st = new Csv();
                break;
            default:
                st = new Json();
                break;
        }
    }

    @Override
    public Phonebook fillPhonebook(String data) {
        
        ContactBuilder builder = new ContactBuilder();
        pb1.contacts.add(builder.setId(1).setName("Fedor").setPhoneNumber("88005553535").createContact());
        pb1.contacts.add(builder.setId(2).setName("Mike").setPhoneNumber("88005523535").createContact());
        pb1.contacts.add(builder.setId(3).setName("Nik").setPhoneNumber("88005551535").createContact());
        pb1.contacts.add(builder.setId(4).setName("Andrew").setPhoneNumber("88035553535").createContact());
        return pb1;
    }

    @Override
    public String getPhonebook() {
        return pb1.viewAll();   
    }

    @Override
    public void myExport() throws IOException {
        st.myExport(pb1);
    }

    @Override
    public void myImport() throws IOException, ParseException {
        st.myImport(pb1);
    }

    @Override
    public ArrayList<Contact> getcontactList() {
        return pb1.contacts;
    }
    
}

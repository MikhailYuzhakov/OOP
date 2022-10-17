package Model.Strorage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import Model.Contact;
import Model.ContactBuilder;
import Model.Phonebook;

public class Json implements Storage {
    private String name = "pb.json";
    private File file;
    private JSONObject json;
    
    public Json() throws IOException {
        file = new File(this.name);
        json = new JSONObject();
        file.createNewFile(); //создаст файл
    }

    @Override
    public void myExport(Phonebook pb) throws IOException {
        FileWriter fw = new FileWriter(this.name);
        fw.write(serialize(pb.contacts));
        fw.close();
    }

    @Override
    public void myImport(Phonebook pb) throws IOException, ParseException {
        String content = "";
        Scanner scan = new Scanner(file);
        while (scan.hasNextLine()) {
            content += scan.nextLine();
        }
        scan.close();
        pb.contacts = deserialize(content);
    }

    @Override
    public String serialize(ArrayList<Contact> contacts) {
        JSONObject contactsList = new JSONObject();
        /*
        {
            "1":{"name":"Andrew", "phonenumber":"111111"},
            "2":{"name":"Mike", "phonenumber":"111111"},
            "3":{"name":"Andrew", "phonenumber":"111111"}
        }
        */
        for (Contact contact : contacts) {
            contactsList.put("id", contact.getId());
            contactsList.put("name", contact.getName());
            contactsList.put("phonenumber", contact.getPhoneNumber());
        }
        System.out.println(contactsList);
        return contactsList.toString();
    }

    @Override
    public ArrayList<Contact> deserialize(String content) throws ParseException {
        ArrayList<Contact> contacts = new ArrayList<>();
        // ContactBuilder builder = new ContactBuilder();
        // JSONParser parser = new JSONParser();
        // JSONObject contactsList = (JSONObject) parser.parse(content);
        
        // while (contactsList.size() > 0) {
        //     Integer id = (Integer) contactsList.get("id");
        //     String name = (String) contactsList.get("name");
        //     String phonenumber = (String) contactsList.get("phonenumber");
        //     Contact contact = builder.setId(id).setName(name).setPhoneNumber(phonenumber).createContact();
        //     contacts.add(contact);
        // }
        return contacts;
    }
    
}

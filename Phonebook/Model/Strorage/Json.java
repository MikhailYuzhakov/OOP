package Model.Strorage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import java.util.Scanner;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;
import Model.Contact;
import Model.ContactBuilder;
import Model.Phonebook;

public class Json implements Storage {
    private String name = "pb.json";
    private File file;
    
    public Json() throws IOException {
        file = new File(this.name);
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
        JSONObject contactsListJson = new JSONObject();
        JSONObject contactJson;
        /*
        {
            "1":{"name":"Andrew", "phonenumber":"111111"},
            "2":{"name":"Mike", "phonenumber":"111111"},
            "3":{"name":"Andrew", "phonenumber":"111111"}
        }
        */
        for (Contact c : contacts) {
            contactJson = new JSONObject();
            contactJson.put("name", c.getName());
            contactJson.put("phonenumber", c.getPhoneNumber());
            contactsListJson.put(c.getId(), contactJson);
        }
        return contactsListJson.toString();
    }

    @Override
    public ArrayList<Contact> deserialize(String content) {
        ArrayList<Contact> contacts = new ArrayList<>();
        ContactBuilder builder = new ContactBuilder();
        JSONParser parser = new JSONParser();
        JSONObject contactJson = new JSONObject();
        JSONObject contactsListJson;
        // contactsListJson = (JSONObject) parser.parse(content); dont work
        try {
            contactsListJson = (JSONObject) parser.parse(content);
        } catch (org.json.simple.parser.ParseException e) {
            contactsListJson = null;
            e.printStackTrace();
        }

        Integer id = 1;
        while (contactJson != null) {
            contactJson = (JSONObject) contactsListJson.get(String.format("%d", id++));
            if (contactJson != null) {
                String name = (String) contactJson.get("name");
                String phonenumber = (String) contactJson.get("phonenumber");
                Contact contact = builder.setId(id).setName(name).setPhoneNumber(phonenumber).createContact();
                contacts.add(contact);
            }
        }
        return contacts;
    }
}

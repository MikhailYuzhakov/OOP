package Model;

import java.util.ArrayList;

public class Phonebook {
    public Integer id;
    public ArrayList<Contact> contacts;

    public Phonebook(Integer id) {
        contacts = new ArrayList<>();
    }

    public void addContact(Contact c) {
        contacts.add(c);
    }

    public void removeContact(Contact c) {
        contacts.remove(c);
    }

    public String viewAll() {
        StringBuilder sb = new StringBuilder();
        for (Contact contact : contacts) {
            sb.append(contact).append("\n");
        }
        return sb.toString();
    }
}

package UI;

import java.util.ArrayList;

import Model.Contact;

public interface View {
    public String getData();
    public void printPhonebook(String pb);
    public void nextContact(ArrayList<Contact> contacts, Integer ptr);
    public void prevContact(ArrayList<Contact> contacts, Integer ptr);
    public String menu();
}

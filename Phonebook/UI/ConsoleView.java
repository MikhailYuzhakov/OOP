package UI;

import java.util.ArrayList;
import java.util.Scanner;

import Model.Contact;

public class ConsoleView implements View {
    Scanner in;
    
    public ConsoleView() {
       in = new Scanner(System.in);
    }

    @Override
    public String getData() {
        String str = "sfas";
        return str;
    }

    @Override
    public void printPhonebook(String pb) {
        System.out.println(pb);
    }

    @Override
    public String menu() {
        System.out.println("Phonebook\n1 - next, 2 - prev");
        in = new Scanner(System.in);
        String cmd = in.nextLine();
        System.out.println("\033[H\033[J");
        return cmd;
    }

    @Override
    public void nextContact(ArrayList<Contact> contacts, Integer ptr) {
        System.out.println("Contact:" + contacts.get(ptr));
    }

    @Override
    public void prevContact(ArrayList<Contact> contacts, Integer ptr) {
        System.out.println("Contact:" +contacts.get(ptr));
    }
}

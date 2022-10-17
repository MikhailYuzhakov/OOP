package UI;

import java.util.Scanner;

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
}

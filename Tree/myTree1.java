package Tree;

import java.util.ArrayList;
import java.util.Random;

public class myTree1 {

    public static void main(String[] args) {
        //отец h12
        Human h1 = new Human("Adam", "Ivanov");
        //System.out.println(h1.getInfo());
        
        //сын от h1
        Human h12 = new Human("Vasya", "Ivanov");
        //System.out.println(h12.getInfo());

        //сын от h1
        Human h13 = new Human("Misha", "Ivanov");
        //System.out.println(h13.getInfo());
        
        //мама h12
        Human h3 = new Human("Nastya", "Sidorova");
        //System.out.println(h3.getInfo());

        //внук от h1 (сын h12)
        Human h22 = new Human("Petya", "Ivanov");
        //System.out.println(h22.getInfo());

        //родители
        h13.dad = h1;
        h13.mom = h3;
        h12.dad = h1;
        h12.mom = h3;

        h22.dad = h13;


        //дети
        h1.childs.add(h12); h3.childs.add(h12);
        h1.childs.add(h13); h3.childs.add(h13);

        h12.childs.add(h22);

        //Iterr.ViewForward(h22, ""); //от младшего к старшему
        // StringBuilder sb = new StringBuilder();
        // String str = "";
        // Iterr.ViewReverse(h1, sb, str); //от старшего к младшему
        // System.out.println(sb);
    }
}

class Human {
    protected String fn;
    protected String ln;
    protected static int id = 0;
    protected static Random r;

    static {
        Human.id = 0;
        Human.r = new Random();
    }
    /**
     * Класс человек
     * @param fn - имя
     * @param ln - фамилия
     */
    public Human(String fn, String ln) {
        Human.id++;
        this.fn = fn;
        this.ln = ln;
    }

    public Human() {
        this(String.format("RandFN_%d", Human.r.nextInt(0,20)), String.format("RandLN_%d", Human.r.nextInt(0,20)));
    }

    public String getInfo() {
        return String.format("%d: %s %s", Human.id, fn, ln);
    }

    ArrayList<Human> childs = new ArrayList<Human>();
    Human mom;
    Human dad;
}

/**
 * Класс женщин
 */
class Women extends Human {
    private String gender = "female";
    
}

class Iterr {
    static void ViewForward(Human n, String space) {
        if (n != null) {
            System.out.printf("%s%s %s %s\n", space, Human.id, n.fn, n.ln);

            if (n.dad != null) {
                ViewForward(n.dad, space + " ");
            }
            if (n.mom != null) {
                ViewForward(n.mom, space + " ");
            }
        }
    }

    static void ViewReverse(Human n, StringBuilder sb, String str) {
        if (n != null) {
            sb.append(String.format("%sid:%d fn:%s ln:%s\n", str, Human.id, n.fn, n.ln));
            if (!n.childs.isEmpty()) {
                str += ' ';
                for (Human child : n.childs) {
                    ViewReverse(child, sb, str);
                }
            }
        }
    }
}
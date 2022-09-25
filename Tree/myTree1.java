package Tree;

import java.util.ArrayList;

public class myTree1 {

    public static void main(String[] args) {
        //отец h12
        human h1 = new human();
        h1.id = 1;
        h1.fn = "Adam";
        h1.ln = "Ivanov";
        
        //сын от h1
        human h12 = new human();
        h12.id = 2;
        h12.fn = "Vasya";
        h12.ln = "Ivanov";

        //сын от h1
        human h13 = new human();
        h13.id = 5;
        h13.fn = "Misha";
        h13.ln = "Ivanov";
        
        //мама h12
        human h3 = new human();
        h3.id = 3;
        h3.fn = "Nastya";
        h3.ln = "Sidorova";

        //внук от h1 (сын h12)
        human h22 = new human();
        h22.id = 4;
        h22.fn = "Petya";
        h22.ln = "Ivanov";

        //родители
        h13.dad = h1;
        h13.mom = h3;
        h22.dad = h13;
        h13.dad = h1;
        h13.mom = h3;

        //дети
        h1.childs.add(h12); h3.childs.add(h12);
        h1.childs.add(h13); h3.childs.add(h13);

        h12.childs.add(h22);

        //Iterr.View(h22, ""); 
        StringBuilder sb = new StringBuilder();
        String str = "";
        Iterr.ViewReverse(h1, sb, str);
        System.out.println(sb);
    }
}

class human {
    int id;
    String fn;
    String ln;

    ArrayList<human> childs = new ArrayList<human>();
    human mom;
    human dad;
}

class Iterr {
    static void ViewForward(human n, String space) {
        if (n != null) {
            System.out.printf("%s%s %s %s\n", space, n.id, n.fn, n.ln);

            if (n.dad != null) {
                ViewForward(n.dad, space + " ");
            }
            if (n.mom != null) {
                ViewForward(n.mom, space + " ");
            }
        }
    }

    static void ViewReverse(human n, StringBuilder sb, String str) {
        if (n != null) {
            sb.append(String.format("%sid:%d fn:%s ln:%s\n", str, n.id, n.fn, n.ln));
            if (!n.childs.isEmpty()) {
                str += ' ';
                for (human child : n.childs) {
                    ViewReverse(child, sb, str);
                }
            }
        }
    }
}
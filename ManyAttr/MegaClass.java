package ManyAttr;

import java.util.ArrayList;

public class MegaClass {
    ArrayList<Integer> Integ = new ArrayList<>();
    ArrayList<String> Str = new ArrayList<>();
    ArrayList<Double> Doub = new ArrayList<>();

    public MegaClass(Object...params) {
        for (Object o : params) {
            if (o instanceof String) {
                Str.add((String)o);
            }
            if (o instanceof Integer) {
                Integ.add((Integer)o);
            }
            if (o instanceof Double) {
                Doub.add((Double)o);
            }
        }
    }

    public void viewArgs() {
        for (Double double1 : Doub) {
            System.out.println(double1);
        }

        for (Integer integ : Integ) {
            System.out.println(integ);
        }

        for (String str : Str) {
           System.out.println(str);
        }
        //return str;
    }
}

package Coffee;

import java.util.Iterator;

public class Program {
    public static void main(String[] args) {
        Beverage latte = new Coffee();
        latte.addComponent(new Water("Вода"));
        latte.addComponent(new Beans("Зерна"));
        latte.addComponent(new Sugar("Сахар"));

        Iterator<Ingridient> components = latte;

        while (components.hasNext()) {
            System.out.println(components.next());   
        }
    }
}

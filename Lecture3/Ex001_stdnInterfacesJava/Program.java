package Ex001_stdnInterfacesJava;

import java.util.Iterator;

/**
 * Program
 */
public class Program {

    public static void main(String[] args) {
        Worker worker = new Worker("Ivan", "Ivanob", 24, 31500);
        System.out.println(worker.getName());

        Iterator<String> components = worker;

        while (components.hasNext()) {
            System.out.println(components.next());
        }
    }
}
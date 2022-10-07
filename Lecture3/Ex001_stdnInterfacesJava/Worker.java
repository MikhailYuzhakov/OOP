package Ex001_stdnInterfacesJava;

import java.util.Iterator;

public class Worker implements Iterator<String> {
    private String fn;
    private Integer age;
    private String ln;
    private Integer salary;

    public Worker(String fn, String ln, Integer age, Integer salary) {
        this.fn = fn;
        this.ln = ln;
        this.salary = salary;
        this.age = age;
    }

    public String getName() {
        return String.format("%s %s", fn, ln);
    }

    int index = 0;

    @Override
    public boolean hasNext() {
        return index++ < 4;
    }

    @Override
    public String next() {
        switch (index) {
            case 1:
                //return firstName;
                return String.format("firstName: %s", fn);
            case 2:
                //return lastName;
                return String.format("lastName: %s", ln);
            case 3:
                //return age;
                return String.format("age: %d", age);
            default:
                //return salary;
                return String.format("salary: %d", salary);

        }
    }
}

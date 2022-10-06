package Tree;

import java.util.ArrayList;
import java.util.Random;

public class Human {
    protected String fn;
    protected String ln;
    protected static int number;
    private int id;
    protected static Random r;

    ArrayList<Human> childs = new ArrayList<Human>();
    Human mom;
    Human dad;

    enum gender {
        male, 
        female
    }

    static { //удалить (должна быть отдельная компонента)
        Human.number = 0;
    }

    /**
     * Класс человек
     * 
     * @param fn - имя
     * @param ln - фамилия
     */
    public Human(String fn, String ln, Human dad, Human mom) {
        this.id = ++Human.number;
        this.fn = fn;
        this.ln = ln;
        this.mom = mom;
        this.dad = dad;

        if (dad != null) dad.childs.add(this);
        if (mom != null) mom.childs.add(this);
    }

    public int getHumanId() {
        return this.id;
    }

    @Override
    public String toString() {
        return String.format("%d: %s %s", getHumanId(), fn, ln);
    }

}

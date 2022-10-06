package Tree;

import java.util.Stack;

public class GenerationTree {
    private Stack<Human> list = new Stack<Human>();
    private String name;

    /**
     * Конструктор
     */
    public GenerationTree(String name) {
        this.name = name;
        // предки
        Human h1 = new Human("Valerii", "Yuzhakov", null, null);
        list.add(h1);
        Human h2 = new Human("Valentina", "Bulatova", null, null);
        list.add(h2);
        Human h3 = new Human("Yurii", "Russkikh", null, null);
        Human h4 = new Human("Nina", "Russkikh", null, null); 

        // потомки в 1 поколении
        Human h11 = new Human("Sergey", "Yuzhakov", h1, h2);
        Human h12 = new Human("Evgenii", "Yuzhakov", h1, h2);
        Human h51 = new Human("Svetlana", "Yuzhakov", null, null); // жена h12

        Human h31 = new Human("Natalia", "Russkikh", h3, h4);
        Human h32 = new Human("Tatiana", "Russkikh", h3, h4);
        Human h61 = new Human("Evgenii", "Romanenko", null, null); // муж h32

        // потомки во 2 поколении
        Human h111 = new Human("Misha", "Yuzhakov", h11, h31);
        Human h121 = new Human("Artem", "Yuzhakov", h12, h51);
        Human h611 = new Human("Ivan", "Romanenko", h61, h32);
        Human h612 = new Human("Matvey ", "Romanenko", h61, h32);
    }

    public void add(Human h) {
        this.list.add(h);
    }

    @Override
    public String toString() {
        return list.toString();
    }

    protected Human getFirst() {
        Human h = list.peek();
        return h;
    }

    protected String getName() {
        return this.name.toString();
    }
}

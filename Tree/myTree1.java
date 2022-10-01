import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Random;

public class myTree1 {

    public static void main(String[] args) throws Exception {
        // предки
        Human h1 = new Human("Valerii", "Yuzhakov", null, null);
        Human h2 = new Human("Valentina", "Bulatova", null, null);

        Human h3 = new Human("Yurii", "Russkikh", null, null);
        Human h4 = new Human("Nina", "Russkikh", null, null);

        // потомки в 1 поколении
        Human h11 = new Human("Sergey", "Yuzhakov", h1, h2);
        Human h12 = new Human("Evgenii", "Yuzhakov", h1, h2);
        Human h51 = new Human("Svetlana", "Yuzhakov", null, null); // жена h12
        h1.childs.add(h11);
        h2.childs.add(h11);
        h1.childs.add(h12);
        h2.childs.add(h12);

        Human h31 = new Human("Natalia", "Russkikh", h3, h4);
        Human h32 = new Human("Tatiana", "Russkikh", h3, h4);
        Human h61 = new Human("Evgenii", "Romanenko", null, null); // муж h32
        h3.childs.add(h31);
        h3.childs.add(h32);
        h4.childs.add(h31);
        h4.childs.add(h32);

        // потомки во 2 поколении
        Human h111 = new Human("Misha", "Yuzhakov", h11, h31);
        h11.childs.add(h111);
        h31.childs.add(h111);
        Human h121 = new Human("Artem", "Yuzhakov", h12, h51);
        h12.childs.add(h121);
        h51.childs.add(h121);

        Human h611 = new Human("Ivan", "Romanenko", h61, h32);
        h61.childs.add(h611);
        h32.childs.add(h611);
        Human h612 = new Human("Matvey ", "Romanenko", h61, h32);
        h61.childs.add(h612);
        h32.childs.add(h612);

        System.out.println(h1);

        h1.toFileTxt();
        h11.toFileCsv();

        StringBuilder sb = new StringBuilder();
        View.Forward(h111, sb, "", 1, 3); // вывод предков до targetGen
        h1.writeTreeToFile(sb.toString());

        // StringBuilder sb1 = new StringBuilder();
        // View.Reverse(h1, sb1, "", 1, 3); c
        // h1.writeTreeToFile(sb1.toString());

        // Iterr.ViewForward(h22, ""); //от младшего к старшему
        // StringBuilder sb = new StringBuilder();
        // String str = "";
        // Iterr.ViewReverse(h1, sb, str); //от старшего к младшему
        // System.out.println(sb);
    }
}

class Human {
    protected String fn;
    protected String ln;
    protected static int number;
    private int id;
    protected static Random r;

    static {
        Human.number = 0;
        Human.r = new Random();
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
    }

    public int getHumanId() {
        return this.id;
    }

    @Override
    public String toString() {
        return String.format("%d: %s %s", getHumanId(), fn, ln);
    }

    private void toFile(String data, String format) throws Exception {
        FileWriter file = new FileWriter("data" + format, false);

        switch (format) {
            case ".txt":
                file.write(toString() + "\n");
                break;
            case ".csv":
                file.write(toString() + ";");
                break;
            case "tree.txt":
                file.write(data);
                break;
        }
        file.close();
    }

    private void toFile(String format) throws Exception {
        this.toFile("", format);
    }

    public void toFileTxt() throws Exception {
        this.toFile(".txt");
    }

    public void toFileCsv() throws Exception {
        this.toFile(".csv");
    }

    /**
     * Выводит в файл всё дерево различными методами
     * 
     * @param method - метод вывода (от предков к потомкам fr, наоборот rv)
     */
    public void writeTreeToFile(String data) throws Exception {
        this.toFile(data, "tree.txt");
    }

    ArrayList<Human> childs = new ArrayList<Human>();
    Human mom;
    Human dad;
}

class View {
    /*
     * Обход от потомков к предкам
     */
    public static void Forward(Human h, StringBuilder sb, String str, Integer currentGen, Integer targetGen) {
        if (h != null) {
            sb.append(String.format("%sid:%d fn:%s ln:%s\n", str, h.getHumanId(), h.fn, h.ln));
            if (currentGen == targetGen)
                return;
            else
                currentGen++;

            if (h.dad != null) {
                Forward(h.dad, sb, str + " ", currentGen, targetGen);
            }
            if (h.mom != null) {
                Forward(h.mom, sb, str + " ", currentGen, targetGen);
            }
        }
    }

    /*
     * Обход от предков к потомкам
     */
    public static void Reverse(Human h, StringBuilder sb, String str, Integer currentGen, Integer targetGen) {
        if (h != null) {
            sb.append(String.format("%sid:%d fn:%s ln:%s\n", str, h.getHumanId(), h.fn, h.ln));
            if (!h.childs.isEmpty()) {
                str += ' ';
                if (currentGen == targetGen)
                    return;
                else {
                    currentGen++;
                }
                for (Human child : h.childs) {
                    Reverse(child, sb, str, currentGen, targetGen); // прибавить 1 поколение
                }
            }
        }
    }
}
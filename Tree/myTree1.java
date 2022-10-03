package Tree;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Random;

//когда пишем методы - нужно писать методы для проверки методов (unit tests)
public class myTree1 {

    public static void main(String[] args) throws Exception {
        
        //здесь две-три инструкции, дерево создает отдельный метод класса (не класса Human)
        GenerationTree myTree = new GenerationTree();


        // System.out.println(h1);

        // h1.toFileTxt();
        // h11.toFileCsv();

        // StringBuilder sb = new StringBuilder();
        // View v = new View();
        // v.Forward(h111, sb, "", 1, 3); // вывод предков до targetGen
        // h1.writeTreeToFile(sb.toString());

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

    ArrayList<Human> childs = new ArrayList<Human>();
    Human mom;
    Human dad;

    static { //удалить (должна быть отдельная компонента)
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

    //отдельная сущность, отдельный класс
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
}

class ParametersHuman {
//описать задание id
}

class GenerationTree {
    /**
     * Конструктор
     */
    public GenerationTree() {
        // предки
        Human h1 = new Human("Valerii", "Yuzhakov", null, null);
        Human h2 = new Human("Valentina", "Bulatova", null, null);  
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

    public void printTree (Human h, boolean direction)
    {
        
    }

    
}

class View {
    /*
     * Обход от потомков к предкам
     */
    public void Forward(Human h, StringBuilder sb, String str, Integer currentGen, Integer targetGen) {
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
    public void Reverse(Human h, StringBuilder sb, String str, Integer currentGen, Integer targetGen) {
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
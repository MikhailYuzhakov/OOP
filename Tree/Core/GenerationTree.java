package Core;
import java.util.ArrayList;

public class GenerationTree {
    private ArrayList<Human> humans = new ArrayList<Human>();
    private String name;
    private IDCreator idCreator;
    private HumanBuilder hBuilder;
    /**
     * Конструктор
     */
    public GenerationTree(String name) {
        this.name = name;
        humans = new ArrayList<>();
        idCreator = new IDCreator();
        hBuilder = new HumanBuilder();
    }

    /**
     * Добавляет узел в дерево (экзепляр класса Human)
     * @param firstName
     * @param lastName
     * @param patronymic
     * @param sex
     */
    public void addNode(String firstName, String lastName, String patronymic, String sex) {
        //ошибки связанные с полями метода обработаются внутри сметода createHuman()
        Human human = hBuilder.setFirstName(firstName).setLastName(lastName).setPatronymic(patronymic).setSex(sex)
                                .setID(idCreator.getId()).createHuman();
        humans.add(Integer.parseInt(human.getID()), human);
    }
    /**
     * Добавляет узел в дерево (экзепляр класса Human) с родителями
     * @param firstName
     * @param lastName
     * @param patronymic
     * @param sex
     * @param dad
     * @param mom
     */
    public void addNode(String firstName, String lastName, String patronymic, String sex, Human dad, Human mom) {
        //ошибки связанные с полями метода обработаются внутри сметода createHuman()
        Human human = hBuilder.setFirstName(firstName).setLastName(lastName).setPatronymic(patronymic).setSex(sex)
                                .setID(idCreator.getId()).setDad(dad).setMom(mom).createHuman();
        humans.add(Integer.parseInt(human.getID()), human);
    }

    public Human getNodeByID(Integer id) {
        return humans.get(id);
    }

    public Human getNodeByFullName(String fn, String ln) {
        for (Human human : humans) {
            if (human.getFirstName() == fn && human.getLastName() == ln) {
                return human;
            }
        }
        throw new NullPointerException("Человек не найден.");
    }

    @Override
    public String toString() {
        return humans.toString();
    }

    // protected Human getFirst() {
    //     Human h = humans.peek();
    //     return h;
    // }

    public String getName() {
        return this.name.toString();
    }
}

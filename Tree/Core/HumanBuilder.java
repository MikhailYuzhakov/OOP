package Core;
public class HumanBuilder {
    private String firstName;
    private String lastName;
    private String patronymic;
    private String sex;
    private Integer id;
    private Human mom;
    private Human dad;

    public HumanBuilder() {
        super();
    }

    public HumanBuilder setFirstName(String fn) {
        this.firstName = fn;
        return this;
    }

    public HumanBuilder setLastName(String ln) {
        this.lastName = ln;
        return this;
    }

    public HumanBuilder setPatronymic(String pt) {
        this.patronymic = pt;
        return this;
    }

    public HumanBuilder setSex(String sex) {
        this.sex = sex;
        return this;
    }
    
    public HumanBuilder setDad(Human dad) {
        this.dad = dad;
        return this;
    }

    public HumanBuilder setMom(Human mom) {
        this.mom = mom;
        return this;
    }

    public HumanBuilder setID(Integer id) {
        this.id = id;
        return this;
    }

    public Human createHuman() {
        Human human = new Human(firstName, lastName, patronymic, sex, dad, mom, id);
        if (human.doQualityCheck()) {
            return human;
        } else {
            return null;
        }
    }
}

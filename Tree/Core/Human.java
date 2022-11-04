package Core;
import java.util.ArrayList;

public class Human {
    private ArrayList<String> personal;
    private ArrayList<Human> childs;
    private Human mom;
    private Human dad;

    /**
     * Класс человек
     * 
     * @param fn - имя
     * @param ln - фамилия
     */
    public Human(String firstName, String lastName, String patronymic, String sex, Human dad, Human mom, Integer id) {
        personal = new ArrayList<String>();
        childs = new ArrayList<Human>();
        personal.add(id.toString());
        personal.add(firstName);
        personal.add(lastName);
        personal.add(patronymic);
        personal.add(sex);
        
        //автоматически добавляем детей
        if (dad != null) dad.addChild(this);
        if (mom != null) mom.addChild(this);
    }

    private String getAttribute(Integer index) {
        try {
            return personal.get(index);
        } catch (NullPointerException e) {
            throw new NullPointerException("Запрашиваемго аттрибута не существует");
        }
    }

    public String getID() {
        return getAttribute(0);
    }

    public String getFirstName() {
        return getAttribute(1);
    }

    public String getLastName() {
        return getAttribute(2);
    }

    public String getPatronymic() {
        return getAttribute(3);
    }

    public String getSex() {
        return getAttribute(4);
    }

    public Human getMom() {
        return this.mom;
    }

    public Human getDad() {
        return this.dad;
    }

    public ArrayList<Human> getChilds() {
        return this.childs;
    }

    public Boolean addChild(Human child) {
        if (child != null) {
            this.childs.add(child);
            return true; 
        } else {
            return false;
        } 
    }

    /**
     * Проверка наличия всех полей класса Human
     * @return
     */
    public Boolean doQualityCheck() {
        switch (personal.indexOf(null)) {
            case 0:
                throw new NullPointerException("Отсутствует ID");
            case 1:
                throw new NullPointerException("Отсутствует имя");
            case 2:
                throw new NullPointerException("Отсутствует фамилия");
            case 3:
                throw new NullPointerException("Отсутствует отчество");
            case 4:
                throw new NullPointerException("Отсутствует пол");
            default:
                return true;
        }
    }

    @Override
    public String toString() {
        return personal.toString();
    }
}

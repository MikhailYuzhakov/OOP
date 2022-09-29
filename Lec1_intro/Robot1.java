package Lec1_intro;

import java.util.ArrayList;

/**
 * 1 принцип ООП ИНКАПСУЛЯЦИЯ - свойство системы, позволяющее обхединять данные и методы,
 * работающие с ними в классе, скрыв детали реализации и защитив от пользователя этого класса объектов.
 * (объединение данных и логики + сокрытие реализации)
 * */
public class Robot1 {
    /**Уровень робота */
    public int level;

    /**Имя робота */
    public String name;

    /**
     * Создание робота
     * @param name Имя робота !Не должно начинаться с цифры
     * @param level Уровень робота
     */
    // public Robot1(String name, int level)
    // {
    //     this.name = name;
    //     this.level = level;
    // }

    enum State {
        On, Off
    }

    private static int defaultIndex;
    private static ArrayList<String> names;
    State state;

    static { //статическое поле для класса
        defaultIndex = 1;
        names = new ArrayList<String>();
    }
    /**
     * Базовый конструктор класса
     * @param name
     * @param level
     */
    public Robot1(String name, int level) { //конструктор класса
        if ((name.isEmpty()
            || Character.isDigit(name.charAt(0)))
            || Robot1.names.indexOf(name) != -1) {
                this.name = String.format("DefaultName+%d", defaultIndex++);
            } else {
                this.name = name;
            }
        
            Robot1.names.add(this.name);
            this.level = level;
            this.state = State.Off;
    }

    public Robot1() { //перегрузка конструктора
        this("NoName", 1);
    }

    //методы вкл/выкл подсистем

    /**Загрузка BIOS */
    private void startBIOS() { System.out.println("Start BIOS...");} //скрыли
    
    /**Загрузка OS */
    private void startOS() { System.out.println("Start OS...");}

    /**Приветствие */
    private void sayHi() { System.out.println("Hello world...");}

    /**Остановка BIOS */
    private void stopBIOS() { System.out.println("Stop BIOS...");}

    /**Остановка OS */
    private void stopOS() { System.out.println("Stop OS...");}

    /**Прощание */
    private void sayBye() { System.out.println("Bye...");}

    /**Работа */
    public void work() { 
        if (state == State.On) System.out.println("Working...");
        else System.out.println("System is powered off...");
    }

    public void powerOn() { //пример инкапсуляции - скрываем от пользователя функционал 
        if (state == State.Off) {
            startBIOS();
            startOS();
            sayHi();
            state = State.On;
        }
    }

    public void powerOff() {
        if (state == State.On) {
            sayBye();
            stopOS();
            stopBIOS();
            state = State.Off;
        }
    } 

} 

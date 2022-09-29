package Ex005;

public class Magician extends BaseHero {
    private int mana;
    private int maxMana;

    /**
     * Конструктор для мага
     */
    public Magician() {
        //вызываем конструктор по умолчанию для базового класса
        super(String.format("Hero_Magician #%d", ++Magician.number), Magician.r.nextInt(50,100));
        this.maxMana = Magician.r.nextInt(50,150);
        this.mana = maxMana;
    }

    public String getInfo() { //вызываем метод базового класса
        return String.format("%s Mana: %d", super.getInfo(), this.mana);
    }
}
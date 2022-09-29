package Ex005;

public class Program {
    public static void main(String[] args) {
        Magician hero1 = new Magician();
        System.out.println(hero1.getInfo());
        
        Priest hero2 = new Priest();
        System.out.println(hero2.getInfo());

        Priest hero3 = new Priest();
        System.out.println(hero3.getInfo());

        hero3.Attack(hero1);
        System.out.println(hero3.getInfo());
        System.out.println(hero1.getInfo());
        /**
         * Полиморфизм - свойство системы, использовать объекты с одинаковым интерфейсом без информации о типе и внутренней структуре
         * объекта.
         */
        BaseHero hero4 = new Magician(); //полиморфизм - в базовый класс кладем наследованный экземляр класса
        System.out.println(hero4.getInfo());
    }
}
package Lec1_intro;

import Lec1_intro.Robot1;

public class client_robot {
    public static void main(String[] args) {
        Robot1 robot1 = new Robot1("name_1", 1);
        //Robot1 robot1 = new Robot1();
        System.out.printf("%s %d\n", robot1.name, robot1.level);
        //пользователь может начать тыкать на все кнопки подряд
        //вывод - оставить только необходимы 
        // robot1.startBIOS();
        // robot1.startOS();
        // robot1.sayHi();
        robot1.powerOn();
        
        robot1.work();
        robot1.work();
        robot1.work();

        // robot1.sayBye();
        // robot1.stopOS();
        // robot1.startBIOS();
        robot1.powerOff();
        robot1.work();
    }   
}

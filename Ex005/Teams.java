package Ex005;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Teams {
    public static void main(String[] args) {
        int teamCount = 10;
        Random rand = new Random();
        int magicianCount = rand.nextInt(0, teamCount);
        int priestCount = teamCount - magicianCount;

        System.err.printf("magicianCount = %d, priestCount = %d\n", magicianCount, priestCount);

        // Priest[] priests = new Priest[priestCount];
        // Magician[] magicians = new Magician[magicianCount];
        List<BaseHero> teams = new ArrayList<BaseHero>(); //ввели полиморфизм и можем теперь в базовый класс добавлять 
                                                          //экзепляры наследующих классов

        for (int i = 0; i < teamCount; i++) {
            if (rand.nextBoolean())
            { 
                teams.add(new Magician());
                magicianCount++;
            }
            else {
                teams.add(new Priest());
                priestCount++;
            }
            System.out.println(teams.get(i).getInfo());
        }
    }
}

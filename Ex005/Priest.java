package Ex005;

import java.util.Random;

public class Priest extends BaseHero{

    public Priest() {
        super(String.format("Hero_Priest #%d", ++Priest.number), Priest.r.nextInt(50,100));
        elixir = Priest.r.nextInt(50,150);
        maxElixir = elixir;
    }
    
    private int elixir;
    private int maxElixir;


    public void healed(int Hp) {
        this.elixir = Hp;
        this.elixir -= Hp;
        if (elixir < 0) return;
        this.hp = Hp + this.hp > this.maxHp ? this.maxHp : Hp + this.hp;
        return;
    }

    
    public String getInfo() { //вызываем метод базового класса
        return String.format("%s Elixir: %d", super.getInfo(), this.elixir);
    }

}

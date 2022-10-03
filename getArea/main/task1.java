package getArea.main;

import getArea.fig.Figure;
import getArea.fig.Figure.*;

public class task1 {
    public static void main(String[] args) {
        System.out.println("-----------------Circle-----------------");
        Integer radius = 5;
        Circle c1 = new Circle(radius);
        System.out.println(Math.round(c1.getArea()));
        radius = c1.getRadius();
        c1.setRadius(10);
        System.out.println(Math.round(c1.getArea()));

        System.out.println("-----------------Rectangle-----------------");
        Integer width = 4;
        Integer length = 5;
        Rectangle r1 = new Rectangle(length, width);
        System.out.println(r1.getArea());
        r1.setLength(6);
        r1.setWidth(7);
        System.out.println(r1.getArea());

        System.out.println("-----------------Square-----------------");
        Integer side = 5;
        Square s1 = new Square(side);
        System.out.println(s1.getArea());
        s1.setLength(6);
        System.out.println(s1.getArea());

        System.out.println("-----------------Rhombus-----------------");
        Integer d1 = 3;
        Integer d2 = 4;
        Rhombus ro1 = new Rhombus(d1, d2);
        System.out.println(ro1.getArea());
        ro1.setD1(2);
        ro1.setD2(5);
        System.out.println(ro1.getArea());
    }
}



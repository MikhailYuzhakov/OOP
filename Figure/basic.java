

public class basic {

    public static void main(String[] args) {
        Rectangle r1 = new Rectangle(10, 10);
        System.out.printf("%s = %.1f м2\n", r1.getName(), r1.getArea());
        r1.setLength(3);
        System.out.printf("%s = %.1f м2\n", r1.getName(), r1.getArea());

        Square s1 = new Square(4);
        System.out.printf("%s = %.1f м2\n", s1.getName(), s1.getArea());
        s1.setWidth(12);
        System.out.printf("%s = %.1f м2\n", s1.getName(), s1.getArea());

        Circle c1 = new Circle(2);
        System.out.printf("%s = %.1f м2\n", c1.getName(), c1.getArea());
        c1.setRadius(23);
        System.out.printf("%s = %.1f м2\n", c1.getName(), c1.getArea());
    }
}
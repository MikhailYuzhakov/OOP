abstract class Figure {
    private String name;
    private static Integer id = 0; //для подсчёта всех фигур

    protected Figure(String name) {
        this.name = String.format("%s_%d", name, Figure.id++);
    }

    protected String getName() {
        return this.name;
    }

    protected Integer getId() {
        return Figure.id;
    }

    abstract double getArea();
}

/**
 * Circle
 */
interface CircleMethods {
    abstract void setRadius(Integer radius);
    abstract Integer getRadius();
}

/**
 * RectangleMethods
 */
interface RectangleMethods {
    abstract void setWidth(Integer width);
    abstract void setLength(Integer length);
    abstract Integer getWidth();
    abstract Integer getLength();
}

/**
 * Rectangle
 */
class Rectangle extends Figure implements RectangleMethods {
    private Integer width;
    private Integer length;

    public Rectangle(Integer width, Integer length) {
        super(String.format("Rectangle"));
        this.length = length;
        this.width = width;
    }

    @Override
    public void setWidth(Integer width) {
        this.width = width;
    }

    @Override
    public void setLength(Integer length) {
       this.length = length;
    }

    @Override
    public Integer getLength() {
        return this.length;
    }

    @Override
    public Integer getWidth() {
        return this.width;
    }
    
    @Override
    double getArea() {
        return (double) width*length;
    }

    
}

class Square extends Rectangle {
    public Square(Integer side) {
        super(side, side);
    }    
}

class Circle extends Figure implements CircleMethods {
    private Integer radius;

    public Circle(Integer radius) {
        super(String.format("Circle"));
        this.radius = radius;
    }

    @Override
    double getArea() {
        return Math.PI*Math.pow((double)radius,2);
    }

    @Override
    public Integer getRadius() {
        return this.radius;
    }

    @Override
    public void setRadius(Integer radius) {
        this.radius = radius;
        
    }
}
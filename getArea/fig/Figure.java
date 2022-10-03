package getArea.fig;

class Circle extends Figure {
    public Circle(Integer radius) {
        super(radius, null, null, null, null);
    }

    public void setRadius(Integer rad) {
        super.radius = rad;
    }

    public Integer getRadius() {
        return super.radius;
    }
}

class Rectangle extends Figure {
    public Rectangle(Integer length, Integer width) {
        super(null, length, width, null, null);
    }

    public void setLength(Integer len) {
        super.length = len;
    }

    public void setWidth(Integer wid) {
        super.width = wid;
    }

    public Integer getLength() {
        return super.length;
    }

    public Integer getWidth() {
        return super.width;
    }
}

class Square extends Rectangle {
    public Square(Integer length) {
        super(length, null);
    }
    
    public void setLength(Integer len) {
        super.setLength(len);
        super.setWidth(len);
    }

    public void setWidth(Integer wid) {
        this.setLength(wid);
    }

    public Integer getLength() {
        return super.getLength();
    }

    public Integer getWidth() {
        return this.getLength();
    }
}

class Rhombus extends Figure {
    /**
     * Ромб
     * @param d1 - диагональ 1
     * @param d2 - диагональ 2
     */
    public Rhombus(Integer d1, Integer d2) {
        super(null, null, null, d1, d2);
    }

    public void setD1 (Integer d1) {
        super.d1 = d1;
    }

    public void setD2 (Integer d2) {
        super.d2 = d2;
    }

    public Integer getD1() {
        return super.d1;
    }

    public Integer getD2() {
        return super.d2;
    }
}

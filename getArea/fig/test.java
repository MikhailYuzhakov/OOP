package getArea.fig;

public class test {
    protected Integer radius;
    protected Integer length;
    protected Integer width;
    protected Integer d1;
    protected Integer d2;

    protected test(Integer radius, Integer length, Integer width, Integer d1, Integer d2) {
        this.radius = radius;
        this.length = length;
        this.width = width;
        this.d1 = d1;
        this.d2 = d2;
    }
    
    public double getArea() {
        if (this.radius != null)
            return Math.PI*this.radius*this.radius;
        if (this.length != null && width != null)
            return this.length * this.width;
        if (this.length != null)
            return this.length * this.length;
        if (this.d1 != null && this.d2 != null)
            return 0.5*this.d1 * this.d2;
        return 0.0;
    }
}
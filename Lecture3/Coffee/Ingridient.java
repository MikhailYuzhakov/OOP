package Coffee;

public abstract class Ingridient {
    private String brand;

    public Ingridient(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return this.brand;
    }

}

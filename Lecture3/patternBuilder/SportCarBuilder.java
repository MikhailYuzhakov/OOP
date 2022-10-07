package patternBuilder;
/**
 * Могут быть разные варианты ConcreteBuilder, и каждый из них выполняет сборку по-своему, 
 * чтобы предоставить нам различные представления сложного объекта Car
 */
public class SportCarBuilder implements CarBuilder {
    private String chassis;
    private String body;
    private String paint;
    private String interior;

    public SportCarBuilder() {
        super();
    }

    @Override
    public CarBuilder fixChassis() {
        System.out.println("Assembling chassis of the Sport model");
        this.chassis = "Classic Sport";
        return this;
    }

    @Override
    public CarBuilder fixBody() {
        System.out.println("Assembling body of the Sport model");
        this.chassis = "Classic Sport";
        return this;
    }

    @Override
    public CarBuilder paint() {
        System.out.println("Painting body of the Sport model");
        this.chassis = "Classic Sport";
        return this;
    }

    @Override
    public CarBuilder fixInterior() {
        System.out.println("Assembling Interior of the Sport model");
        this.chassis = "Classic Sport";
        return this;
    }

    //собираем авто целиком и проверяем полноту сборки, возвращаем экземпляр класса Car
    @Override
    public Car build() {
        Car car = new Car(chassis, body, paint, interior);
        if (car.doQualityCheck()) {
            return car;
        } else {
            System.out.println("Car assembly is incomplete. Can't deliver!");
        }
        return null;
    }
    
}

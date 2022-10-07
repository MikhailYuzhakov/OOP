package patternBuilder;
/**
 * Могут быть разные варианты ConcreteBuilder, и каждый из них выполняет сборку по-своему, 
 * чтобы предоставить нам различные представления сложного объекта Car
 */
public class ClassicCarBuilder implements CarBuilder {
    private String chassis;
    private String body;
    private String paint;
    private String interior;

    public ClassicCarBuilder() {
        super();
    }

    @Override
    public CarBuilder fixChassis() {
        System.out.println("Assembling chassis of the classical model");
        this.chassis = "Classic Chassis";
        return this;
    }

    @Override
    public CarBuilder fixBody() {
        System.out.println("Assembling body of the classical model");
        this.chassis = "Classic Body";
        return this;
    }

    @Override
    public CarBuilder paint() {
        System.out.println("Assembling paint of the classical model");
        this.chassis = "Classic Paint";
        return this;
    }

    @Override
    public CarBuilder fixInterior() {
        System.out.println("Assembling Interior of the classical model");
        this.chassis = "Classic Intrerior";
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

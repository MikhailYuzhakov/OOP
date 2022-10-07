package patternBuilder;

public class Core {
    public static void main(String[] args) {
        CarBuilder builder = new SportCarBuilder();
        AutomotiveEngineer engineer = new AutomotiveEngineer(builder);
        Car sportCar = engineer.manufactureCar();
        System.out.println(sportCar);

        if (sportCar != null) {
            System.out.println("Below car delievered: ");
            System.out.println("======================================================================");
            System.out.println(sportCar);
            System.out.println("======================================================================");
        }
    }
}

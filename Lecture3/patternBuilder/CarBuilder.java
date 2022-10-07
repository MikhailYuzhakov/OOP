package patternBuilder;

/**
 * Строитель автомобилей - все этапе сборки авто.
 * Все этапы (кроме build) возвращают экземпляр класса CarBuilder, что позволит
 * вызывать методы последовательно (по цепочке).
 * Метод build возвращет экземпляр класса Car - конечного продукта (только при успешной сборке - если пройдены все этапы).
 */
public interface CarBuilder {
    // Этап 1
    public CarBuilder fixChassis();

    // Этап 2
    public CarBuilder fixBody();

    // Этап 3
    public CarBuilder paint();

    // Этап 4
    public CarBuilder fixInterior();

    // Выпуск автомобиля

    public Car build();
}

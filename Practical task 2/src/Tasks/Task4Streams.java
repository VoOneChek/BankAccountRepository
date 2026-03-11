package Tasks;

import java.util.*;
import java.util.stream.Collectors;

import AdditionalTask.CarType;
import Tasks.Three.Car;

public class Task4Streams {
    static void main() {

        List<Car> cars = List.of(
                new Car("1", "Camry", "Toyota", 2022, 20000, 25000, CarType.SEDAN),
                new Car("2", "X5", "BMW", 2023, 15000, 60000, CarType.SUV),
                new Car("3", "A6", "Audi", 2020, 80000, 30000, CarType.SUV),
                new Car("4", "Model S", "Tesla", 2024, 10000, 90000, CarType.ELECTRIC),
                new Car("5", "Model 3", "Tesla", 2023, 30000, 50000, CarType.ELECTRIC)
        );

        System.out.println("Машины с пробегом < 50000:");

        cars.stream()
                .filter(car -> car.getMileage() < 50000)
                .forEach(System.out::println);

        System.out.println("\nТоп 3 дорогих машины:");

        cars.stream()
                .sorted(Comparator.comparing(Car::getPrice).reversed())
                .limit(3)
                .forEach(System.out::println);

        double avgMileage = cars.stream()
                .mapToInt(Car::getMileage)
                .average()
                .orElse(0);

        System.out.println("\nСредний пробег: " + avgMileage);

        Map<String, List<Car>> grouped = cars.stream()
                .collect(Collectors.groupingBy(Car::getManufacturer));

        System.out.println("\nГруппировка по производителю:");
        System.out.println(grouped);
    }
}

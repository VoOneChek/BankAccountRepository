package AdditionalTask;

import Tasks.Three.Car;

import java.util.*;
import java.util.stream.Collectors;

public class CarDealership {

    private final Set<Car> cars = new HashSet<>();

    public void addCar(Car car) {
        if (cars.add(car)) {
            System.out.println("Машина добавлена");
        } else {
            System.out.println("Дубликат VIN");
        }
    }

    public List<Car> findByManufacturer(String manufacturer) {
        return cars.stream()
                .filter(c -> c.getManufacturer().equalsIgnoreCase(manufacturer))
                .collect(Collectors.toList());
    }

    public List<Car> sortByYear() {
        return cars.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public Optional<Car> oldestCar() {
        return cars.stream()
                .min(Comparator.comparing(Car::getYear));
    }

    public Optional<Car> newestCar() {
        return cars.stream()
                .max(Comparator.comparing(Car::getYear));
    }
}

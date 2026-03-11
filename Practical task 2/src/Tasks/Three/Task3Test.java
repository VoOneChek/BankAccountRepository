package Tasks.Three;

import AdditionalTask.CarType;

import java.util.*;

public class Task3Test {
    static void main() {

        Set<Car> cars = new HashSet<>();

        cars.add(new Car("VIN1", "Camry", "Toyota", 2022, 20000, 25000, CarType.SEDAN));
        cars.add(new Car("VIN2", "X5", "BMW", 2023, 15000, 60000, CarType.SUV));
        cars.add(new Car("VIN1", "Camry", "Toyota", 2022, 20000, 25000, CarType.SEDAN));
        cars.add(new Car("VIN3", "Camry", "Toyota", 2021, 19847, 25022, CarType.SEDAN));

        System.out.println("Количество машин: " + cars.size());

        for (Car car : cars) {
            System.out.println(car);
        }

        List<Car> sortedCars = new ArrayList<>(cars);
        Collections.sort(sortedCars);

        System.out.println("Сортировка по году:");

        for (Car car : sortedCars) {
            System.out.println(car);
        }
    }
}

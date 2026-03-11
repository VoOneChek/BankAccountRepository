package Tasks;

import java.util.Random;

public class Task1Arrays {
    static void main() {

        int[] cars = new int[50];
        Random random = new Random();

        int currentYear = 2026;

        for (int i = 0; i < cars.length; i++) {
            cars[i] = 2000 + random.nextInt(27);
        }

        System.out.println("Машины после 2015 года:");

        for (int year : cars) {
            if (year > 2015) {
                System.out.println(year);
            }
        }

        int totalAge = 0;

        for (int year : cars) {
            totalAge += (currentYear - year);
        }

        double averageAge = (double) totalAge / cars.length;

        System.out.println("Средний возраст машин: " + averageAge);
    }
}

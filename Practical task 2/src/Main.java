import AdditionalTask.CarDealership;
import AdditionalTask.CarType;
import Tasks.Three.Car;

void main() {
    Scanner scanner = new Scanner(System.in);
    CarDealership dealership = new CarDealership();

    while (true) {

        System.out.println("\n1 Добавить машину");
        System.out.println("2 Найти по производителю");
        System.out.println("3 Сортировка по году");
        System.out.println("4 Самая старая машина");
        System.out.println("5 Самая новая машина");
        System.out.println("0 Выход");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {

            case 1:
                System.out.println("VIN:");
                String vin = scanner.nextLine();

                System.out.println("Модель:");
                String model = scanner.nextLine();

                System.out.println("Производитель:");
                String manufacturer = scanner.nextLine();

                System.out.println("Год:");
                int year = scanner.nextInt();

                System.out.println("Пробег:");
                int mileage = scanner.nextInt();

                System.out.println("Цена:");
                double price = scanner.nextDouble();

                System.out.println("Выберите тип машины:");

                CarType[] types = CarType.values();

                for (int i = 0; i < types.length; i++) {
                    System.out.println((i + 1) + " - " + types[i]);
                }

                int typeChoice = scanner.nextInt();

                CarType type = types[typeChoice - 1];

                scanner.nextLine();

                Car car = new Car(vin, model, manufacturer, year, mileage, price, type);

                dealership.addCar(car);
                break;

            case 2:
                System.out.println("Введите производителя:");
                String m = scanner.nextLine();

                System.out.println(dealership.findByManufacturer(m));
                break;

            case 3:
                System.out.println(dealership.sortByYear());
                break;

            case 4:
                System.out.println(dealership.oldestCar().orElse(null));
                break;

            case 5:
                System.out.println(dealership.newestCar().orElse(null));
                break;

            case 0:
                return;
        }
    }
}

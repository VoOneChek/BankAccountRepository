package Tasks;

import java.util.*;

public class Task2Collections {
    static void main() {

        Set<String> uniqueModels = getStrings();

        List<String> sortedModels = new ArrayList<>(uniqueModels);

        sortedModels.sort(Collections.reverseOrder());

        System.out.println("Отсортированные модели:");

        for (String model : sortedModels) {
            System.out.println(model);
        }

        Set<String> resultSet = new HashSet<>(sortedModels);

        System.out.println("Set моделей: " + resultSet);
    }

    private static Set<String> getStrings() {
        List<String> models = new ArrayList<>();

        models.add("Toyota Camry");
        models.add("BMW X5");
        models.add("Tesla Model S");
        models.add("BMW X5");
        models.add("Audi A6");
        models.add("Tesla Model 3");

        for (int i = 0; i < models.size(); i++) {
            if (models.get(i).contains("Tesla")) {
                models.set(i, "ELECTRO_CAR");
            }
        }

        return new HashSet<>(models);
    }
}
